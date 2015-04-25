import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class GamePanel extends JPanel {

	final int numberofRectangles = 15;

	
	Random random = new Random();									//makes a random variable with type random
	ArrayList<GameToken> tokens;									//ArrayList of Type GameToken(class) giving the variable name as 'tokens'
	int type;														//creates a variable 'type' of type Integer
	Pattern pat;													//creates a variable 'pat' of type Pattern
	int score;														//creates a variable 'score' of type Integer
	int count;														//creates a variable 'count' of type Integer
	private GameToken usr;											//creates a variable 'usr' of type GameToken from GameToken class
	final int DELAY = 3000;											//creates a variable 'DELAY' of type integer but final so no change can be done
	Timer rTimer;												//creates a variable 'rTimer' of type Timer to count time 
	
	//main class where the tokens and Timer starts
	public GamePanel() {
		tokens = new ArrayList<GameToken>();						//creates a randomtoken from the ArrayList referring to GameToken class
		
		//loop for print all the random tokens; in this case 15
		for (int i = 0; i < numberofRectangles; i++) {
			Random random = new Random();							//random variable
			int x = random.nextInt(GameFrame.FRAME_WIDTH - 100);	//so that the random tokens don't go out the frame
			int y = random.nextInt(GameFrame.FRAME_HEIGHT - 100);	//so that the random tokens don't go out the frame

			GameToken randomtoken = new GameToken(x, y, 50, 50);	//sets the random tokens in random positions using random x and random y with a square side of 50 pixels
			randomtoken.setColor(Color.BLACK);						//sets the color fo the random tokens in random positions to BLACK
			
			
			
			FirstListener iListener =  new FirstListener();			//creates a Listener called iListener for the Timer
			Timer iTimer = new Timer(DELAY, iListener);				//creates a Timer called 'iTimer' for  listener above				
			iTimer.start();											//starts the Timer created above
			iTimer.setRepeats(false);								//doesn't let the timer repeat;
			rTimer = new Timer(10, new ListenerForRepaint());		//creates a new timer for visiblity of random token
			rTimer.start();											//starts the timer created above

			//only print the random tokens on screen if it doesn't overlap with another
			if (!overLap(randomtoken)) {
				randomtoken.setVisible(true);
				tokens.add(randomtoken);
			}
		}

		int x = random.nextInt(500);								//random number from 0-500
		int y = random.nextInt(500);								//random number from 0-500
		
		usr = new GameToken(x, y, 50, 50);							//creates the UserToken in the random x, y coordinates from the random number above
		usr.setColor(Color.blue);									//sets the color of the UserToken as blue;
		
		//Listener class for being able to use the mouse
		class MyListener extends MouseAdapter 
		{
			public void mousePressed(MouseEvent event) 
			{
				if(event.getButton() == MouseEvent.BUTTON1)			//if the LeftClickMouse
                {
					int x = event.getX();							//sets the x coordinate to integer x
					int y= event.getY();							//sets the y coordinate to integer y
                    usr.moveTo(x, y);								//moves the UserToken to the x,y coordinate set above
        
                    //for all the token in tokens(of type GameToken) - basically all random tokens
                    for(GameToken t1 : tokens)     
                    {
                    	//if UserToken overlaps the random token and the random tokens pattern type is equal to the UserTokens pattern type and the random tokens color is not green
                    	int tok2 = t1.typePattern();
                        if(usr.overlaps(t1) && (tok2 == usr.typePattern()) && t1.getColor() != Color.GREEN)
                        {
                        	t1.setVisible(true);					//set the random tokens visible;
                            t1.setColor(Color.GREEN);				//set the color of the random token to green
                            score = score + 2;						//increment the score by 2
                        }
                        //elsewise, if the UserToken overlaps the random token and the UserTokens pattern type and random tokens pattern types don't match: 
                        else if(usr.overlaps(t1) && tok2 != usr.typePattern())
                        {
                        	count ++;								//increment the count variable(To count amount of tries)
                            if(count == 2)							//if the amount of tries is 2
                            {
                            	score-=2;							//decrement the score by 2
                                count = 0;							//reset the count variable
                            }
                         }
                               
                     }
                }
				//if you right click
				if(event.getButton() == MouseEvent.BUTTON3)
                {
					usr.changePattern();							//the pattern for the UserToken changes
                }
                repaint();											//repaints the actionListeners so they can update
			}
		}
		MouseAdapter listener = new MyListener();				//adds the mouse Listeners to the class method
		this.addMouseListener(listener);
	}

	//Method for the Timer to Repaint of the random tokens for blinking 
	class ListenerForRepaint implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			repaint();
		}
	}

	//Method that stops the random tokens from overlapping each other
	public boolean overLap(GameToken randomtoken) 
	{
		for (GameToken gT : tokens)
		if (gT.overlaps(randomtoken))
			return true;
		return false;
	}

	//Method for the Timer Listener so that the timer can set the visibilitypolicy for the random tokens after 3 secs to false
	class FirstListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//for all tokens in type GameToken tokens(Random Tokens)
			for (GameToken token1 : tokens) 
			{
				token1.setColor(Color.RED);					//set all the tokens to color red after Timer reaches DELAY
				token1.setVisible(false);					//sets all the random tokens to hide
				token1.setVisibilityPolicy();				//sets the VisibilityPolicy for all random tokens
			}
		}
	}
	
	//PaintComponent to print the random tokens and UserTokens written above
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		usr.draw(g2);
		for (GameToken tok : tokens) {
			g2.setColor(tok.getColor());
			tok.draw(g2);
				
		}
		usr.draw(g2);											//Draws the UserToken using Graphics2D
		g2.drawString("Score: " + score, 10, 10);				//Draws the label at the top right showing the score		
	}
}
