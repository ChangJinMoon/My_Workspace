import java.awt.*;
import javax.swing.*;
import java.io.*;

public class scoreboard extends JPanel{

	Image image[] = new Image[1];
	private JFrame frame;
	Toolkit toolkit = getToolkit();
	Data data =new Data();
	scoreboard(){
		image[0] = toolkit.getImage("blackboard.jpg");
	}
	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.drawImage(image[0],700,550,400,200,this);
		g.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 100));
		g.drawString(data.score + "Á¡", 200, 100); // Á¡¼ö
		
	}
}
