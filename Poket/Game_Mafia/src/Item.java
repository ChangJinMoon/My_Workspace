import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

public class Item {

	Random random = new Random();
	
	Coin coin[] =new Coin[20];
	Image plus_enemy;
	Toolkit toolkit =  Toolkit.getDefaultToolkit();
	
	Item(){
		set_coins_location();
		plus_enemy = toolkit.getImage("item_1.png");
	}
	
	void plus_Enemy(Character character) {//추가 필요 
		character.setLocation(600,200);
	}
	
	int coin_score(int num) {//종류별로 점수를 다르게 리턴하여 라운드 객체에서 점수에 더해준다 
		int score= 0;
		switch(num) {
			case 1:
				score = 300;
			case 2:
				score =  1000;
		}
		return score;
	}
	
	void set_coins_location() {//coin 객체에 대한 초기화 메소드 
		int randomN;
		for(int i = 0 ; i < 20;i++) {
			randomN = random.nextInt(2);
			coin[i] = new Coin(randomN);
			coin[i].set_coin();//종류별 이미지 지정
			coin[i].get_coin_location(return_item_location(1),return_item_location(0));//위치 지정 
		}
	}
	
	int return_item_location(int r_c) { //row =1
		int randomN;
	
		if(r_c == 1) {//row
			randomN = random.nextInt(100)*100;
			
			return randomN;
		}
		else {
			randomN = random.nextInt(80)*100;
			return randomN;
		}
	}
	
	
	
}
