import java.awt.Image;
import java.awt.Toolkit;

public class Citizen extends Character {
	
	boolean mafia;
	int playerNum;
	
	Image moveImage[][] = new Image[4][3];
	Toolkit toolkit =  Toolkit.getDefaultToolkit();
	public Citizen(){
		this.job =2;
		mafia = false;
		setImage();
	}
	
	boolean return_job() {
		return mafia;
	}
	
	void get_PlayerNum(int num) {
		playerNum = num;
	}
	
	int return_PlayerNum() {
		return playerNum;
	}
	
	
	void setImage() {
		moveImage[0][0]=toolkit.getImage("Citizen_Up_stop.png");
		moveImage[0][1]=toolkit.getImage("Citizen_Up_move_1.png");
		moveImage[0][2]=toolkit.getImage("Citizen_Up_move_2.png");
		
		moveImage[1][0]=toolkit.getImage("Citizen_Down_stop.png");
		moveImage[1][1]=toolkit.getImage("Citizen_Down_move_1.png");
		moveImage[1][2]=toolkit.getImage("Citizen_Down_move_2.png");
		
		moveImage[2][0]=toolkit.getImage("Citizen_Right_stop.png");
		moveImage[2][1]=toolkit.getImage("Citizen_Right_move_1.png");
		moveImage[2][2]=toolkit.getImage("Citizen_Right_move_2.png");
		
		moveImage[3][0]=toolkit.getImage("Citizen_Left_stop.png");
		moveImage[3][1]=toolkit.getImage("Citizen_Left_move_1.png");
		moveImage[3][2]=toolkit.getImage("Citizen_Left_move_2.png");
		
		
	}
	
}
