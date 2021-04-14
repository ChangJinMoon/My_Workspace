import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.JPanel;




public class Round extends JPanel   {// maps �� ĳ���� ��ü �Ѵ� �޾� ����Ʈ // Ű���� �׼Ǹ����� //��Ƽ����

	Morning morning = new Morning();
	Mafia mafia;
	Citizen citizen;
	Enemy enemy[] = new Enemy[5];
	Special_enemy special_e = new Special_enemy();
	Item item = new Item();
	Thread th_son;
	Stack e_location = new Stack();
	
	
	Graphics gc;

	
	boolean pass;
	int time;int job;//���� �÷��̾� 1 = 1 �÷��̾� 2 = 2 ���� =3
	public Image img;
	int move , moveState;// 0 �� 1�Ʒ� 2������ 3����
	int score;
	int enemyplus = 1;
	
	Round(int job){	
		this.job = job;
		if(job == 1) {
			mafia = new Mafia();
			}
		else {
			citizen = new Citizen();
		}
		
		enemy[0] = new Enemy();
		enemy[0].setLocation(50,800);
		enemy[1] = new Enemy();
		enemy[1].setLocation(425,250);
		special_e.setLocation(830, 800);//Ư�� �� �߰� 
		
		return_user().get_maps(morning.maps);
		return_user().setLocation(500, 700);
		set_e_location();

	}
	
	Character return_user() {//������� ������ �����ϴ� �޼ҵ�
		if(job == 1)
			return mafia;
		else 
			return citizen;
	}
	
	
	
	
	
	// ����Ʈ ���� �޼ҵ�
	
	public void paint(Graphics g) {
		img =createImage(1400, 1000);
		
		gc=img.getGraphics();
		paintHoleThing();

		g.drawImage(img,0,0,this);
	
	}
	
	void paintHoleThing() {//������ �׸��� �޼ҵ�
		drawMaps();// �� �׸��� ���� �߰�
		getCharacterImg(moveState,return_user(),move);//������ �׸���
		drawEnemy();//���� �׸��� 
		//drawItem();//�������� �׸���
		gc.setFont(new Font("Default", Font.BOLD, 30));
		gc.drawString("Score:"+Integer.toString(score), 1200, 100);
		gc.drawString("Time:"+Integer.toString(time), 1200, 300);


	}
	
	void getCharacterImg(int direct,Character character,int move) {//���� �׸���
		switch(move%4) {
			case 0:
				gc.drawImage(callImage(character.job,direct,0),character.getCharacterX()-30,character.getCharacterY()-65,this);
				break;
			case 1:
				gc.drawImage(callImage(character.job,direct,1),character.getCharacterX()-30,character.getCharacterY()-65,this);
				break;
			case 2:
				gc.drawImage(callImage(character.job,direct,0),character.getCharacterX()-30,character.getCharacterY()-65,this);
				break;
			case 3:
				gc.drawImage(callImage(character.job,direct,2),character.getCharacterX()-30,character.getCharacterY()-65,this);
				break;	
		}
	}
	
	
	Image callImage(int num,int direct,int state) {// ���� num�� 3�̻�
		if(num == 1) 
			return mafia.moveImage[direct][state];
		else if(num == 2)
			return citizen.moveImage[direct][state];
		else if(num ==3)
			return enemy[0].moveImage[direct][state];//������ �� �̹����� �����ϱ�
		else 
			return special_e.moveImage[direct][state];
	}
	
	void drawEnemy() {// ���� ����Ʈ( ������� ����Ʈ)
		for(int i = 0; i<enemyplus+1;i++) {
			getCharacterImg(enemy[i].direct, enemy[i],enemy[i].move);
			}
		getCharacterImg(special_e.direct, special_e, special_e.move);
	}
	
	void drawMaps() {// �ʱ׸���
		gc.drawImage(morning.Room,0,0,1184, 1061,this);
		for(int i= 0; i<100;i++) {
			for(int j = 0; j<120;j++) {
				if(morning.maps[i][j] == 1) {
					gc.drawImage(morning.block,j*10,i*10,10,10,this);
				}
			}
		}
	}
	
	void drawItem() {//������ �׸���
		for(int i = 0; i<20;i++) {
				gc.drawImage(item.coin[i].coinImage,item.coin[i].return_coin_location(1),item.coin[i].return_coin_location(0),30,30,this);
		}
		if(time == 1000) gc.drawImage(item.plus_enemy,item.return_item_location(1),item.return_item_location(0), 30, 30, this);
	}
	
	// ���� �ൿ�� �����ϴ� �޼ҵ�
	boolean enemy_sensor(Enemy enemy,int level) {
		int range = 0;
		switch(level) {
		case 1:
			range = 75;	break;
		case 2:
			range = 100;break;
		case 3:
			range =125; break;
		}
		
		for(int i = -range ; i<range;i++) {
			for(int j = -range ; j< range ; j++) {
				if(enemy.getCharacterY() + i == return_user().getCharacterY()||
						enemy.getCharacterX()+j == return_user().getCharacterX()) {
					return true;
				}
			}
		}
		return false;
	}
	
	void enemy_activate(Enemy enemy) {
			enemy.get_maps(morning.maps);
			enemy.getUserLocation(return_user().getCharacterX(), return_user().getCharacterY());// ����
			enemy.start_Chaseing();//������ �־� ���� //��Ʈ�� ���� �� �����̱� ���� 
			enemy.move();
	}
	
	void enemy_wait(Enemy enemy) {//������ ������ ������ �۵��ϴ� �޼ҵ�
		
		
		switch(time%5) {
			case 1:
				enemy.leftmove();
				enemy.direct =3;enemy.move++;
				break;
			case 3:
				enemy.downmove();
				enemy.direct =1;enemy.move++;
				break;
			case 4:
				enemy.upmove();
				enemy.direct =0;enemy.move++;
				break;
			case 2:
				enemy.rightmove();
				enemy.direct =2;enemy.move++;
				break;
		}
	}
	
	boolean catchUer(Enemy enemy) {//������� ������ ������ ���� �޼ҵ�
		if(enemy.getCharacterY() == return_user().getCharacterY()&&
				enemy.getCharacterX()== return_user().getCharacterX()) return true;
		else
			return false;

	}
	
	void addEnemy(int time) {// Ư���ð����� ���� �߰��ϴ� �޼ҵ� 
		if(time % 110 == 0) {
			if(enemyplus >=3) {
				return ;
			}
			
			++enemyplus;
			Value value = new Value();
			value=e_location.pop();
			enemy[enemyplus] = new Enemy();
			enemy[enemyplus].setLocation(value.col,value.row);
			
			
		}
	}
	
	// ������ �����ӿ� ���� �޼ҵ� 
	
	void set_e_location(){
		//e_location.push(800,830); 
		e_location.push(100,830); 
		e_location.push(50,100); 
	}
	void get_Move(int move,int moveState) {
		this.move = move;
		this.moveState = moveState;
	}
	void move_Right() {
		if(job == 1) {
			mafia.rightmove();
		}
		else {
			citizen.rightmove();
		}
	}
	void move_Left() {
		if(job == 1) {
			mafia.leftmove();
		}
		else {
			citizen.leftmove();
		}
	}
	void move_Down() {
		if(job == 1) {
			mafia.downmove();
		}
		else {
			citizen.downmove();
		}
	}
	void move_Up() {
		if(job == 1) {
			mafia.upmove();
		}
		else {
			citizen.upmove();
		}
	}
	
	/////////////////////////////////////////
	void getCount(int count) {//�ð� �ޱ�
		score = count;
		time = count/11;
	}
	
	int return_score() {
		return score;
	}
	
	
	
}