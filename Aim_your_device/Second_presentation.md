<!--Heading-->
# 진행상황 발표

<br/>

### 지난 발표

[지난 발표 자료](https://github.com/ChangJinMoon/My_Workspace/blob/master/Aim_your_device/First_presentaion.md)

<br/>

## _Client_
## 1. 위도와 경도 받기(IOS)
____

+ locationManager 인스턴스 생성 및 위치 추적 권환 요청
  - 앱을 실행할때 위치 추적 권한 요청
  
```swift
        //locationManager 인스턴스 생성 
        locationManager = CLLocationManager()
        locationManager.delegate = self
        
        //앱 실행을 위한 위치 추적 권한 요청
        locationManager.requestWhenInUseAuthorization()
```

<br/>

  - 위치 업데이트를 통한 위도 경도 받기
    + 위도 경도를 받아 저장
  
  ```swift
        //배터리에 맞게 최적의 정확도 자동 설정
        locationManager.desiredAccuracy = kCLLocationAccuracyBest
        
        //위치업데이트
        locationManager.startUpdatingLocation()
        
        //위도 경도 가져오기
        let coor = locationManager.location?.coordinate
        latitude = coor?.latitude
        longitude = coor?.longitude
  ```
  <br/>
  
  + ### 이후 추가 개발 계획
    - 실시간으로 위치 데이터 받아 출력 받는 기능 구현 예정
    - 간단한 ui 개발
  
<br/>

## 2. Server
___
<br/>

+ ### 위도,경도 받아서 한국 도로명 주소로 변환
  <br/>
  
    > NaverMapApi 연결
    
    ```java
      String getApiAddress() {
	      String apiURL = "https://naveropenapi.apigw.ntruss.com/map-reversegeocode/v2/gc?request=coordsToaddr&coords="
		  + longitude + "," + latitude + "&orders=addr,roadaddr&output=json";
	      return apiURL;
      }
    ```
    <br/>
    
   > NaverMapApi 연결이후 도로명 주소 Json 형식으로 받기 
    
    ```java
       String getJSONData(String apiURL) throws Exception {
		String jsonString = new String();
		String buf;
		URL url = new URL(apiURL);
		URLConnection conn = url.openConnection();
		// conn.setRequestProperty("Content-Type","application/json");
		conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", "xgundembra");
		conn.setRequestProperty("X-NCP-APIGW-API-KEY", "GBV0ga1iRMmXljxEAjpwMq1hefwYZRorXoRPpMkW");
		conn.connect();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		while ((buf = br.readLine()) != null) {
		  jsonString += buf;
	      }
	      return jsonString;
      }
    ```
    <br/>  
    
    > Api로 부터 받은 도로명 주소 파싱
    
    ```java
       String jsonPassing() {// 파싱
            String f_address = "";

            JsonParser parser = new JsonParser();
            JsonObject obj = (JsonObject) parser.parse(regionAddress);
            JsonArray array = (JsonArray) obj.get("results");

            JsonObject addr = (JsonObject) array.get(0);// region
            JsonObject roadaddr = (JsonObject) array.get(1);//

            JsonObject region = (JsonObject) addr.get("region");
            JsonObject land2 = (JsonObject) addr.get("land");
            JsonObject land = (JsonObject) roadaddr.get("land");

            JsonObject area[] = new JsonObject[3];
            JsonObject addition0 = (JsonObject) land.get("addition0");

            area[0] = (JsonObject) region.get("area1");
            area[1] = (JsonObject) region.get("area2");
            area[2] = (JsonObject) region.get("area3");

            JsonElement element;

            String space = "";
            for (int i = 0; i < area.length; i++) {
              if (i != 0)
                space = " ";
              element = area[i].get("name");
              f_address += space + element.getAsString();
            }

            f_address += " " + (element = land2.get("number1")).getAsString();
            f_address += "-" + (element = land2.get("number2")).getAsString();
            f_address += " " + (element = addition0.get("value")).getAsString();

            return f_address;
	      }
    ```
    <br/>
    
    > 위도,적도,도로명 주소,시간등을 db에 저장
    
    ```java
     save_location(Connection con, String id, double lat, double lng,int case_)throws Exception {
        // 한국 표준시간 저장
        TimeZone time;
        Date realTime = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");
        time = TimeZone.getTimeZone("Asia/Seoul");
        df.setTimeZone(time);

        // 시간 저장 순서 찾기
        try {
          sql = "select count from location where id = ? order by count desc";// 제일 최근 데이터
          pstmt = con.prepareStatement(sql);
          pstmt.setString(1,id);
          rs = pstmt.executeQuery();
          if (rs.next()) {// 데이터있을때 카운트 하나증가시키기
            if(next_count == 0) {
              count = rs.getInt("count");
              next_count++;
            }
          } 
          count++;
          // 좌표로 지번 찾기 
          Get_Address get_in_kAddress = new Get_Address(lat,lng);
          k_address = get_in_kAddress.getAddress();

          // 데이터 저장
          sql = "insert into location values(?,?,?,?,?,?)";
          pstmt = con.prepareStatement(sql);
          pstmt.setString(1, id);
          pstmt.setDouble(2, lat);
          pstmt.setDouble(3, lng);
          pstmt.setString(4, k_address);
          pstmt.setString(5,df.format(realTime));
          pstmt.setInt(6, count);

          pstmt.executeUpdate();
          err = "update_save_loc";

          if(case_ == 1) {
            sql ="delete from location where id =?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
          }
        } catch (SQLException e) {
          err = "save_location_sql error" + e;
        }
	}
    ```
    <br/>  
    
 + ### 이후 추가 개발 계획
   - 클라이언트와 연동 작업 
   - 비슷한 주소끼리 그룹화 -> count가 가장 많이 된 주소를 집으로 지정하는 기능 추가
    
<br/>
<br/>

