package com.dabest;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;

public class Purchase {
    AccountInformation accInf = new AccountInformation();
    public void purchaseScreen() {
        JFrame purScreen = new JFrame();
        JLabel text = new JLabel("Purchase Cash");
        purScreen.setLayout(new MigLayout("fill"));
        purScreen.setLocationRelativeTo(null);
        JButton buy50 = new JButton("Buy ₱50.00");
        buy50.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent b50) {
                AccountInformation.Cash = AccountInformation.Cash + 50;
                accInf.updateCash();
                JOptionPane.showMessageDialog(null,"Bought Successful");
            }
        });

        JButton buy100 = new JButton("Buy ₱100.00");
        buy100.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent b100) {
                AccountInformation.Cash = AccountInformation.Cash + 100;
                accInf.updateCash();
                JOptionPane.showMessageDialog(null,"Bought Successful");
            }
        });

        JButton buy200 = new JButton("Buy ₱200.00");
        buy200.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent b200) {
                AccountInformation.Cash = AccountInformation.Cash + 200;
                accInf.updateCash();
                JOptionPane.showMessageDialog(null,"Bought Successful");
            }
        });
        JButton buy500 = new JButton("Buy ₱500.00");
        buy500.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent b500) {
                AccountInformation.Cash = AccountInformation.Cash + 500;
                accInf.updateCash();
                JOptionPane.showMessageDialog(null,"Bought Successful");
            }
        });

        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        purScreen.add(text, "span 2, center, wrap");
        purScreen.add(buy50, "cell 0 1");
        purScreen.add(buy100, "cell 0 1");
        purScreen.add(buy200, "cell 0 2");
        purScreen.add(buy500, "cell 0 2");
        purScreen.pack();     
        purScreen.setVisible(true);
        
    }
}