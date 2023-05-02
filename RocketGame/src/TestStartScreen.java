/**
 * 
 */
import javax.swing.*;
import java.awt.*;
/**
 * @author coleh
 *
 */
public class TestStartScreen extends JPanel{

	public TestStartScreen() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        ImageIcon icon = new ImageIcon("RocketImgV2.jpg");
        JLabel iconLabel = new JLabel(icon);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // add some padding
        add(iconLabel, gbc);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3));
        for (int i = 1; i <= 6; i++) {
            JButton button = new JButton("Button " + i);
            button.setPreferredSize(new Dimension(100, 50)); // set preferred size
            buttonPanel.add(button);
        }
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        add(buttonPanel, gbc);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new TestStartScreen());
        frame.setVisible(true);
    }
	
}
