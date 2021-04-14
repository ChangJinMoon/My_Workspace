import java.awt.Image;

import javax.swing.ImageIcon;

public class Morning extends Maps {

	ImageIcon q = new ImageIcon("Room(final).png");
	Image Room = q.getImage();
	
	ImageIcon p = new ImageIcon("Block.png");
	Image block = p.getImage();
	
	Morning(){
		setMaps();
	}
	
	void setMaps() {// 수정 
		for(int i=0;i<100;i++) {
			for(int j =0 ;j<120;j++) {//테두리
			maps[0][j] = 1;
			maps[i][0] = 1;
			if(i == 94) maps[i][j] = 1;
			if(j == 116) maps[i][j] = 1;
			}
		}
		for(int i=10;i<25;i++) {// i는 가로 5는 세로 길이 9는 시작 세로점 
			makeMiro(4,i,10);
		}
		for(int i =10;i<25;i++) {
			makeMiro(1,i,30);
		}
		for(int i =90;i<105;i++) {
			makeMiro(4,i,10);
		}
		for(int i =90;i<105;i++) {
			makeMiro(1,i,30);
		}
		for(int i =52;i<62;i++) {
			makeMiro(5,i,7);
		}
		for(int i =52;i<62;i++) {
			makeMiro(5,i,37);
		}
		for(int i =52;i<62;i++) {
			makeMiro(5,i,67);
		}
		for(int i =10;i<25;i++) {
			makeMiro(1,i,58);
		}
		for(int i =10;i<25;i++) {
			makeMiro(4,i,72);
		}
		for(int i =90;i<105;i++) {
			makeMiro(1,i,58);
		}
		for(int i =90;i<105;i++) {
			makeMiro(4,i,72);
		}
		for(int i =35;i<40;i++) {
			makeMiro(6,i,0);
		}
		for(int i =35;i<40;i++) {
			makeMiro(6,i,55);
		}
		
		for(int i =75;i<80;i++) {
			makeMiro(6,i,0);
		}
		for(int i =75;i<80;i++) {
			makeMiro(6,i,55);
		}
		
		for(int i =0;i<30;i++) {
			makeMiro(7,i,46);
		}
		for(int i =85;i<116;i++) {
			makeMiro(7,i,46);
		}
	
		
	}
	
	void makeMiro(int blockNum,int col,int startpoint) {
		switch(blockNum) {
			case 1:
				for(int i = startpoint;i<startpoint+7;i++) maps[i][col] =1;
				break;
			case 2:
				for(int i = startpoint;i<startpoint+9;i++) maps[i][col] =1;
				break;
			case 3:
				for(int i = startpoint;i<startpoint+11;i++) maps[i][col] =1;
				break;
			case 4:
				for(int i = startpoint;i<startpoint+13;i++) maps[i][col] =1;
				break;
			case 5:
				for(int i = startpoint;i<startpoint+20;i++) maps[i][col] =1;
				break;
			case 6:
				for(int i = startpoint;i<startpoint+40;i++) maps[i][col] =1;
				break;
			case 7:
				for(int i = startpoint;i<startpoint+5;i++) maps[i][col] =1;
				break;
		}
	}
	
}

