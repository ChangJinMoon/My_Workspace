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


public class EndingScreen {
	
	int Score = 0;

	private JFrame frame;

	public EndingScreen(int score) {
		this.Score  = score;
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Screen_E screen = new Screen_E();
		
		Font font = new Font("±Ã¼­",Font.BOLD,100);
		
		frame = new JFrame();
		frame.setBounds(30, 30, 1400, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		frame.getContentPane().add(screen, BorderLayout.CENTER);
		screen.setLayout(null);
		
		JButton startButton = new JButton("restartbutton");
		
		startButton.setBounds(1200, 0, 200, 100);
		screen.add(startButton);
		
		JButton exitbutton = new JButton("exitbutton");
		
		exitbutton.setBounds(1200, 110, 200, 100);
		screen.add(exitbutton);
		
		JLabel lblNewLabel = new JLabel("Score:"+Integer.toString(Score));//score
		lblNewLabel.setFont(font);
		lblNewLabel.setBounds(293, 364, 700, 200);
		screen.add(lblNewLabel);
		
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartScreen startScreen = new StartScreen();
				frame.dispose();
			}
		});
		exitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		frame.setVisible(true);
	}
}

class Screen_E extends JPanel{
	Image image_1;
	Image image_2;
	Image totalImage;
	Graphics gc;
	Screen_E(){
		image_1 = Toolkit.getDefaultToolkit().createImage("endingscreen.gif");
		image_2 =  Toolkit.getDefaultToolkit().createImage("title.png");
	}
	
	public void paintComponent(Graphics g) { 
		totalImage = createImage(1200,1000);
		gc =totalImage.getGraphics();
		gc.drawImage(image_1, 0, 0, this);
		gc.drawImage(image_2, 475, 100,370,136, this);
		g.drawImage(totalImage,0,0,this);
	}
}


