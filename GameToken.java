import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
 
 
public class GameToken implements VisibleShape
{
   private boolean visible;														//creates a variable 'visible' of type boolean
   public Rectangle bbox;													//creates a variable 'bbox' of type Rectangle
   private Pattern pattern;														//creates a variable 'pattern' of type Pattern 
   private int type;															//creates a variable 'type' of type Integer
   private Color color;															//creates a variable 'color' for type Color
   
   //Constructor for creating the RandomTokens along with the UserToken
   public GameToken(int x, int y, int width, int height)
   {
        // add code
           bbox = new Rectangle(x, y, width, height);							//sets the variable 'bbox' to the parameters in the constructor
           pattern = new Pattern(bbox);											//sets the variable 'pattern' to the bbox above 
   }
   
   //Constructor for creating the RandomTOkens along with the UserToken with the Pattern type;
   public GameToken(int patternType, int x, int y, int width, int height)
   {
        //add code
           type = patternType;													//sets the patternType from paramter to integer variable 'type'
           bbox = new Rectangle(x, y, width, height);							//sets the bbox to the parameters sizes
           pattern = new Pattern(patternType, bbox);							//sets the patern variable the parameters patternType and the bbox for size of the token
           visible = true;														//visible true to show the tokens		
   }
   
   // Add accessor and mutator methods for instance variables
   // ......
   // end accessor and mutator methods
   
   //Resets the tokens to make visible true;
   public void reset()
   {
        visible = true;
   }
   
   //returns bbox from the interface VisibleShape
   public Rectangle getBoundingBox()
   {
           return bbox;
   }
   
   //shows the tokens as visible if the tokens equal to each other
   public boolean equals(Object other)
   {
        // add code    
           return visible;
   }
 
   // Add methods to implement VisibleShape interface
   public void VisibleShape(Graphics2D g)
   {
           
   }
   
   //checks if the UserToken overlaps the Random Token to continue further on with score
   public boolean overlaps(VisibleShape other)
   {
        if(bbox.intersects(other.getBoundingBox()))
        return true;  
        return false;
   }
 
   //Draw method to draw the bbox and patterns in the GamePanel
   public void draw(Graphics2D g2)
   {
           g2.setColor(color);										
           g2.draw(bbox);
           
           pattern.draw(g2);
   }
   
   //sets the visibility of tokens to the variable visible in this class from parameter
   public void setVisible(boolean visible)
   {
           this.visible = visible;
   }
   
   //returns the visiblity of the tokens to the GamePanel class where it's called and used
   public boolean isVisible()
   {
           return visible;
   }
   
   //The visibility policy
   public void setVisibilityPolicy()
   {
           
   }
   
   //Returns the color of the tokens on the frame
   public Color getColor()
   {
           return color;
   }
   
   //sets the Color of the otkens to the variable 'color' from the paramete 'a'
   public void setColor(Color a)
   {
           color = a;
   }
   
   //to move the UserToken to places on the frame
   public void moveTo(int x, int y)
   {
           bbox.setLocation(x, y);
           pattern.moveTo(x, y);
   }
 
   //returns the pattern of the Random Tokens
   public Pattern getPattern()
   {
           return pattern;
   }
   
   //returns the pattern set to the randm tokens
   public int changePattern()
   {
          return pattern.setPattern();
   }
   
   //returns the pattern type from Pattern class to differetiate the tokens
   public int typePattern()
   {
           return pattern.type;
   }
}
