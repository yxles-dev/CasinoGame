import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class Login {
    public void LoginScreen() {
        System.out.println("Launching Login Screen"); // Debug

        JFrame lgnFrame = new JFrame("Login");

        JLabel text = new JLabel("Login");
        text.setFont(new Font(null, Font.PLAIN, 20));
        JLabel email = new JLabel("E-Mail");
        email.setFont(new Font(null, Font.PLAIN, 14));
        JLabel pass = new JLabel("Password");
        pass.setFont(new Font(null, Font.PLAIN, 14));

        JTextArea username = new JTextArea();
        JTextArea password = new JTextArea();

        text.setBounds(32, 25, 52, 24);
        email.setBounds(76, 67, 46, 17);
        pass.setBounds(76,130,69,17);

        username.setBounds(83, 91, 335, 32);
        password.setBounds(83, 154, 335, 32);
        username.setBackground(Color.DARK_GRAY);
        password.setBackground(Color.DARK_GRAY);

        JButton signin = new JButton(new ImageIcon("src/icons/sign-in.png"));
        signin.setBounds(194,212,112,32);
        signin.setBorderPainted(false);

        JLabel or = new JLabel("or");
        or.setBounds(245, 249, 12, 15);
        or.setFont(new Font("Serif", Font.PLAIN, 12));
        JLabel register = new JLabel("Create an Account");
        register.setBounds(189, 269, 124, 17);
        register.setFont(new Font("Serif", Font.PLAIN, 14));

        lgnFrame.setSize(500, 300);
        lgnFrame.setVisible(true);
        lgnFrame.setLayout(null);
        lgnFrame.setLocationRelativeTo(null);
        lgnFrame.add(username);
        lgnFrame.add(password);
        lgnFrame.add(email);
        lgnFrame.add(pass);
        lgnFrame.add(text);
        lgnFrame.add(signin);
        lgnFrame.add(or);
        lgnFrame.add(register);
    }
}
