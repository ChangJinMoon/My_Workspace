import java.awt.*;        
import javax.swing.*;  
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.Timer;
import java.util.TimerTask;


public class GameImage1 extends JPanel {
    Image image[] = new Image[10];
    private JFrame frame;
    Toolkit toolkit = getToolkit();
    boolean _isSelected = false;
    int _selectedRow, _selectedCol;
    GameContro gameControl =  new GameContro();
    Toolkit toolkit1 =  Toolkit.getDefaultToolkit();
    Timer timer = new Timer();
    int gameTime_2 = 0;

    public static void main(String args[]) {
    	
    }
    public GameImage1()
    {
    	for(int i=0; i < 5; ++i) {
    		image[i] = toolkit.getImage("Aicon"+i+".jpg");}
    	image[5] =  toolkit.getImage("explosin.jpg");
    	image[6] = toolkit.getImage("class.jpg");
    	}
    
    	/////image[5]  =  터지는 이미지
    
    public void paint(Graphics g)  {
    	gameControl.checkMatchingcol();
    	gameControl.checkMatchingrow();
        g.clearRect(0, 0, getWidth(), getHeight());
        g.drawImage(image[6],0,0,800,1000,this);
        for(int row=0; row <6 ; ++row)
        	for(int col=0; col < 6; ++col) {
        		g.drawImage(image[gameControl.maps[row][col]], (col+1)*100, (row+2)*100, 100, 100, this);}
        if (_isSelected)
        {
        	int x = (_selectedCol+1)*100;
        	int y = (_selectedRow+2)*100;
        	Graphics2D g2=(Graphics2D)g;
        	g2.setStroke(new BasicStroke(5,BasicStroke.CAP_ROUND,0));
        	g2.drawRect(x, y, 100, 100);
        }
    }
    /*void firstCheck() {
    	gameControl.checkMatchingcol();
    	gameControl.checkMatchingrow();
    	delay.firstCheck();
    	gameControl.refill();
    	repaint();
    }*/
    
    void clicked(int x, int y)
    {
    	int row = y/100-2;
    	int col = x/100-1;
    	if ( x >700  && y >800 ) {return ;}
    	else{if ( !_isSelected ) {
    		_selectedRow = row;
    		_selectedCol = col;
    		_isSelected = true;
    	} else
    	{
    		int temp = gameControl.maps[_selectedRow][_selectedCol];
    		    gameControl.getNum(_selectedRow,_selectedCol,row,col);
    		    if(gameControl.check()==true) {
    		    gameControl.maps[_selectedRow][_selectedCol] = gameControl.maps[row][col];
    		    gameControl.maps[row][col] = temp;
        		_isSelected = false;
    		    }
    		    else return ;  
    	}
    	 
    	repaint();
    }
    }
    
}
