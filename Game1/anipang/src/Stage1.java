import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import java.io.*;

public class Stage1 extends JPanel {
	Image image[] = new Image[4];
	Toolkit toolkit = getToolkit();
	Data data = new Data();
	public Stage1() {

		GameImage1 gameImage = new GameImage1();
		GameImage_right gameImage2 = new GameImage_right();
		Timer time = new Timer();/*TimeVar timeVar =new TimeVar();*/
		JFrame frame2 = new JFrame();
		Container contentPane = frame2.getContentPane();
		frame2.setBounds(100, 30, 1600, 1000);
		
		gameImage2.setLayout(null);
		gameImage2.setBounds(800,0,800,1000);
		
		gameImage.addMouseListener(new MousePanel(gameImage));
		gameImage.setLayout(null);
		gameImage.setBounds(0,0,800,1000);
		
		JButton refreshButton = new JButton();
		refreshButton.setIcon(new ImageIcon("refresh.jpg"));
		refreshButton.setBounds(1475, 870, 100, 100);
		
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameImage2.hide=true;
			}});
		
		/*timeVar.setLayout(null);
		timeVar.setBounds(100,120,600,70);*/
		
		/*contentPane.add(timeVar);*/
		contentPane.add(refreshButton);
		contentPane.add(gameImage);
		contentPane.add(gameImage2);

		frame2.setVisible(true);
		frame2.getContentPane().setLayout(null);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		data.gametime=10;
		time.schedule(new TimerTask() {
			public void run() {
				if(data.gametime == 0) {
					new endingImage();
					frame2.dispose();
					}
				else if(data.gametime <= 5&&data.gametime>0) {
					gameImage2.getTime(data.gametime);
					gameImage2.changeImage();
					
				}
				data.gametime -=1;
				/*TimeVar();*/
			}
		},0,1000);
	}
}
	
	