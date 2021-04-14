import java.awt.*;        
import javax.swing.*;  
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.Timer;
import java.util.TimerTask;

public class example extends JPanel {
	Timer time = new Timer();

	public int percentage =0;
	public void paint(Graphics g) {
		  g.clearRect(0, 0, getWidth(), getHeight());
		  Graphics2D g3=(Graphics2D)g;
		  g3.setStroke(new BasicStroke(10,BasicStroke.CAP_ROUND,0));
		  g3.drawRect(100,120,600,70 );
		percentage += 30 ;
		g3.fillRect(100,120,percentage,70);
	}
	public void Timerun() {
		time.schedule(new TimerTask() {
			public void run() {
				repaint();
			}
		},0,1000);
	}

public static void main() {
	TimeVar timeVar = new TimeVar();
	JFrame frame = new JFrame();
	Container contentPane = frame.getContentPane();
	frame.setBounds(100, 30, 500, 1000);
	timeVar.setLayout(null);
	timeVar.setBounds(0,0,500,1000);
	
	contentPane.add(timeVar);
	frame.setVisible(true);
	frame.getContentPane().setLayout(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

}