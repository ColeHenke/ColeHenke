import java.awt.Color;
import java.awt.Image;
import java.util.*;
import java.awt.geom.*;
import javax.swing.*;
/**
 * 
 */

/**
 * @author cole.henke
 *
 */
public class Asteroid extends JLabel{

	protected static int yVelocity = 1; //place holder
	
	protected final static int INIT_Y_POS = -100; //placeholder val
	
	//used to pick asteroid specs
	private Random randYPos;
	private Random randXPos;
	//private Random randomDiameter;
	
	//asteroid spec vars
	protected int yPos;
	protected int xPos;
	protected int diameter;
	
	// init coords for hit detection
	protected int rightXForCol = xPos + diameter;
	protected int leftXForCol = xPos;
	protected int topAndBottomXForCol = xPos + (diameter / 2);
	protected int topYForCol = yPos;
	protected int bottomYForCol = yPos + diameter;
	protected int rightAndLeftYForCol = yPos + (diameter / 2);
		
	//large asteroids
	private ImageIcon largeLightGrayAsteroid = new ImageIcon("LargeLightGrayAsteroid.jpg");
	private ImageIcon largeDarkGrayAsteroid = new ImageIcon("LargeDarkGrayAsteroid.jpg");
	private ImageIcon largeSuperDarkGrayAsteroid = new ImageIcon("LargeSuperDarkGrayAsteroid.jpg");
	
	//normal asteroids
	private ImageIcon normalSuperDarkGrayAsteroid = new ImageIcon("NormalSuperDarkGrayAsteroid.jpg");
	private ImageIcon normalDarkGrayAsteroid = new ImageIcon("NormalDarkGrayAsteroid.jpg");
	private ImageIcon normalLightGrayAsteroid = new ImageIcon("NormalLightGrayAsteroid.jpg");
	
	//small asteroids
	private ImageIcon smallSuperDarkGrayAsteroid = new ImageIcon("SmallSuperDarkGrayAsteroid.jpg");
	private ImageIcon smallDarkGrayAsteroid = new ImageIcon("SmallDarkGrayAsteroid.jpg");
	private ImageIcon smallLightGrayAsteroid = new ImageIcon("SmallLightGrayAsteroid.jpg");
	
	//list of all possible asteroids to be used in choosing random image
	protected final ImageIcon[] asteroidColors = 
		{largeLightGrayAsteroid, largeDarkGrayAsteroid, largeSuperDarkGrayAsteroid,
			normalSuperDarkGrayAsteroid, normalDarkGrayAsteroid, normalLightGrayAsteroid,
			smallSuperDarkGrayAsteroid, smallDarkGrayAsteroid, smallLightGrayAsteroid};
	private Random randomAst;
	
	Asteroid(int lowX, int highX)
	{
		randYPos = new Random();
		randXPos = new Random();
		randomAst = new Random();
		
		setIcon(asteroidColors[randomAst.nextInt(0, asteroidColors.length)]);
		setSize(this.getIcon().getIconWidth(), this.getIcon().getIconHeight() + 25);
		
		yPos = randYPos.nextInt(INIT_Y_POS - 20, INIT_Y_POS + 20);
		xPos = randXPos.nextInt(lowX, highX /*- this.getIcon().getIconWidth() + 25*/);
		
		
		diameter = this.getIcon().getIconWidth();
		setBounds(xPos, yPos, diameter, diameter);
		setVisible(true);
		//setForeground(Color.BLUE); setText("Asteroid"); //for testing
		
		
		//setSize(150, 150);
	}
	
	//change asteroid y-position by yVelocity
	public void move()
	{
		setLocation(this.getX() , this.getY() + yVelocity);
	}
	
	//moves asteroid using move(), then changes coords for hit detection using updated location data
	public void updateCoords()
	{
		move();
		
		rightXForCol = this.getX() + diameter;
		leftXForCol = this.getX();
		topAndBottomXForCol = this.getX() + (diameter / 2);
		topYForCol = this.getY();
		bottomYForCol = this.getY() + diameter;
		rightAndLeftYForCol = this.getY() + (diameter / 2);
		
		//for testing coord updates
		//System.out.println(topYForCol);
	}
}
