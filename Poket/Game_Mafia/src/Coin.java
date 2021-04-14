import java.awt.Image;
import java.awt.Toolkit;

public class Coin {

	int x,y;
	int kinds;
	int score;
	
	Toolkit toolkit = Toolkit.getDefaultToolkit();
		
	Image coinImage ;
			
	Coin(int kinds){
		x= 0;
		y=0;
		this.kinds = kinds;
	}
 
	void set_coin() {
		if(kinds == 1) {
			score =200;
			coinImage = toolkit.getImage("coin_1.png");
		}
		else {
			score = 1000;
			coinImage = toolkit.getImage("coin_2.png");
			}
	}
	
	void get_coin_location(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	int return_coin_location(int r_c) {
		int row = 0;
		int col = 0;
		col = x/10;
		row = y/10;
		if(r_c == 1) {
			return row;
		}
		else return col;
	}
}
