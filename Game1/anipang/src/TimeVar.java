import java.awt.*;        
import javax.swing.*;  
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.Timer;
import java.util.TimerTask;

public class TimeVar extends JPanel {
	Timer time = new Timer();
	Data data = new Data();
	TimeVar(){
		paint(getGraphics());
	}
	public void paint(Graphics g) {
		Graphics2D g2=(Graphics2D)g;
    	g2.setStroke(new BasicStroke(5,BasicStroke.CAP_ROUND,0));
    	g2.drawRect(100,120, 600, 70);
		g2.fillRect(102,122,data.percentage-2,65);
		data.percentage += 120 ;
	}
	
}
