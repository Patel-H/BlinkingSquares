import java.awt.Graphics2D;

//Subclass
//This is class where the Blinking of the random tokens happens
public class BlinkingToken extends GameToken 
{	
	//Constructor of the class similar like the GameToken class 'GameToken' constructor
	public BlinkingToken(int patternType, int x , int y, int width, int height)
	{
		super(x, y, width, height);							//takes the x, y, width and height from the super class(aka GameToken)
	}
	
	public void setPosition(int x, int y)				//sets the position of the box with the parameters
	{
		bbox.setLocation(x, y);
	}
	//draw method to draw the above constructor and box on the frame
	public void draw(Graphics2D g2)
	{
		g2.setColor(this.getColor());
		g2.draw(bbox);
		getPattern().draw(g2);
	}	
}
