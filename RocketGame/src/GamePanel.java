import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 */

/**
 * @author cole.henke
 *
 */
public class GamePanel extends JPanel
{
	private final int ACTION_PANEL_WID = 800;
	private final int ACTION_PANEL_LENGTH = ACTION_PANEL_WID;
	
	private ActionPanel actionPanel;
	private ScoreInfo scoreInfo;
	private JLabel scoreBoardLabel;
	private JLabel firstPlaceLabel;
	private JLabel secondPlaceLabel;
	private JLabel thirdPlaceLabel;
	private JLabel timeLabel;
	private JLabel multiplierLabel;
	private JLabel scoreLabel;
	
	Timer gameTimer = new Timer(1000, new ActionListener() {
		
		public void actionPerformed(ActionEvent e)
		{
			ScoreInfo.secondsPassed++;
			
			if(ActionPanel.TIMER_FLAG) gameTimer.stop();
			
			if (ScoreInfo.secondsPassed % 10 == 0)
			{
				ScoreInfo.multiplier += .1;
			}
			
			ScoreInfo.score += ScoreInfo.multiplier;
			
			//System.out.println(ScoreInfo.score); //for testing
			
			timeLabel.setText("Time: " + String.valueOf(ScoreInfo.secondsPassed));
			scoreLabel.setText("Score: " + String.valueOf(ScoreInfo.score));
			multiplierLabel.setText("Multiplier: " + String.valueOf(ScoreInfo.multiplier));
		}
	});
	
	GamePanel()
	{
		setLayout(null);
		//instantiation
		actionPanel = new ActionPanel();
		scoreInfo = new ScoreInfo();
		scoreBoardLabel = new JLabel("High Scores");
		firstPlaceLabel = new JLabel("1st: 0");
		secondPlaceLabel = new JLabel("2nd: 0");
		thirdPlaceLabel = new JLabel("3rd: 0");
		timeLabel = new JLabel("Time: 0");
		multiplierLabel = new JLabel("Multiplier: 1x");
		scoreLabel = new JLabel("Score: 0");
		
		//set size of labels
		scoreBoardLabel.setSize(100, 50);
		firstPlaceLabel.setSize(100, 50);
		secondPlaceLabel.setSize(100, 50);
		thirdPlaceLabel.setSize(100, 50);
		timeLabel.setSize(100, 50);
		multiplierLabel.setSize(100, 50);
		scoreLabel.setSize(100, 50);
		
		//set location of labels
		scoreBoardLabel.setLocation(20, 200);
		firstPlaceLabel.setLocation(20, 260);
		secondPlaceLabel.setLocation(20, 290);
		thirdPlaceLabel.setLocation(20, 310);
		timeLabel.setLocation(650, 200);
		multiplierLabel.setLocation(650, 300);
		scoreLabel.setLocation(650, 400);
		
		//make labels pretty
		/*
		 * font
		 * color
		 * 
		 */
		
		actionPanel.setLocation(200, 0);
		actionPanel.setSize(ActionPanel.ACTION_PANEL_WIDTH, ActionPanel.ACTION_PANEL_HEIGHT);
		
		setBackground(Color.RED);
		setPreferredSize(new Dimension(ACTION_PANEL_WID, ACTION_PANEL_LENGTH));
		//setLayout(null);
		
		//add stuff
		add(actionPanel);
		add(scoreBoardLabel);
		add(firstPlaceLabel);
		add(secondPlaceLabel);
		add(thirdPlaceLabel);
		add(timeLabel);
		add(multiplierLabel);
		add(scoreLabel);
		setVisible(true);
		
		gameTimer.start();
		
	}
}
