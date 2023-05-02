/**
 * 
 */
import java.util.*;
/**
 * @author cole.henke
 *
 */
public class ScoreInfo {

	protected static LinkedList<Double> highScores = new LinkedList<>();
	protected static double score = 0;
	protected static double multiplier = 1;
	protected static int secondsPassed = 0;

	ScoreInfo ()
	{
		
	}
	
	public void updateScore()
	{
		score += (1 * multiplier);
	}
	
	public void updateMultiplier()
	{
		multiplier += 0.1;
	}

	public void updateHighScores(double newScore)
	{
		for (int i = 0; i < highScores.size(); i++)
		{
			if (newScore > highScores.get(i))
			{
				highScores.add(i, newScore);
			}
		}
	}
	
	
}
