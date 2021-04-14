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
	
	void plus_Enemy(Character character) {//�߰� �ʿ� 
		character.setLocation(600,200);
	}
	
	int coin_score(int num) {//�������� ������ �ٸ��� �����Ͽ� ���� ��ü���� ������ �����ش� 
		int score= 0;
		switch(num) {
			case 1:
				score = 300;
			case 2:
				score =  1000;
		}
		return score;
	}
	
	void set_coins_location() {//coin ��ü�� ���� �ʱ�ȭ �޼ҵ� 
		int randomN;
		for(int i = 0 ; i < 20;i++) {
			randomN = random.nextInt(2);
			coin[i] = new Coin(randomN);
			coin[i].set_coin();//������ �̹��� ����
			coin[i].get_coin_location(return_item_location(1),return_item_location(0));//��ġ ���� 
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
