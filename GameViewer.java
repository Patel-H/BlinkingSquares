import javax.swing.JFrame;

//The main Class where the program first starts then moves to GameFrame
public class GameViewer {

	public static void main(String[] args)
        {      
        JFrame frame = new GameFrame();							//sets the frame as the GameFrame panels
        frame.setTitle("Brain Trainer");						//sets the title of the frame as 'Brain Trainer'
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//exits when clicked "X" on the top left
        frame.setVisible(true);									//sets the frame to be visible
        }
}
