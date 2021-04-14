
//게임 시작화면
import javax.swing.*;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.*;
public class MainScreen  {
	private JFrame frame;
	public static void main(String[] args) {
		MainScreen window = new MainScreen();
		window.frame.setVisible(true);
	}
	public MainScreen(){
		print();
	}
	
	private void print() {
		frame = new JFrame();
		frame.setBounds(100, 30, 1600, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(500, 750, 600, 100);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		JButton startButton = new JButton();
		JButton exitButton = new JButton();
		
		startButton.setIcon(new ImageIcon("play.jpg"));
		startButton.setBounds(0, 0, 300, 100);
		panel.add(startButton);
		
		exitButton.setIcon(new ImageIcon("exit.jpg"));
		exitButton.setBounds(300, 0, 300, 100);
		panel.add(exitButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1600, 1000);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel Mainscreen = new JLabel("New label");
		Mainscreen.setBounds(0, -19, 1600, 1000);
		panel_1.add(Mainscreen);
		Mainscreen.setIcon(new ImageIcon("Mainscreen.jpg"));
		
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		startButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new Stage1();
					frame.dispose();
					
				}
		});
	}

}
