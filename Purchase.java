import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class Purchase extends JFrame {
    public Purchase() {
        // Set the layout manager to MigLayout
        setLayout(new MigLayout());

        // Create the components
        JLabel label1 = new JLabel("First Name:");
        JLabel label2 = new JLabel("Last Name:");
        JTextField textField1 = new JTextField(20);
        JTextField textField2 = new JTextField(20);
        JButton button = new JButton("Submit");

        // Add the components to the container with constraints
        add(label1, "cell 0 0"); // cell 0,0 (row 0, column 0)
        add(textField1, "cell 1 0"); // cell 1,0 (row 0, column 1)
        add(label2, "cell 0 1"); // cell 0,1 (row 1, column 0)
        add(textField2, "cell 1 1"); // cell 1,1 (row 1, column 1)
        add(button, "cell 0 2, span 2"); // cell 0,2 (row 2, column 0), span 2 columns

        // Set the window properties
        setTitle("MigLayout Example");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of the JFrame
        new Purchase();
    }
}
