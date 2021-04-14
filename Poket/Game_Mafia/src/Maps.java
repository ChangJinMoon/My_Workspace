import java.awt.Image;

import javax.swing.ImageIcon;

public class Maps {//imageIcone; // 사물 객체 선언
	int maps[][];
	
	int player_X;
	int player_Y;
	
	
	Maps(){
		maps = new int[100][120];//아무것도 없는 것 0 숫자가 있다면  진행(이x)
		
		for(int i=0;i<100;i++) {
			for(int j =0 ;j<120;j++) {//테두리
				maps[i][j] = 0;
			}
		}
	}
	
	void set_map() {
		
	}
	void Get_Character_X(int x) {
		player_X = x;
	}
	
	void Get_Character_Y(int y) {
		player_Y = y;
	}
	
}