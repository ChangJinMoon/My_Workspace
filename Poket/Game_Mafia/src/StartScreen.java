import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartScreen{
	

	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		StartScreen startScreen = new StartScreen();
	}

	/**
	 * Create the application.
	 */
	public StartScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Screen screen = new Screen();
		
		frame = new JFrame();
		frame.setBounds(30, 30, 1400, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		frame.getContentPane().add(screen, BorderLayout.CENTER);
		screen.setLayout(null);
		
		JButton startButton = new JButton("startbutton");
		
		startButton.setBounds(1200, 0, 184, 100);
		screen.add(startButton);
		
		
		JButton exitbutton = new JButton("exitbutton");
		exitbutton.setBounds(1200, 98, 184, 100);
		screen.add(exitbutton);
		
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuScreen menu = new MenuScreen();
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

class Screen extends JPanel{
	Image image_1;
	Image image_2;
	Image totalImage;
	Graphics gc;
	Screen(){
		image_1 = Toolkit.getDefaultToolkit().createImage("startScreen.gif");
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


