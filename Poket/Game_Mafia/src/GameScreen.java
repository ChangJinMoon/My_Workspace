import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GameScreen extends JFrame implements Runnable,KeyListener {

	private JFrame frame;
	private JTextField textField;
	int job;
	Thread th;
	Round round ;
	int level;
	
	boolean keyUp =false;
	boolean keyDown =false;
	boolean keyLeft =false;
	boolean keyRight =false;
	boolean playerMove =false;
	int direct =1 , move =0;
	int count  =1;
	boolean endGame = false;
	/**
	 * Launch the application.
	 * 
	 */

	/**
	 * Create the application.
	 */
	public GameScreen(int level,int job) {
		 round = new Round(job);
		this.level =  level;
		this.addKeyListener(this);
		th = new Thread(this);
		th.start();
		initialize();
	}
	 
	public void run() {
		while(true) {
			try {
				keyProcess();
				round.addEnemy(count);
				round.repaint();
				
				//일반적 
				for(int i = 0; i<round.enemyplus+1;i++) {
					if(round.enemy_sensor(round.enemy[i],level)) {
						round.enemy_activate(round.enemy[i]);}
					else {
						if(count%3 == 0) round.enemy_wait(round.enemy[i]);
						}
					endGame = round.catchUer(round.enemy[i]);
					if(endGame) {
						EndingScreen endingScreen = new EndingScreen(round.return_score());//점수 받기 
						this.dispose();
						return ;
					}
				}
				// speical 적 
				if(round.enemy_sensor(round.special_e,level)) {
					round.enemy_activate(round.special_e);}
				else {
					if(count%3 == 0) round.enemy_wait(round.special_e);
					}
				endGame = round.catchUer(round.special_e);
				if(endGame) {
					EndingScreen endingScreen = new EndingScreen(round.return_score());//점수 받기 
					this.dispose();
					return ;
				}
				
				th.sleep(70);
				count++;
				round.getCount(count);// 라운드 시간 받기
			}catch(Exception e) {}
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setBounds(30, 30, 1400, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		
		JLabel score_display= new JLabel("New label");
		score_display.setBounds(0, 500, 200, 161);
		getContentPane().add(score_display);
		
		round.setBounds(0, 0, 1400, 1000);
		getContentPane().add(round);
		
		setFocusable(true);
		setVisible(true);
	}
	
	
	
	public void keyProcess(){
		playerMove = false;

		if (keyUp ){
			direct = 0;
			move++;
			round.get_Move(move, direct);
			round.move_Up();
			playerMove = true;
		}

		if ( keyDown){
			direct = 1;
			move++;
			round.get_Move(move, direct);
			round.move_Down();
			playerMove = true;
		}

		if ( keyLeft){
			direct = 3;
			move++;
			round.get_Move(move, direct);
			round.move_Left();
			playerMove = true;
		}

		if ( keyRight){
			direct = 2;move++;
			round.get_Move(move, direct);
			round.move_Right();
			playerMove = true;
		}
		return ;
		}
		 
		public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_LEFT :
				keyLeft = true;
				break;
			case KeyEvent.VK_RIGHT :
				keyRight = true;
				break;
			case KeyEvent.VK_UP :
				keyUp = true;
				break;
			case KeyEvent.VK_DOWN :
				keyDown = true;
				break;
		}
		}

		public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_LEFT :
				keyLeft = false;
				break;
			case KeyEvent.VK_RIGHT :
				keyRight = false;
				break;
			case KeyEvent.VK_UP :
				keyUp = false;
				break;
			case KeyEvent.VK_DOWN :
				keyDown = false;
				break;
		}
		}

		public void keyTyped(KeyEvent e) {
			
		}

}

	

