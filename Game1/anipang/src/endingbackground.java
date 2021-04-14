import java.awt.*;        
import javax.swing.*;  


public class endingbackground extends JPanel {
	Image image[] = new Image[1];
	Toolkit toolkit = getToolkit();
	Toolkit toolkit1 =  Toolkit.getDefaultToolkit();
	endingbackground(){
		image[0] = toolkit.getImage("endingImage.jpg");}
public static void main(String args[]) {
    	
    }
	public void paint(Graphics g) {
		  g.clearRect(0, 0, getWidth(), getHeight());
		  g.drawImage(image[0],0,0,1600,1000,this);
	}
	
}
