<!--Heading-->
# 진행상황 발표

<br/>
[프레젠테이션 2.pdf](https://github.com/ChangJinMoon/My_Workspace/files/6301662/2.pdf)

> ## 지난 프로젝트 제안서 발표 이후 피드백
 >> 1. 페어링된 블루투스 디바이스 자동 연결 조사
 >> 2. 실내 위치 추적의 정확성 검토
<br/>

## 1. 페어링된 블루투스 디바이스 자동 연결(IOS)
____

+ 페어링 History 생성
  - 한번 연결했을떄 _CentralManager_ 로 해당 객체 저장

<br/>
  
```objectivec
-(void)centralManager:(CBCentralManager *)central didConnectPeripheral:(CBPeripheral *)peripheral {
    [self connectedDonePeriphral];
    [OpenitUtils savePeripheral:peripheral];
    _discoveredPeripheral = peripheral;
    [self performSegueWithIdentifier:@"GoCheckView" sender:self];
}
```

<br/>

  - 이후 자동으로 연결을 원하는 device 연결
    + 제약사항: 해당 device가 PowerOn 상태여야 가능

<br/>
  
  ```objectivec
  - (void)viewDidLoad {
    if([OpenitUtils isSavedPeripheral]) {
        NSString *uuidString = [OpenitUtils getSavedPeripheralUUIDString];
        NSUUID *uuid = [[NSUUID alloc] initWithUUIDString:uuidString];
        NSArray* periphralarray = [_centralManager retrievePeripheralsWithIdentifiers:@[uuid]];
        for(CBPeripheral *periphral in periphralarray) {
            [_peripheralList addObject:periphral];
            _discoveredPeripheral = periphral;
        }
        if(_discoveredPeripheral != nil) {
            [self.tableView reloadData];
            [self showAlert];
        }
    }
}
  ```
  <br/>
  
+ 각 device의 ID를 호출하는 방식으로 자동연결
 
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
        
        
     
