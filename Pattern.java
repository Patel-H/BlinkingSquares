import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Random;


public class Pattern
{
  // Some example patterns 
  public static final int CROSS      = 0;
  public static final int CIRCLEPLUS = 1;
  public static final int SQUARE_X   = 2;

  int type;
  public Rectangle bbox;
  
  // Create random pattern type	
  public Pattern(Rectangle bbox)
  {
    // add code
	  Random random = new Random();
	  this.type = random.nextInt(3);
	  this.bbox = new Rectangle(bbox);
	  int x = random.nextInt(3);
	  this.type = x;
  }
  
  public Pattern(int type, Rectangle bbox)
  {
    // add code
	  this.type = type;
	  this.bbox = new Rectangle(bbox);
  }

public int getType()
  {
	  return type;
  }
  
  public void setType(int type)
  {
	  this.type = type;
  }
  
  /* Updates the pattern objects and positions
  public void update(Rectangle bbox)
  {
    switch(this.type)
    {
      // add code
   
  }
  */
  
  public boolean equals(Object other)
  {
    // add code
	  Pattern pattern2 = (Pattern) other;
	  Pattern pattern1 = (Pattern) this;
	  
	  if(pattern1.getType() == pattern2.getType())
	  {
		 return true; 
	  }
	  else {
		  return false;
	  }
  }
  
  public void moveTo(int x, int y)
  {
	  bbox.setLocation(x, y);
  }
  
  public int setPattern()
  {
	  type++;
	  
	  if(type > 2)
		  type = 0;
	 return type;
  }
  
  public void draw(Graphics2D g2)
  {
	
	  
	  Rectangle box = (Rectangle) this.bbox;
	  int x = (int) box.getX();
	  int y = (int) box.getY();
	  int h = (int) box.getHeight();
	  int w = (int) box.getWidth();
	  
	  Graphics2D g = (Graphics2D) g2;  
	  if(type == 2)
	  {
		  
		  Point2D.Double from = new Point2D.Double(x, y);
		  Point2D.Double to = new Point2D.Double(x + w, y + h);
		  g.draw(new Line2D.Double(from, to));
		  
		  Point2D.Double from1 = new Point2D.Double(x +w , y );
		  Point2D.Double to1 = new Point2D.Double(x, y + h);
		  g.draw(new Line2D.Double(from1, to1));
		  
	  }
	  if (type == 1)
	  {
		  g2.draw(new Ellipse2D.Double(x , y, 50, 50));
		  
		  Point2D.Double from = new Point2D.Double(x + w/2, y);
		  Point2D.Double to = new Point2D.Double(x + w/2, y+h);
		  g2.draw(new Line2D.Double(from, to));  
		  
		  Point2D.Double from1 = new Point2D.Double(x, y+ (h/2));
		  Point2D.Double to1 = new Point2D.Double(x + w, y+ (h/2));
		  g2.draw(new Line2D.Double(from1, to1));
	  }
	   if(type == 0)
	  {
		  
		  Point2D.Double from = new Point2D.Double(x + w/2, y);
		  Point2D.Double to = new Point2D.Double(x + w/2, y+h);
		  g2.draw(new Line2D.Double(from, to));  
		  
		  Point2D.Double from1 = new Point2D.Double(x, y+ (h/2));
		  Point2D.Double to1 = new Point2D.Double(x + w, y+ (h/2));
		  g2.draw(new Line2D.Double(from1, to1));
	  }
  }
  
}
