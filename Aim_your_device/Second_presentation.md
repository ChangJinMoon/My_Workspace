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

<br/>
  
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

<br/>
  
  ```objectivec
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

## 2. 실내 위치 추적
___
<br/>

+ ### 문제가 될 만한 상황 정리
  - 1.사용자가 옆,뒤로 걸었을때 추적 가능성
  <br/>
  
  ![참고자료 2](https://user-images.githubusercontent.com/57736889/114497083-47c5c600-9c5c-11eb-92f2-ef85cbe7c3b6.PNG)

  
    > 옆
    > 
      옆으로 걷는 경우 정상적(앞)으로 걷는 것과 센서의 수치(alpha , beta)가 다르게 측정
      -> android 앱으로 간단히 기능을 구현후 테스트 해서 차이값 조사 예정
    
    <br/>
    
    > 뒤
    > 
      뒤로 걷는 경우 정상적(앞)으로 걷는 것과 방향성(alpha)의 차이가 생김
      -> android 앱으로 간단히 기능을 구현후 테스트 해서 차이값 조사 예정
    <br/>  
    
    > 실내 위치추적 정확도 증가를 위한 추가 대안
    > 
      여러가지의 경우(앞으로 가다 옆으로 걷기,지그재그로 걷기등)에 대한 특정 값 조사
      
        1. 사용자마다 측정을 해서 특정 값 목록화
          -> 앱 설정으로 동기화 과정을 추가 삽입
        
        2. 개발자가 측정을 해서 특정 값 목록화
        
        =>택 일하여 진행할 계획
<br/>
<br/>

## 3. 현 개발 상황
____

### 1. 클라이언트
>
 클라이언트 개발을 진행 중이며 ios 프로그래밍을 공부하기 위해서 youtube와 관련 서적 통해 진행하고 있습니다
 지금은 공부하는 단계여서 개발에 진척은 없지만 시험이 끝난 이후부터 본격적인 개발을 진행하려고 계획하고 있습니다
 사용할 Skill -> Xcode , swift
<br/>

### 2. 서버
>
 서버는 서버의 기능중 사용자가 집에 왔을때를 인식하기 위해서 집 데이터를 뽑아내는 
 기능 구현을 위해 serverless framewrok를 이용해서 클라이언트와의 통신을 action trigger를 통해
 진행할 예정이며  지금은 클라이언트가 좌표 데이터를 보내주면 map api을 이용하여 도로명 주소를 뽑아내는 과정까지 진행하고 있습니다.

 사용할 Skill & Platform -> java,json NaverCloudPlatform
([자세한 설명 URL](https://guide.ncloud-docs.com/docs/ko/home#))

