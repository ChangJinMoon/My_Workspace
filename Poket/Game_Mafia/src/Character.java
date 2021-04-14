public class Character {

	int x,y;
	int job;
	int maps[][]= new int[100][120];
	int row ;
	int col ;
	
	
	
	Character(){//시작위치 (1000,700)
	}
	
	void setLocation(int x1,int y1){
		this.x = x1;
		this.y = y1;
		 col = x/10;
		 row = y/10;
			
	}
	
	void get_maps(int[][] array) {//주기적으로 초기호ㅏ
		for(int i=0;i<100;i++) {
			for(int j=0;j<120;j++) {
				this.maps[i][j] = array[i][j];
			}
		}
	}
	
	void leftmove() {
		if(maps[row][col-1] == 1) {
			return;
		}
		else {
			x-=10;
			col --;
		}

	}
	void rightmove() {
		if(maps[row][col+1] == 1) {
			return;
		}
		else {
			x+=10;
			col++;
		}
	}
	void upmove() {
		if(maps[row-1][col] == 1) {
			return;
		}
		else {
			y-=10;
			row --;
		}
	}
	void downmove() {
		if(maps[row+1][col] == 1) {
			return;
		}
		else {
			y+=10;
			row ++;
		}
	}
	
	
	void stop(boolean stop) {
		
		if(stop == true) {
			
		}
	}
	
	
	int getCharacterX() {
		return x;
	}
	
	int getCharacterY() {
		return y;
	}	
}
