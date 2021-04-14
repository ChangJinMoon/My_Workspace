import java.awt.*;        
import javax.swing.*;  
import java.util.*;
import java.util.concurrent.TimeUnit;
//bgmstore.net
 class GameContro {
	int maps[][] = new int [6][6];
	int x1 ,y1,x2,y2,row,col ;
	boolean keepGoing = false;
	Data data = new Data();
	GameContro(){
	for(int i=0;i<6;i++) {
		for(int j=0;j<6;j++) {
			maps[i][j] =(int)(Math.random()*5);
		}}
	}

	
	void getNum(int ex1,int ey1,int nx2,int ny2) {
	 x1=ex1;y1=ey1;x2=nx2;y2=ny2;
	}
	
	
	boolean check() {
	if(x1 == x2) {
		if(y1-y2 == 1|| y2-y1 ==1) {
			keepGoing = true;}
		else
			keepGoing =false;}
	else if(y1==y2) {
		if(x1-x2 == 1||x2-x1==1) {
			keepGoing = true;}
		else
			keepGoing =false;}
	else {
		keepGoing = false;}
	return keepGoing;
	}
	
	void checkMatchingrow() {//target으로 한 숫자를 받아 한열을 검사하는 반복문, 이전 숫자와 다른 숫자가 나오면 자동적으로 target은 다른 숫자로 변하고 matchingCount는 초기화 , 매 열을 확인할때마다 matchingCount가 2개가 넘어가면 자동적으로 같은 숫자가 나온 배열부터 숫자를 바꿔주는 알고리즘입니다.
		int target = 0,matchCount=1;
		for(int i =0;i<6;i++) {
			target=maps[i][0];int change =0,exmatchCount=0;
			for(int j= 1;j<6;j++) {//target으로 한 숫자를 받아 한열을 검사하는 반복문
				if(j==5&&target==maps[i][j]) {change =j;exmatchCount=++matchCount;matchCount =1;}
				else if(target==maps[i][j]) { matchCount++; target = maps[i][j];}
				else { 
					change =j;exmatchCount=matchCount;//target이 변했을때 j는 같은 숫자가 끝난 지점을 나타내주는 변수 입니다 
					target = maps[i][j]; matchCount =1;}// 이전 숫자와 다른 숫자가 나오면 자동적으로 target은 다른 숫자로 변하고 matchingCount는 초기화
				
			if(matchCount==1) {switch(exmatchCount) { //매 열을 확인할때마다 matchingCount가 2개가 넘어가면 자동적으로 같은 숫자가 나온 배열부터 숫자를 바꿔주는 알고리즘입니다.
			case 3: change -= 3;data.score+=500;
				for(int z = 0;z<3;z++) {maps[i][change+z]=5;}break; 
			case 4: change -= 4;data.score+=1000;
				for(int z = 0;z<4;z++) {maps[i][change+z]=5;}break; 
			case 5: change -= 5; data.score+=1500;
				for(int z = 0;z<5;z++) {maps[i][change+z]=5;}break; 
			case 6: change -= 6; data.score+=2000;
				for(int z = 0;z<6;z++) {maps[i][change+z]=5;}break;}
			refill();}
			else 
				continue;}
		}
	}
	
	void checkMatchingcol() {
		int target = 0,matchCount=1;
		for(int j =0;j<6;j++) {
			target=maps[0][j];int change=0,exmatchCount=0;
			for(int i= 1;i<6;i++) {
				if(i==5&&target==maps[i][j]) {change =i;exmatchCount=++matchCount;matchCount =1;}
				else if(target==maps[i][j]) { ++matchCount; target = maps[i][j];}
				else { 
					change =i; exmatchCount =matchCount;
					target = maps[i][j]; matchCount =1;}
				
			if(matchCount==1) {switch(exmatchCount) {
			case 3: change -= 3;data.score+=500;
				for(int z = 0;z<3;z++) {maps[change+z][j]=5;}break; 
			case 4: change -= 4;data.score+=1000;
				for(int z = 0;z<4;z++) {maps[change+z][j]=5;}break; 
			case 5: change -=5; data.score+=1500;
				for(int z = 0;z<5;z++) {maps[change+z][j]=5;}break;
			case 6: change -= 6;data.score+=2000; 
				for(int z = 0;z<6;z++) {maps[change+z][j]=5;}break;}
			refill();
			}
			else 
				continue;}
		}
	}

	public void refill() { // 교수님 소스
        for(int y=5; y>=1; y--) {
            for(int x=5; x>=0; x--) {
                if(maps[y][x]==5) { 
                    // maps[y][x]=maps[y-1][x];

                     ///////////////////////////////////////////////
                    // [Code1] 위에 있는 칸들중에서 비어있지 않은 칸의 블록을 이동
                    int i;
                    for(i = y-1; i > 0 && maps[i][x] == 5 ; --i )  // 비지않은 첫 블록 찾음
                        ;
                    if (maps[i][x] != 5) {    // 비지않은 블록이 있다면 drop.
                        maps[y][x] = maps[i][x];    
                        maps[i][x] = 5;
                    }
                    ////////////////////////////////////////////////
               }
            }
        }
        for(int x=0; x<6; x++) 
            if(maps[0][x]==5) {

                 //////////////////////////////////////////////////////////////
                 // [Code2] 맨위칸이 비어있다면, 그 밑칸도 비어있을수 있음.                    
                int i;
                for(i = 0; i <6 && maps[i][x]==5 ; ++i) { // 빈칸이 발견되지 않는 동안 블록을 채움
                    maps[i][x]=(int)(Math.random()*5);
                    while(maps[i][x]==5)
                    	maps[i][x]=(int)(Math.random()*5);
                }
                ////////////////////////////////////////////////////////////////
            }
   }
	
	
 }
