package src;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
public class Main 
{
    public static final int WIDTH = 1280; 
    public static final int HEIGHT = 960;
    
    public static void main(String[]  args) {
	JFrame theFrame = new JFrame("UNO!");
	theFrame.setSize(WIDTH, HEIGHT);	
	theFrame.setLocationRelativeTo(null);
	theFrame.setResizable(false);
	theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	theFrame.setVisible(true);
	//thePanel.run();	
    }	
}

