<!--Heading-->
# 진행상황 발표

<br/>

### 지난 발표

[지난 발표 자료](https://github.com/ChangJinMoon/My_Workspace/blob/master/Aim_your_device/Second_presentaion.md)

<br/>

### 지난 발표 이후 피드백
  1. 해당 어플리케이션의 기능을 어디에 사용,적용할수 있을지..
  + 실내 위치추적 기능 -> 
  <br>
  
  + aim tracking(휴대폰이 가르키는 곳 위치 인식) 기능 -> 
    
  2. 졸작 발표때 데모는 어떻게 할 것인지..
  + 대면: 실습실을 가상의 집,방으로 설정 이후, 여러가지 블르투스 기기를 배치하고 어플리케이션 작동을 실시간으로 교수님들께 보여드릴 예정
  + 비대면: 데모 실행 영상을 제작
  <br>
    
  3. 사용자가 아파트에 살때 집 주소를 특정 가능한지
  + 아파트의 경우에도 위도와 경도의 값은 크게 변동이 없음
  + Naver Map Api에 위도와 경도를 보내면 도로명 주소를 받기 때문에 해당 위도와 경도의 값으 크게 변하지 않는 이상 같은 주소를 return
  <br>

## _Client_
## 1. 실내 위치추적 기능(Android)
____

+ ### 테스트를 위해서 안드로이드로 이용
  - 해당 테스트를 완료 하면 추후 ios에 적용예정

 ### 1) 센서 값을 바탕으로 사용자의 걸음 특징 추출 
  - 사용자에게 앞으로 걷기, 옆으로 걷기, 뒤로 걷기 등을 미리 진행하여 걸음 특징 추출
  - 이후 미리 추룰한 걸음 특징을 바탕으로 옆으로 걷는지 앞으로 걷는지 등을 인식

+ SensorManager로 부터 각종 Sensor 값 받아오기 
  - 중력 가속도 + 가속도 센서(x,y,z) + 방향센서
  
```java

       mSensorManger = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
       mOrientation = mSensorManger.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
       linearSensor = mSensorManger.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
       mOrientation2 = mSensorManger.getDefaultSensor(Sensor.TYPE_ORIENTATION);
       
       @Override
       protected void onResume() {
            super.onResume();
            // SensorEventListener 등록 (60.000 microsecond delay)
            mSensorManger.registerListener(this, mOrientation, SensorManager.SENSOR_DELAY_UI);
            mSensorManger.registerListener(this, linearSensor, SensorManager.SENSOR_DELAY_UI);
            mSensorManger.registerListener(this, mOrientation2, SensorManager.SENSOR_DELAY_UI);
       }
```

<br/>

  - 테스트를 시작하면 해당 센서 값들을 저장
    + 60.000 microsecond에 한번씩 값을 받아온 후 배열에 저장
    + 사용자가 시작 버튼을 누른 상태에서 부터 저장 시작, 5초가 지나면 자동 종료
  
  ```java
        public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            mText.setText("중력 센서값\n\nx : " + event.values[0]
                    + "\ny: " + event.values[1] + "\nz: " + event.values[2]);
            save_sensor_value(1,event.values[1]);
        }else if(event.sensor.getType() == Sensor.TYPE_LINEAR_ACCELERATION){
            linearText.setText("가속도 센서값\n\nx: " + event.values[0]
                    + "\ny: " + event.values[1] + "\nz: " + event.values[2]);
            save_sensor_value(2,event.values[1]);
        }else if(event.sensor.getType() == Sensor.TYPE_ORIENTATION){
            mText2.setText("방향 센서값\n\nx: " + event.values[0]
                    + "\ny: " + event.values[1] + "\nz: " + event.values[2]);
            save_sensor_value(3,event.values[1]);
        }
    }
  ```
  <br/>
  
  ### 2) 미리 저장된 센서 값으로 사용자의 걸음 진행 상태를 추출(진행중) 
  - 앞으로 걷기, 뒤로 걷기는 성공 했으나 옆으로 걷기가 정확도가 떨어짐
  - 비교 센서값 추가, 미리 저장된 값을 바탕으로 정확도를 올릴 예정

  
  + ### 이후 추가 개발계획
    - 옆으로 걷기 인식 정확도를 올리고 더 다양한 걸음 특징 추출 예정(지그재그 걷기, 앞으로가다 옆으로 방향 전환등)
    - 해당 테스트가 성공적으로 끝나면 ios 이식
    
  
<br/>

## 2. Server
___
<br/>

+ 서버의 기능 정리
  - 1) 클라이언트 마다 임의의 아이디 지정(구현완료)
  - 2) 해당 id를 바탕으로 사용자의 정보 저장 및 관리(구현완료)
  - 3) 집 주소 찾는 알고리즘을 통해 사용자의 집 주소 특정(구현완료)
    + 정확도를 올리기 위해 세개의 집 후보군 설정, 이후 사용자에게 해당 정보가 맞는지 확인
  - 4) 이후 사용자의 위치를 실시간으로 추적 후 집에 있다는 걸 인식하면 클라이언트에게 알림(구현완료)

    
 + ### 이후 추가 개발 계획
   - 클라이언트와 연동 작업 
    
<br/>
<br/>

