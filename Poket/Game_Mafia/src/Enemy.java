import java.awt.Image;
import java.awt.Toolkit;


public class Enemy extends Character{


	int location_row;
	int location_col;
	int direct,move;
	int virtual_x,virtual_y;

	Image moveImage[][] = new Image[4][3];
	Toolkit toolkit =  Toolkit.getDefaultToolkit();
	Stack stack;
	
	public Enemy(){
		this.job = 3;
		setImage();
		virtual_x = 0;
		virtual_y = 0;
	
	}
	
	void start_Chaseing() {// 사용 
		
		maps[row][col]= 2;//자기 자신 위치
		targeting_user();
		virtual_x = x;
		virtual_y = y;
		stack = new Stack();
		saveRoute(row,col);
	
		
	}
	
	void saveRoute(int row ,int col) {
		Value value = new Value();
		int  row_1 = row ,col_1 = col;
		
		while(maps[row_1][col_1] != 9) {
			saveDirection(row_1,col_1);
			maps[row_1][col_1] = 5;
			value = stack.pop();// 스텍에 쌓여있는 row와 col값을 받기위해 사용 
			row_1 = value.row;
			col_1 = value.col;
			virtual_x = col_1*10;
			virtual_y = row_1 *10;
		}
	}
	
	
	void move() {	//사용 
		if(maps[row-1][col] == 5) {
			upmove();
			direct =0;move++;
		}
		else if(maps[row+1][col] == 5) {
			downmove();
			direct =1; move++;
		}
		else if(maps[row][col+1] == 5) {
			rightmove();
			direct =2; move++;
		}
		else if(maps[row][col-1] == 5) {
			leftmove();
			direct =3; move++;
		}
		else 
			return ;
	}
	
	void getUserLocation(int x,int y) {//매번 초기화
		this.location_row = y/10;
		this.location_col = x/10;
	}
	
	void targeting_user() {
		maps[location_row][location_col] = 9;//9는 유저가 있는 위치를 표기 추척하기 위함 1은 장애물 5는 방문한곳  
	}
	
	void saveDirection(int r, int c) {
		//스택은 FILO라서 
		switch(find_direction()) {
			case 1://좌상 //목표가 좌상, x 음 y 음수 	확인순서 -우 -하 -상 -좌
				check_right(r,c);
				check_down(r,c);
				check_up(r,c);
				check_left(r,c);
				break;
			case 2://우상 //목표가 우상, x 양수 y 음수  확인순서 -좌 -하 -상 -우
				check_left(r,c);
				check_down(r,c);
				check_up(r,c);
				check_right(r,c);
				break;
			case 3://좌하 //목표가 좌하, x 음 y 양수 	확인순서 -우 -상 -하 -좌
				check_right(r,c);
				check_up(r,c);
				check_down(r,c);
				check_left(r,c);
				break;
			case 4://우하 //목표가 우하, x 양 y 양 	확인순서 -좌 -상 -하 -우
				check_left(r,c);
				check_up(r,c);
				check_down(r,c);
				check_right(r,c);
				break;
			case 5:// 상좌우하
				check_down(r,c);
				check_right(r,c);
				check_left(r,c);
				check_up(r,c);
				break;
			case 6://하좌우상
				check_up(r,c);
				check_left(r,c);
				check_right(r,c);
				check_down(r,c);
				break;
				
		}

	}
	
	
	void check_down(int r,int c) {
		if (maps[r+ 1][c] != 1 && maps[r + 1][c]!= 5) {// 아래 확인
			stack.push(r+1, c);
			return ;
		}
	}
	
	void check_up(int r,int c) {
		if (maps[r -1][c] != 1 && maps[r - 1][c] != 5) {//위 확인
			stack.push(r-1, c);
			return ;
		}
	}
	
	void check_right(int r,int c) {
		if (maps[r][c+1] != 1 && maps[r][c+1] != 5) {//우측	
			stack.push(r, c+1);
			return ;
		}
	}
	
	void check_left(int r,int c) {
		if (maps[r][c-1] != 1 && maps[r][c-1] != 5) {//좌측	
			stack.push(r, c-1);
			return ;
		}
	}
	
	
	int find_direction() {
		int gap_x;
		int gap_y;
		gap_y =location_row*10 - virtual_y; 
		gap_x =location_col*10 - virtual_x; 
		
		if(gap_y <0) {//목표가 상 y 음수
			if(gap_x<0) {
				return 1;// 좌상
			}
			else if(gap_x==0) {//
				return 5;//상좌우하
			}
			else
				return 2;//우상
		}
		else if(gap_y==0){
			if (gap_x<0) {
				return 1;// 좌상
			}
			else
				return 2;
		}
		else{
			if(gap_x<0) {//목표가 하 y양수
				return 3;// 좌하
			}
			else if(gap_x==0) {
				return 6;//하 좌 우 상
			}
			else 
				return 4;//우하
		}
		//목표가 우상, x 양수 y 음수  확인순서 -좌 -하 -상 -우
		//목표가 좌상, x 음 y 음수 	확인순서 -우 -하 -상 -좌
		//목표가 좌하, x 음 y 양수 	확인순서 -우 -상 -하 -좌
		//목표가 우하, x 양 y 양 		확인순서 -좌 -상 -하 -우
	}
	

	
	
	boolean react() {
		if(maps[row][col] == 6) {
			return true;
		}
		else return false;
	}
	
	
	
	void setImage() {
		moveImage[0][0]=toolkit.getImage("Enemy_Up_stop.png");
		moveImage[0][1]=toolkit.getImage("Enemy_Up_move_1.png");
		moveImage[0][2]=toolkit.getImage("Enemy_Up_move_2.png");
		
		moveImage[1][0]=toolkit.getImage("Enemy_Down_stop.png");
		moveImage[1][1]=toolkit.getImage("Enemy_Down_move_1.png");
		moveImage[1][2]=toolkit.getImage("Enemy_Down_move_2.png");
		
		moveImage[2][0]=toolkit.getImage("Enemy_Right_stop.png");
		moveImage[2][1]=toolkit.getImage("Enemy_Right_move_1.png");
		moveImage[2][2]=toolkit.getImage("Enemy_Right_move_2.png");
		
		moveImage[3][0]=toolkit.getImage("Enemy_Left_stop.png");
		moveImage[3][1]=toolkit.getImage("Enemy_Left_move_1.png");
		moveImage[3][2]=toolkit.getImage("Enemy_Left_move_2.png");
		
		
	}
	
}
