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
	
	void checkMatchingrow() {//target���� �� ���ڸ� �޾� �ѿ��� �˻��ϴ� �ݺ���, ���� ���ڿ� �ٸ� ���ڰ� ������ �ڵ������� target�� �ٸ� ���ڷ� ���ϰ� matchingCount�� �ʱ�ȭ , �� ���� Ȯ���Ҷ����� matchingCount�� 2���� �Ѿ�� �ڵ������� ���� ���ڰ� ���� �迭���� ���ڸ� �ٲ��ִ� �˰����Դϴ�.
		int target = 0,matchCount=1;
		for(int i =0;i<6;i++) {
			target=maps[i][0];int change =0,exmatchCount=0;
			for(int j= 1;j<6;j++) {//target���� �� ���ڸ� �޾� �ѿ��� �˻��ϴ� �ݺ���
				if(j==5&&target==maps[i][j]) {change =j;exmatchCount=++matchCount;matchCount =1;}
				else if(target==maps[i][j]) { matchCount++; target = maps[i][j];}
				else { 
					change =j;exmatchCount=matchCount;//target�� �������� j�� ���� ���ڰ� ���� ������ ��Ÿ���ִ� ���� �Դϴ� 
					target = maps[i][j]; matchCount =1;}// ���� ���ڿ� �ٸ� ���ڰ� ������ �ڵ������� target�� �ٸ� ���ڷ� ���ϰ� matchingCount�� �ʱ�ȭ
				
			if(matchCount==1) {switch(exmatchCount) { //�� ���� Ȯ���Ҷ����� matchingCount�� 2���� �Ѿ�� �ڵ������� ���� ���ڰ� ���� �迭���� ���ڸ� �ٲ��ִ� �˰����Դϴ�.
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

	public void refill() { // ������ �ҽ�
        for(int y=5; y>=1; y--) {
            for(int x=5; x>=0; x--) {
                if(maps[y][x]==5) { 
                    // maps[y][x]=maps[y-1][x];

                     ///////////////////////////////////////////////
                    // [Code1] ���� �ִ� ĭ���߿��� ������� ���� ĭ�� ����� �̵�
                    int i;
                    for(i = y-1; i > 0 && maps[i][x] == 5 ; --i )  // �������� ù ��� ã��
                        ;
                    if (maps[i][x] != 5) {    // �������� ����� �ִٸ� drop.
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
                 // [Code2] ����ĭ�� ����ִٸ�, �� ��ĭ�� ��������� ����.                    
                int i;
                for(i = 0; i <6 && maps[i][x]==5 ; ++i) { // ��ĭ�� �߰ߵ��� �ʴ� ���� ����� ä��
                    maps[i][x]=(int)(Math.random()*5);
                    while(maps[i][x]==5)
                    	maps[i][x]=(int)(Math.random()*5);
                }
                ////////////////////////////////////////////////////////////////
            }
   }
	
	
 }
