import javax.swing.JFrame ;
import javax.swing.JPanel ;

//Class for the GameFrame where a panel is added to the frame that is 700 by 700 pixels
public class GameFrame extends JFrame{
	public static final int FRAME_WIDTH  = 700;
    public static final int FRAME_HEIGHT = 700;

    //Makes the frame
    public GameFrame()
    {
	JPanel panel = new GamePanel() ;
	add(panel) ;
	setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }
	
}
