/**
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @author coleh
 *
 */
public class RocketPickerPanel extends JPanel {

	private ButtonChooserPanel buttonPanel;
	private JLabel welcomeLabel;
	private JLabel instructionsLabel;
	
	public RocketPickerPanel() 
	{
		setFocusable(true);
		setLayout(null);
		setPreferredSize(new Dimension(400, 300));
		
		welcomeLabel = new JLabel("Top Label", SwingConstants.CENTER); // add top label
		welcomeLabel.setForeground(Color.WHITE);
		welcomeLabel.setLocation(0, 50);
		welcomeLabel.setSize(100, 50);
		
		instructionsLabel = new JLabel("Bottom Label", SwingConstants.CENTER); // add bottom label
		instructionsLabel.setForeground(Color.WHITE);
		instructionsLabel.setLocation(50, 400);
		instructionsLabel.setSize(100, 50);
		
		buttonPanel = new ButtonChooserPanel();
		buttonPanel.setLocation(0, 100);
		buttonPanel.setSize(400, 300);
	
		
		setBackground(Color.BLACK);
	    setPreferredSize(new Dimension(400, 300)); 
	    add(welcomeLabel);
	    add(buttonPanel);
	    add(instructionsLabel);
	    setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RocketPickerPanel testPanel = new RocketPickerPanel();
		
		JFrame testFrame = new JFrame();
		
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.setTitle("Pong Game");
		testFrame.setResizable(true);
		testFrame.setBackground(Color.black);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.add(testPanel);
		testFrame.pack();
		testFrame.setVisible(true);
		
	}
}
