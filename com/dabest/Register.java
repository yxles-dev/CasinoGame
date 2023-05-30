package com.dabest;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.Border;

import net.miginfocom.swing.MigLayout;



public class Register implements ActionListener {
    TermsCon termsCon = new TermsCon();
    Login login = new Login();

    JFrame regFrame = new JFrame("Digibet");

    JTextField inputFN = new JTextField();
    JTextField inputLN = new JTextField();
    JTextField inputUN = new JTextField();
    JPasswordField inputPW = new JPasswordField();
    JPasswordField inputCPW = new JPasswordField();

    public void registerScreen() {
        System.out.println("Launching Register Screen");
        Border blackline = BorderFactory.createLineBorder(Color.black);

        JLabel regJLabel = new JLabel("Register");
        regJLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        regJLabel.setBounds(29, 22, 97, 26);

        JLabel firstName = new JLabel("First Name:");
        firstName.setFont(new Font("Serif", Font.PLAIN, 15));
        firstName.setBounds(107, 94, 91, 20);
        inputFN.setBounds(231, 94, 158, 20);
        inputFN.setBorder(blackline);

        JLabel lastName = new JLabel("Last Name:");
        lastName.setFont(new Font(null, Font.PLAIN, 15));
        lastName.setBounds(116, 120, 91, 20);
        inputLN.setBounds(231, 120, 158, 20);
        inputLN.setBorder(blackline);

        JLabel username = new JLabel("Username:");
        username.setFont(new Font(null, Font.PLAIN, 15));
        username.setBounds(120, 147, 82, 20);
        inputUN.setBounds(231, 147, 158, 20);
        inputUN.setBorder(blackline);

        JLabel password = new JLabel("Password:");
        password.setFont(new Font(null, Font.PLAIN, 15));
        password.setBounds(120, 173, 82, 20);
        inputPW.setBounds(231, 173, 158, 20);
        inputPW.setBorder(blackline);

        JLabel confirmPass = new JLabel("Confirm Password:");
        confirmPass.setFont(new Font(null, Font.PLAIN, 15));
        confirmPass.setBounds(48, 199, 154, 20);
        inputCPW.setBounds(231, 199, 158, 20);
        inputCPW.setBorder(blackline);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(102,247,55,25);
        cancel.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                String[] options = { "Yes", "No"};
                int selection = JOptionPane.showOptionDialog(null, "Are you sure?", null, 0, 2, null, options, options[0]);
                System.out.println(selection);

                if (selection == 0) {
                    regFrame.dispose();
                    try {
                        login.loginScreen();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                }
            }  
        });

        JButton accept = new JButton("Accept");
        accept.setBounds(295, 247, 55, 25);
        accept.addActionListener(this);

        regFrame.setSize(461,391);
        regFrame.setVisible(true);
        regFrame.setLayout(new MigLayout("fill"));
        regFrame.setLocationRelativeTo(null);
        regFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        regFrame.add(regJLabel, "dock north, gapleft 40, gaptop 30");
        regFrame.add(firstName, "cell 0 0, gapleft 60, gapright 30, gaptop 10");
        regFrame.add(inputFN, "cell 0 0, growx, gapright 20");
        regFrame.add(lastName, "cell 0 1, gapleft 60, gapright 25");
        regFrame.add(inputLN, "cell 0 1, growx, gapright 20");
        regFrame.add(username, "cell 0 2, gapleft 60, gapright 27");
        regFrame.add(inputUN, "cell 0 2, growx, gapright 20");
        regFrame.add(password, "cell 0 3, gapleft 60, gapright 31");
        regFrame.add(inputPW, "cell 0 3, growx, gapright 20");
        regFrame.add(confirmPass, "cell 0 4, gapleft 60");
        regFrame.add(inputCPW, "cell 0 4, growx, gapright 20");
        regFrame.add(cancel, "cell 0 5, center, gapright 60");
        regFrame.add(accept, "cell 0 5, center");
    }

    public void actionPerformed(ActionEvent e) {
        String uName = inputUN.getText();
        String fName = inputFN.getText();
        String lName = inputLN.getText();
        String password = String.valueOf(inputPW.getPassword());
        String confirmPassword = String.valueOf(inputCPW.getPassword());

        if (inputFN.getText().isEmpty()) {
            JOptionPane.showMessageDialog(regFrame,"Please complete the form");  
        } else if (inputLN.getText().isEmpty()) {
            JOptionPane.showMessageDialog(regFrame,"Please complete the form");
        } else if (inputUN.getText().isEmpty()) {
            JOptionPane.showMessageDialog(regFrame,"Please complete the form");
        } else if (password.equals("")) {
            JOptionPane.showMessageDialog(regFrame,"Please complete the form");
        } else if (!confirmPassword.equals(password)) {
            System.out.println("No");
            JOptionPane.showMessageDialog(regFrame,"Password doesnt match");
        } else
            try {
                if (checkUsername(uName) == true) {
                    try {
                        if (checkUsername(uName) == true) {
                            JOptionPane.showMessageDialog(regFrame,"This account already exists");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                } else {

                    PreparedStatement ps;
                    String query = "INSERT INTO `account`(`u_fname`, `u_lname`, `u_uname`, `u_password`) VALUES (?,?,?,?)";

                    System.out.println(uName+fName+lName+password);
                    
                    try {
                        ps = MyConnection.getConnection().prepareStatement(query);
                        ps.setString(1, fName);
                        ps.setString(2, lName);
                        ps.setString(3, uName);
                        ps.setString(4, password);
                            
                        if (ps.executeUpdate() > 0)
                        {
                            JOptionPane.showMessageDialog(null, "New User Add");
                            JOptionPane.showMessageDialog(null, "To bypass an issue with MariaDB, the program will now close to allow logging in into account");
                            //login.loginScreen();
                            //regFrame.dispose();
                            System.exit(0);
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    } 
                }
            } catch (HeadlessException e1) {
                e1.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
    }

    public boolean checkUsername(String username) throws SQLException
    {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `account` WHERE `u_uname` =?";
        
        
        ps = MyConnection.getConnection().prepareStatement(query);
        ps.setString(1, username);
            
        rs = ps.executeQuery();
            
        if(rs.next())
        {
            checkUser = true;
        }

        return checkUser;
    }
}
