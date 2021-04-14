import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import java.io.*;

public class endingImage extends JPanel {
	Toolkit toolkit = getToolkit();
	Data data = new Data();
	public endingImage() {

		endingbackground background = new endingbackground();
		scoreboard scoreboard =new scoreboard();
		
		JFrame frame2 = new JFrame();
		Container contentPane = frame2.getContentPane();
		frame2.setBounds(100, 30, 1600, 1000);

		background.setLayout(null);
		background.setBounds(100,30,1600,1000);
		
		scoreboard.setLayout(null);
		scoreboard.setBounds(700,550,400,200);
		
		JButton restartButton = new JButton();
		restartButton.setIcon(new ImageIcon("restart.jpg"));
		restartButton.setBounds(500,750,300, 100);
		
		JButton exitButton = new JButton();
		exitButton.setIcon(new ImageIcon("exit.jpg"));
		exitButton.setBounds(810,750,300, 100);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}});
		restartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Stage1();
				frame2.dispose();
			}});
		
		contentPane.add(restartButton );
		contentPane.add(exitButton);
		contentPane.add(scoreboard);
		contentPane.add(background);

		frame2.setVisible(true);
		frame2.getContentPane().setLayout(null);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}