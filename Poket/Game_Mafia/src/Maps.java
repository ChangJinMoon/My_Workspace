import java.awt.Image;

import javax.swing.ImageIcon;

public class Maps {//imageIcone; // �繰 ��ü ����
	int maps[][];
	
	int player_X;
	int player_Y;
	
	
	Maps(){
		maps = new int[100][120];//�ƹ��͵� ���� �� 0 ���ڰ� �ִٸ�  ����(��x)
		
		for(int i=0;i<100;i++) {
			for(int j =0 ;j<120;j++) {//�׵θ�
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