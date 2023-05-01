import java.awt.Color;

import javax.swing.*;

public class Login {
    public void LoginScreen() {
        System.out.println("Launching Login Screen");

        JFrame lgnFrame = new JFrame("Login");
        JLabel text = new JLabel("Login");
        JTextArea username = new JTextArea();
        JTextArea password = new JTextArea();

        text.setBounds(224, 35, 52, 24);
        username.setBounds(155, 85, 189, 32);
        password.setBounds(155, 134, 189, 32);
        username.setBackground(Color.DARK_GRAY);
        password.setBackground(Color.DARK_GRAY);

        lgnFrame.setSize(500, 300);
        lgnFrame.setVisible(true);
        lgnFrame.setLayout(null);
        lgnFrame.setLocationRelativeTo(null);
        lgnFrame.add(username);
        lgnFrame.add(password);
        lgnFrame.add(text);
    }
}
