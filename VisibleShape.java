import java.awt.Graphics2D;
import java.awt.Rectangle;

//Interface which is used by the GameToken superclass
public interface VisibleShape 
{
	void draw(Graphics2D g2);						//the draw constructor used in GameToken and Pattern
	void setVisibilityPolicy();						//SetVisibilityPolicy used in OtherToken
	boolean overlaps(VisibleShape other);			//overlaps used in GamePanel
	Rectangle getBoundingBox();						//used for one method in GameToken which return the bbox
}	
