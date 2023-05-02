import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 */

/**
 * @author cole.henke
 *
 */
public class Rocket extends JLabel{

	protected final int WID = 40;
	protected final int HEIGHT = 96;
	protected int xVelocity;
	protected int yPos;
	protected int xPos;
	
	Rocket(int initXPos, int initYPos)
	{
		xPos = initXPos - WID;
		yPos = initYPos;
		xVelocity = 0;
		setBounds(xPos, yPos, WID, HEIGHT);
		//add method to pass in a rocket color
	}
	
	public void move()
	{
		setLocation(this.getX() + xVelocity, this.getY());
	}
	
	public void setXVelocity(int xVel)
	{
		xVelocity = xVel;
	}

	public void keyPressed (KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			setXVelocity(1);
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			setXVelocity(-1);
	}
	
	public void keyReleased (KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			setXVelocity(0);
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			setXVelocity(0);
	}
}
