import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Font;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JRadioButton;


public class MenuScreen_2{
	
	int Level = 0;
	int characterN=0;

	private JFrame frame;

	public MenuScreen_2(int level) {
		this.Level = level;
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Screen_M_2 screen = new Screen_M_2();
		
		Font font = new Font("±Ã¼­",Font.BOLD,100);
		
		frame = new JFrame();
		frame.setBounds(30, 30, 1400, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		frame.getContentPane().add(screen, BorderLayout.CENTER);
		screen.setLayout(null);
		
		
		JButton btnBack = new JButton("Back ");
		btnBack.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btnBack.setBounds(1232, 836, 100, 100);
		screen.add(btnBack);
		
		JRadioButton rdbtnMafia = new JRadioButton("mafia");
		rdbtnMafia.setBounds(700, 470, 74, 23);
		screen.add(rdbtnMafia);
		
		JRadioButton rdbtnCitizen = new JRadioButton("citizen");
		rdbtnCitizen.setBounds(700, 630, 74, 23);
		screen.add(rdbtnCitizen);
		
		JLabel lblSelectCharacter = new JLabel("select character");
		lblSelectCharacter.setForeground(Color.WHITE);
		lblSelectCharacter.setFont(new Font("±¼¸²", Font.BOLD, 55));
		lblSelectCharacter.setBounds(500, 269, 600, 100);
		screen.add(lblSelectCharacter);
		
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartScreen screen = new StartScreen();
				frame.dispose();
			}
		});
		
		rdbtnMafia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				characterN =1;
				GameScreen gameScreen = new GameScreen(Level,characterN);
				frame.dispose();
			}
		});
		
		rdbtnCitizen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				characterN =0;
				GameScreen gameScreen = new GameScreen(Level,characterN);
				frame.dispose();
				
				
				
				
			
				
			}
		});
		
		frame.setVisible(true);
	}
	
}

class Screen_M_2 extends JPanel{
	Image image_1;
	Image image_2;
	Image image_3;
	Image image_4;
	Image totalImage;
	Graphics gc;
	Screen_M_2(){
		image_1 = Toolkit.getDefaultToolkit().createImage("menu.jpg");
		image_2 =  Toolkit.getDefaultToolkit().createImage("title.png");
		image_3 = Toolkit.getDefaultToolkit().createImage("Mafia_Down_stop.png");
		image_4  = Toolkit.getDefaultToolkit().createImage("Citizen_Down_stop.png");
	}
	
	public void paintComponent(Graphics g) { 
		totalImage = createImage(1400,1000);
		gc =totalImage.getGraphics();
		gc.drawImage(image_1, 0, 0, this);
		gc.drawImage(image_2, 560, 100,370,136, this);
		gc.drawImage(image_3, 600, 400,100,150, this);	
		gc.drawImage(image_4, 600, 550,100,150, this);	
		g.drawImage(totalImage,0,0,this);
	}
}


