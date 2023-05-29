package com.dabest;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.Border;

import net.miginfocom.swing.MigLayout;

public class Login {
    AccountInformation accInf = new AccountInformation();
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JFrame lgnFrame = new JFrame("Login");
    GameSelector gameSelector = new GameSelector();
    SoundManager soundManager = new SoundManager();
    public static String userName;

    public void paint(Graphics g)
    {
        Image img = Toolkit.getDefaultToolkit().getImage("src/loginbackground.png");

        g.drawImage(img, 0, 0, null);
    }

    public void loginScreen() throws FileNotFoundException {
        lgnFrame.setLayout(new MigLayout("fill"));
        System.out.println("Launching Login Screen"); // Debug
        TermsCon termsCondition = new TermsCon();

        JLabel text = new JLabel("Login");
        text.setFont(new Font(null, Font.PLAIN, 20));
        JLabel email = new JLabel("Username");
        email.setFont(new Font(null, Font.PLAIN, 14));
        JLabel pass = new JLabel("Password");
        pass.setFont(new Font(null, Font.PLAIN, 14));

        Border blackline = BorderFactory.createLineBorder(Color.black);
        username.setBorder(blackline);
        username.setBackground(Color.WHITE);
        password.setBackground(Color.WHITE);
        password.setBorder(blackline);

        JButton signin = new JButton(new ImageIcon("src/icons/sign-in.png"));
        signin.setOpaque(false);
        signin.setContentAreaFilled(false);
        signin.setBorderPainted(false);
        signin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signin.setCursor(Cursor.getDefaultCursor());
            }
        });
        signin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent f) {
                soundManager.playButton();
                login();
            }
        });
        password.addActionListener(e -> signin.doClick());

        JLabel or = new JLabel("or");
        or.setFont(new Font("Serif", Font.PLAIN, 12));
        
        JLabel register = new JLabel("Create an Account");
        register.setFont(new Font("Serif", Font.PLAIN, 14));

        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                register.setCursor(Cursor.getDefaultCursor());
            }
        });
        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle the click event here
                try {
                    soundManager.playButton();
                    termsCondition.Terms();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                lgnFrame.dispose();
            }
        });

        JButton debugButton = new JButton("Debug Login");
        debugButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent d) {
                String[] options = { "Login using Debug Account", "Dont login and just go to GameSelector (not recommended)"};
                int selection = JOptionPane.showOptionDialog(null, "What type of Debug Login?", null, 0, 2, null, options, options[0]);
                soundManager.playButton();

                if (selection == 0) {  
                    debugLogin();
                } else {
                    lgnFrame.dispose();
                    gameSelector.Game1();
                }
            }
        });

        lgnFrame.setSize(520, 366);
        lgnFrame.setMinimumSize(new Dimension(520, 366));

        lgnFrame.setLocationRelativeTo(null);
        lgnFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lgnFrame.add(text, "dock north, gapleft 40, gaptop 30");
        lgnFrame.add(email, "cell 0 0, gapleft 60");
        lgnFrame.add(username, "cell 1 0, span 2, growx, gapright 20");
        lgnFrame.add(pass, "cell 0 1, gapleft 60");
        lgnFrame.add(password, "cell 1 1, span 2, growx, gapright 20");
        lgnFrame.add(signin, "cell 0 2, center, gapleft 60, width 112!, height 32!");
        lgnFrame.add(or, "cell 1 2, center");
        lgnFrame.add(register, "cell 2 2, center, gapright 60");
        lgnFrame.add(debugButton, "cell 1 3, center");
        lgnFrame.pack();

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
                accInf.getID(uname);
                JOptionPane.showMessageDialog(lgnFrame,"Login Successful");
                lgnFrame.dispose();
                gameSelector.Game1();
            }
            else{
                    JOptionPane.showMessageDialog(null, "Incorrect Username Or Password", "Login Failed", 2);
                }
            
        } catch (SQLSyntaxErrorException e1) {
            JOptionPane.showMessageDialog(null, "Cannot connect to the internet", "Login Failed", 2);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void debugLogin() {
        PreparedStatement ps;
        ResultSet rs;
        String uname = "Debug";
        String pass = "debug";
        
        String query = "SELECT * FROM `account` WHERE `u_uname` =? AND `u_password` =?";
        
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
            ps.setString(1, uname);
            ps.setString(2, pass);
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                accInf.getID(uname);
                JOptionPane.showMessageDialog(lgnFrame,"Login Successful");
                lgnFrame.dispose();
                gameSelector.Game1();
            }
            else{
                    JOptionPane.showMessageDialog(null, "Incorrect Username Or Password", "Login Failed", 2);
                }
            
        } catch (SQLSyntaxErrorException e1) {
            JOptionPane.showMessageDialog(null, "Cannot connect to the internet", "Login Failed", 2);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
