import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 
 */

/**
 * @author coleh
 *
 */
public class ButtonChooserPanel extends JPanel {

	protected int rocketNumber;
	private final int BUTTON_CHOOSER_PANEL_WID = 400;
	private final int BUTTON_CHOOSER_PANEL_HEIGHT = 800;

	
	public ButtonChooserPanel() {
        setLayout(new GridBagLayout());
       // setPreferredSize(new Dimension(BUTTON_CHOOSER_PANEL_WID, BUTTON_CHOOSER_PANEL_HEIGHT));
        GridBagConstraints gbc = new GridBagConstraints();

        ImageIcon icon = new ImageIcon("RocketImgV2.jpg");
        JLabel iconLabel = new JLabel(icon);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 10, 10, 10);
        add(iconLabel, gbc);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        for (int i = 1; i <= 6; i++) {
            JButton button = new JButton("Button " + i);
            button.setPreferredSize(new Dimension(100, 50));
            buttonPanel.add(button);
        }
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(buttonPanel, gbc);

        setBackground(Color.BLACK);
    }
	
	public static void main(String [] args)
	{
		ButtonChooserPanel panel = new ButtonChooserPanel();
		
		JFrame testFrame = new JFrame();
		
		
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.setTitle("Pong Game");
		testFrame.setResizable(true);
		testFrame.setBackground(Color.black);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.add(panel);
		testFrame.pack();
		testFrame.setVisible(true);
	}
}
