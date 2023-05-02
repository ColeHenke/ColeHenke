import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

/**
 * 
 */

/**
 * @author cole.henke
 *
 * TODO round score
 */
public class ActionPanel extends JPanel implements Runnable{

	protected static final int ACTION_PANEL_WIDTH = 400; 
	protected static final int ACTION_PANEL_HEIGHT = 800;
	protected static final int ROCKET_Y_POS = ACTION_PANEL_HEIGHT - 100;
	
	protected static boolean TIMER_FLAG = false; // stops gameTimer in GamePanel class
	private int asteroidCreadtionInterval = 1000; // in milliseconds
	
	private ImageIcon[] rocketColors; // make list of rocket pics
	private ImageIcon rocketImage;
	private Thread actionThread;
	protected Rocket rocket;
	
	protected static LinkedList<Asteroid> currAsteroids = new LinkedList<>();
	private static int[][] xCoordRanges = {{20, 130}, {155, 256}, {275, 350}};
	private int xCoordRangeSelector = 0;
	
	int numberA = 0;
	
	Timer asteroidCreationTimer = new Timer(asteroidCreadtionInterval,
			new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
			generateAsteroid();
			//System.out.println("Asteroid Generated"); //for testing
		}
	});
	
	ActionPanel()
	{
		setBackground(Color.BLACK);
		setFocusable(true);
		setLayout(null);
		
		rocketImage = new ImageIcon("RocketImgV2.jpg");
		rocket = new Rocket((ACTION_PANEL_WIDTH / 2), ROCKET_Y_POS);
		rocket.setLocation(200, 400);
		rocket.setSize(40, 96);
		rocket.setIcon(rocketImage);
		
		add(rocket);
		
		addKeyListener(new AL());
		setPreferredSize(new Dimension(ACTION_PANEL_WIDTH, ACTION_PANEL_HEIGHT));
		setVisible(true);
		
		actionThread = new Thread(this);
		actionThread.start();
		
		asteroidCreationTimer.start();
	}
	
	private class AL extends KeyAdapter
	{
		public void keyPressed(KeyEvent e)
		{
			rocket.keyPressed(e);
		}
		
		public void keyReleased(KeyEvent e)
		{
			rocket.keyReleased(e);
		}
	}
	
	public boolean checkCollision()
	{
		int leftX = rocket.getX();
		int rightX = rocket.getX() + rocket.WID;
		int topY = rocket.getY();
		int bottomY = rocket.getY() + rocket.HEIGHT;
		
		//check for collision w/ each asteroid
		for (int i = 0; i < currAsteroids.size(); i++)
		{
			Asteroid checkAsteroid = currAsteroids.get(i);
			
			//left of right collision
			if ((checkAsteroid.rightXForCol > leftX && checkAsteroid.leftXForCol <= leftX) ||
					(checkAsteroid.rightXForCol > rightX && checkAsteroid.leftXForCol <= rightX))
			{
				if (checkAsteroid.rightAndLeftYForCol >= topY &&
						checkAsteroid.rightAndLeftYForCol < bottomY)
				{
					System.out.println("Collision 1!!");
					return true;
				}
			}
			
			// top or bottom collision
			if ((checkAsteroid.topYForCol < topY && checkAsteroid.bottomYForCol >= topY) || 
					(checkAsteroid.topYForCol < bottomY && checkAsteroid.bottomYForCol >= bottomY))
			{
				if (checkAsteroid.topAndBottomXForCol >= leftX && 
						checkAsteroid.topAndBottomXForCol < rightX)
				{
					System.out.println("Collision 2!!");
					System.out.println(i);
					return true;
				}
			}
		}
		
		//check for x position out of bounds
		if (leftX <= 0)
			rocket.setLocation(0, 400); //400 as placeholder.
										//Why Can't I use "ROCKET_Y_POS" in place of "400"?

		if (rightX >= ACTION_PANEL_WIDTH)
			rocket.setLocation(ACTION_PANEL_WIDTH - rocket.WID, 400);
		//System.out.println(rocket.getX()); //for testing
		
		return false;
	}

	public void run()
	{
		while(true) 
		{
			long lastTime = System.nanoTime();
			double amountOfTicks = 60.0;
			double ns = 1000000000 / amountOfTicks;
			double delta = 0;
			while(true) {
				long now = System.nanoTime();
				delta += (now -lastTime)/ns;
				lastTime = now;
				if(delta >=1) {
					rocket.move();
					for (int i = 0; i < currAsteroids.size(); i++)
					{
						currAsteroids.get(i).updateCoords();
						//System.out.println(i + " " + currAsteroids.get(i).getX() +
							//	" " + currAsteroids.get(i).getY()); //for testing 
					}
					if (!currAsteroids.isEmpty() && currAsteroids.getFirst().getY() > ACTION_PANEL_HEIGHT)
						currAsteroids.removeFirst();
			
					if (checkCollision())
					{
						TIMER_FLAG = true;
						asteroidCreationTimer.stop();
						return;
					}
					delta--;
				}
			}
		}
	}
	
	public void generateAsteroid()
	{
		addToCurrAsteroids(new Asteroid 
				(xCoordRanges[xCoordRangeSelector][0],xCoordRanges[xCoordRangeSelector][1])); 
		xCoordRangeSelector++;
		if (xCoordRangeSelector > 2) xCoordRangeSelector = 0;
		
		currAsteroids.getLast().setText(String.valueOf(numberA));
		currAsteroids.getLast().setHorizontalTextPosition(JLabel.CENTER);
		add(currAsteroids.getLast());
		System.out.println(numberA);
		numberA++;
	}

	public void addToCurrAsteroids(Asteroid asteroidToAdd)
	{
		currAsteroids.addLast(asteroidToAdd);
	}	
	
	public void removeFromCurrAstroids(Asteroid asteroidToRemove)
	{
		//implement 
	}
	
}
