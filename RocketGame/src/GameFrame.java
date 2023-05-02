/**
 * 
 */
import java.awt.Color;

import javax.swing.JFrame;
/**
 * @author cole.henke
 *
 */
public class GameFrame extends JFrame {

	GamePanel gamePanel;
	
	GameFrame()
	{
		//add stuff here
		gamePanel = new GamePanel();
		gamePanel.setSize(600, 600);
		add(gamePanel);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GameFrame frame = new GameFrame();
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Pong Game");
		frame.setResizable(false);
		frame.setBackground(Color.black);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}

}
