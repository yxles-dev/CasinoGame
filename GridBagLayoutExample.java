import java.awt.*;
import javax.swing.*;

public class GridBagLayoutExample extends JFrame {

    public GridBagLayoutExample() {
        super("GridBagLayout Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout layout = new GridBagLayout();
        Container container = getContentPane();
        container.setLayout(layout);

        // Create constraints for the buttons
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridwidth = 1;
        buttonConstraints.gridheight = 1;
        buttonConstraints.weightx = 0.0;
        buttonConstraints.weighty = 0.0;
        buttonConstraints.fill = GridBagConstraints.BOTH;
        buttonConstraints.insets = new Insets(5, 5, 5, 5);

        // Add the first button
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 0;
        JButton button1 = new JButton("Click me!");
        button1.setPreferredSize(new Dimension(100, 50)); // Set the button size
        container.add(button1, buttonConstraints);

        // Add the second button
        buttonConstraints.gridx = 1;
        buttonConstraints.gridy = 0;
        JButton button2 = new JButton("Me too!");
        button2.setPreferredSize(new Dimension(100, 50)); // Set the button size
        container.add(button2, buttonConstraints);

        pack();
        setLocationRelativeTo(null); // center the window on screen
    }

    public static void main(String[] args) {
        GridBagLayoutExample example = new GridBagLayoutExample();
        example.setVisible(true);
    }
}