import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;
//Subclass of GameToken
public class OtherToken extends GameToken 
	{
	Random random = new Random();									//Random integer used in the VisibilityPolicy later on
	boolean correct;												//boolean to see if the patterns matched
	public OtherToken(int x, int y, int width, int height) {
		super(x, y, width, height);									//takes the x, y, widht, and height from the super class(Aka GameToken)
		correct = false;											//currently initializes the match to false
	}

	//Constructor to see if the tokens matched then sets the correct boolean to the parameter of match
	public void setCorrect(boolean b) 
	{
		this.correct = b;			
	}

	//Method to return the decison of if matched or not; returning boolean(True or False)
	public boolean getCorrect() {
		return correct;
	}
	//ActionListener using Timers to make the tokens not visible in the frame after the delay
	public void setVisibilityPolicy() {
		class TimerListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(!getCorrect()) {								//if it is not matched
					setVisible(false);							//keep the random token to false visible to not be viewable to the player
					setColor(Color.RED.darker());				//set the color of the random token as red
					if (random.nextInt(7) == 3) {				//if the random integer from 0-7 is 3 then
						setVisible(false);						//set the visibility of the tokens as true
						setColor(Color.CYAN);					//set the color of the token as blue;
					}
				}
			}

		}
		//Timer for the visibilitypolicy
		Timer timer = new Timer(random.nextInt(1000)+500, new TimerListener());
		timer.start();
	}

}
