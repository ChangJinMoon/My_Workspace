
public class Special_enemy extends Enemy {

	public Special_enemy() {
		this.job = 4;
		setImage();
		virtual_x = 0;
		virtual_y = 0;
	
	}
	// 오버라이딩 
	
//	void move() {	//사용 
//		if(maps[row-2][col] == 5) {
//			upmove();
//			direct =0;move++;
//		}
//		else if(maps[row+2][col] == 5) {
//			downmove();
//			direct =1; move++;
//		}
//		else if(maps[row][col+2] == 5) {
//			rightmove();
//			direct =2; move++;
//		}
//		else if(maps[row][col-2] == 5) {
//			leftmove();
//			direct =3; move++;
//		}
//		else 
//			return ;
//	}
//	
//	void check_down(int r,int c) {
//		if (maps[r+ 2][c] != 1 && maps[r + 2][c]!= 5) {// 아래 확인
//			if (maps[r+ 1][c] != 1) { 
//			stack.push(r+2, c);
//			return ;
//			}
//		}
//	}
//	
//	void check_up(int r,int c) {
//		if (maps[r -2][c] != 1 && maps[r - 2][c] != 5) {//위 확인
//			if (maps[r-1][c] != 1) { 
//				stack.push(r-2, c);
//				return ;
//				}
//		}
//	}
//	
//	void check_right(int r,int c) {
//		if (maps[r][c+2] != 1 && maps[r][c+2] != 5) {//우측	
//			if (maps[r][c+1] != 1) { 
//				stack.push(r, c+2);
//				return ;
//				}
//		}
//	}
//	
//	void check_left(int r,int c) {
//		if (maps[r][c-2] != 1 && maps[r][c-2] != 5) {//좌측	
//			if (maps[r][c-1] != 1) { 
//				stack.push(r, c-2);
//				return ;
//				}
//		}
//	}
//	
//	void leftmove() {
//		if(maps[row][col-1] == 1||maps[row][col-2] == 1) {
//			return;
//		}
//		else {
//			x-=20;
//			col -=2;
//		}
//
//	}
//	void rightmove() {
//		if(maps[row][col+1] == 1||maps[row][col+2] == 1) {
//			return;
//		}
//		else {
//			x+=20;
//			col+=2;
//		}
//	}
//	void upmove() {
//		if(maps[row-1][col] == 1||maps[row-2][col] == 1) {
//			return;
//		}
//		else {
//			y-=20;
//			row -=2;
//		}
//	}
//	void downmove() {
//		if(maps[row+1][col] == 1||maps[row+2][col] == 1) {
//			return;
//		}
//		else {
//			y+=20;
//			row -=2;
//		}
//	}
	
	void setImage() {
		moveImage[0][0]=toolkit.getImage("special_Up_stop.png");
		moveImage[0][1]=toolkit.getImage("special_Up_move_1.png");
		moveImage[0][2]=toolkit.getImage("special_Up_move_2.png");
		
		moveImage[1][0]=toolkit.getImage("special_Down_stop.png");
		moveImage[1][1]=toolkit.getImage("special_Down_move_1.png");
		moveImage[1][2]=toolkit.getImage("special_Down_move_2.png");
		
		moveImage[2][0]=toolkit.getImage("special_Right_stop.png");
		moveImage[2][1]=toolkit.getImage("special_Right_move_1.png");
		moveImage[2][2]=toolkit.getImage("special_Right_move_2.png");
		
		moveImage[3][0]=toolkit.getImage("special_Left_stop.png");
		moveImage[3][1]=toolkit.getImage("special_Left_move_1.png");
		moveImage[3][2]=toolkit.getImage("special_Left_move_2.png");
		
		
	}
	
}
