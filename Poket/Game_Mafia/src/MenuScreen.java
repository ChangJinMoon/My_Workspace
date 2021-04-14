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


public class MenuScreen {
	
	int Level = 0;
	int characterN=0;

	private JFrame frame;

	public MenuScreen() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Screen_M screen = new Screen_M();
		
		Font font = new Font("±Ã¼­",Font.BOLD,100);
		
		frame = new JFrame();
		frame.setBounds(30, 30, 1400, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		frame.getContentPane().add(screen, BorderLayout.CENTER);
		screen.setLayout(null);
		
		JButton NOMARL = new JButton("NOMARL");
		NOMARL.setFont(new Font("±¼¸²", Font.BOLD, 20));
		
		NOMARL.setBounds(600, 550, 300, 100);
		screen.add(NOMARL);
		
		JButton HARD = new JButton("HARD");
		HARD.setFont(new Font("±¼¸²", Font.BOLD, 20));
		
		HARD.setBounds(600, 700, 300, 100);
		screen.add(HARD);
		
		JButton EASY = new JButton("EASY");
		EASY.setFont(new Font("±¼¸²", Font.BOLD, 20));
		EASY.setBounds(600, 400, 300, 100);
		screen.add(EASY);
		
		JLabel lblNewLabel = new JLabel(" Select Level");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 55));
		lblNewLabel.setBounds(553, 269, 450, 100);
		screen.add(lblNewLabel);
		
		JButton btnBack = new JButton("Back ");
		btnBack.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btnBack.setBounds(1232, 836, 100, 100);
		screen.add(btnBack);
		
		EASY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Level = 1;	
				MenuScreen_2 menuScreen_2 = new MenuScreen_2(Level);
				frame.dispose();
				
			}
		});
		
		NOMARL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Level = 2;			
				MenuScreen_2 menuScreen_2 = new MenuScreen_2(Level);
				frame.dispose();
			}
		});
		HARD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Level = 3;
				MenuScreen_2 menuScreen_2 = new MenuScreen_2(Level);
				frame.dispose();
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartScreen screen = new StartScreen();
				frame.dispose();
			}
		});
		
		frame.setVisible(true);
	}
	
}

class Screen_M extends JPanel{
	Image image_1;
	Image image_2;
	Image totalImage;
	Graphics gc;
	Screen_M(){
		image_1 = Toolkit.getDefaultToolkit().createImage("menu.jpg");
		image_2 =  Toolkit.getDefaultToolkit().createImage("title.png");
	}
	
	public void paintComponent(Graphics g) { 
		totalImage = createImage(1400,1000);
		gc =totalImage.getGraphics();
		gc.drawImage(image_1, 0, 0, this);
		gc.drawImage(image_2, 560, 100,370,136, this);
		g.drawImage(totalImage,0,0,this);
	}
}


