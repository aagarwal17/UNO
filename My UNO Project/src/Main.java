	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;

	import javax.swing.JFrame;
	
	//Arun Agarwal 4/7/20: I don't know if this is how we want to set up our code, but this makes 
	//sense to me right now. I am going to make a Main class that creates the frame and an instance of
	//the gamepanel class. The GamePanel class will hold code implications to the graphics. I may be
	//thinking of this incorrectly, we may be able to use the class called UnoCard for this, but we
	//can work on that.
public class Main 
{
    //width and height of frame
    public static final int WIDTH = 1280; 
    public static final int HEIGHT = 960;
    /** * main method* @param args*/
    public static void main(String[]  args) {
	JFrame theFrame = new JFrame("UNO!");
	GamePanel thePanel = new GamePanel();
	theFrame.setSize(WIDTH, HEIGHT);	
	theFrame.setLocationRelativeTo(null);
	theFrame.setResizable(false);
	theFrame.add(thePanel);
	theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	theFrame.setVisible(true);
	//thePanel.run();	
    }	
}

