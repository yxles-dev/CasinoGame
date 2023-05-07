import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.Border;

public class Login {
    JTextArea username = new JTextArea();
    JPasswordField password = new JPasswordField();
    JFrame lgnFrame = new JFrame("Login");
    GameSelector gameSelector = new GameSelector();

    public void loginScreen() throws FileNotFoundException {
        System.out.println("Launching Login Screen"); // Debug
        TermsCon termsCondition = new TermsCon();

        JLabel text = new JLabel("Login");
        text.setFont(new Font(null, Font.PLAIN, 20));
        JLabel email = new JLabel("Username");
        email.setFont(new Font(null, Font.PLAIN, 14));
        JLabel pass = new JLabel("Password");
        pass.setFont(new Font(null, Font.PLAIN, 14));

        text.setBounds(32, 25, 52, 24);
        email.setBounds(76, 67, 69, 17);
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
        signin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent f) {
                login();
            }
        });

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

        lgnFrame.setVisible(true);
    }

    public void login() {
        PreparedStatement ps;
        ResultSet rs;
        String uname = username.getText();
        String pass = String.valueOf(password.getPassword());
        
        String query = "SELECT * FROM `account` WHERE `u_uname` =? AND `u_password` =?";
        
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
            ps.setString(1, uname);
            ps.setString(2, pass);
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                JOptionPane.showMessageDialog(lgnFrame,"Login Successful");
                lgnFrame.dispose();
                gameSelector.Game1();
            }
            else{
                    JOptionPane.showMessageDialog(null, "Incorrect Username Or Password", "Login Failed", 2);
                }
            
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        
        
    }
}
