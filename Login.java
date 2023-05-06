import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

import javax.swing.*;
import javax.swing.border.Border;

public class Login {
    public void loginScreen() throws FileNotFoundException {
        System.out.println("Launching Login Screen"); // Debug
        TermsCon termsCondition = new TermsCon();
        System.out.println("Remove Debug after debugging");

        JFrame lgnFrame = new JFrame("Login");

        

        JLabel text = new JLabel("Login");
        text.setFont(new Font(null, Font.PLAIN, 20));
        JLabel email = new JLabel("E-Mail");
        email.setFont(new Font(null, Font.PLAIN, 14));
        JLabel pass = new JLabel("Password");
        pass.setFont(new Font(null, Font.PLAIN, 14));

        JTextArea username = new JTextArea();
        JPasswordField password = new JPasswordField();

        text.setBounds(32, 25, 52, 24);
        email.setBounds(76, 67, 46, 17);
        pass.setBounds(76,130,69,17);

        username.setBounds(83, 91, 335, 32);
        password.setBounds(83, 154, 335, 32);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        username.setBorder(blackline);
        username.setBackground(Color.WHITE);
        password.setBackground(Color.WHITE);
        password.setBorder(blackline);

        JButton signin = new JButton(new ImageIcon("src/icons/sign-in.png"));
        signin.setBounds(194,212,112,32);
        signin.setBorderPainted(false);

        JLabel or = new JLabel("or");
        or.setBounds(245, 249, 12, 15);
        or.setFont(new Font("Serif", Font.PLAIN, 12));
        
        JLabel register = new JLabel("Create an Account");
        register.setBounds(189, 269, 124, 17);
        register.setFont(new Font("Serif", Font.PLAIN, 14));

        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle the click event here
                try {
                    termsCondition.Terms();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                lgnFrame.dispose();
            }
        });

        JButton dbgGame1 = new JButton("Debug Game 1");
        dbgGame1.setBounds(24,247,84,36);
        dbgGame1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    termsCondition.Terms();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                lgnFrame.dispose();
            }
        });

        lgnFrame.setSize(520, 366);
        lgnFrame.setMinimumSize(new Dimension(520, 366));
        lgnFrame.setLayout(null);
        lgnFrame.setLocationRelativeTo(null);
        lgnFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lgnFrame.add(username);
        lgnFrame.add(password);
        lgnFrame.add(email);
        lgnFrame.add(pass);
        lgnFrame.add(text);
        lgnFrame.add(signin);
        lgnFrame.add(or);
        lgnFrame.add(register);

        lgnFrame.add(dbgGame1);

        lgnFrame.setVisible(true);
    }
}
