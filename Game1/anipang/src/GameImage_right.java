import java.awt.*;        
import javax.swing.*;  
import java.util.*;
import java.util.concurrent.TimeUnit;

public class GameImage_right extends JPanel {
	Image image[] = new Image[10];
	private JFrame frame;
	Toolkit toolkit = getToolkit();
	Toolkit toolkit1 =  Toolkit.getDefaultToolkit();
	public int getTime=10;public boolean hide = false;
	GameImage_right(){
		image[0] = toolkit.getImage("chapter3(normal).jpg");	
		image[1] = toolkit.getImage("chapter3(warning).jpg");	
		image[2] = toolkit.getImage("chapter3(angry).jpg");	
	}
public static void main(String args[]) {
    	
    }
	public void getTime(int time) {
	getTime = time ;
    }
	
	public void paint(Graphics g) {
		  g.clearRect(0, 0, getWidth(), getHeight());
		  if(getTime <=2) {
			  if(hide==true) {g.drawImage(image[0],800,0,800,1000,this);}
			  else g.drawImage(image[2],800,0,800,1000,this); 
			  }
		  else if(getTime<=5) {
			  g.drawImage(image[1],800,0,800,1000,this);
		  }
		  
		  else
			  g.drawImage(image[0],800,0,800,1000,this);
	}
	
	public void changeImage() {
		repaint();
	}
	
}
