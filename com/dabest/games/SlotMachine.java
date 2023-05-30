package com.dabest.games;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.dabest.AccountInformation;
import com.dabest.GameSelector;
import com.dabest.tools.WindowLocation;

import net.miginfocom.swing.MigLayout;

public class SlotMachine extends JFrame implements ActionListener {
    AccountInformation accInf = new AccountInformation();
    private JButton spinButton;
    private JLabel[] reels;
    private ImageIcon[] symbols = {
        new ImageIcon("src/icons/SlotMachine/Cherry.png"),
        new ImageIcon("src/icons/SlotMachine/Lemon.png"), 
        new ImageIcon("src/icons/SlotMachine/Orange.png"), 
        new ImageIcon("src/icons/SlotMachine/Plum.png"), 
        new ImageIcon("src/icons/SlotMachine/Bell.png"), 
        new ImageIcon("src/icons/SlotMachine/Bar.png"), 
        new ImageIcon("src/icons/SlotMachine/Lucky7.png")
    };
    private int[] payouts = {2, 3, 4, 5, 10, 20, 50};
    private int credits = accInf.getCash();
    private int bet = 1;

    public void smGame() {
        GameSelector gsl = new GameSelector();
        // Create the reels
        reels = new JLabel[3];
        for (int i = 0; i < 3; i++) {
            reels[i] = new JLabel(symbols[0], JLabel.CENTER);
            reels[i].setOpaque(true);
            reels[i].setBackground(Color.white);
            reels[i].setPreferredSize(new Dimension(100, 100));
        }

        // Create the spin button
        spinButton = new JButton("Spin");
        spinButton.addActionListener(this);

        // Back Button
        JButton back = new JButton("Go Back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                gsl.Game1();
            }
        });

        // Add the components to the content pane
        Container c = getContentPane();
        c.setLayout(new MigLayout("fill"));
        JPanel reelsPanel = new JPanel(new GridLayout(1, 3));
        for (int i = 0; i < 3; i++) {
            reelsPanel.add(reels[i]);
        }
        c.add(reelsPanel, "cell 0 0, center");
        c.add(spinButton, "cell 0 1, center");
        c.add(back, "dock north");

        // Set the size and show the frame
        WindowLocation wl = new WindowLocation();
        setLocation(wl.getLocation());
        setSize(700, 340);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Spin the reels
        for (int i = 0; i < 3; i++) {
            int symbolIndex = generateRandomSymbolIndex();
            reels[i].setIcon(symbols[symbolIndex]);
        }

        // Calculate the payout
        int payout = 0;
        ImageIcon icon1 = (ImageIcon) reels[0].getIcon();
        ImageIcon icon2 = (ImageIcon) reels[1].getIcon();
        ImageIcon icon3 = (ImageIcon) reels[2].getIcon();

        if (icon1.getImage().equals(icon2.getImage()) && icon2.getImage().equals(icon3.getImage())) {
            ImageIcon icon = (ImageIcon) reels[0].getIcon();
            int symbolIndex = java.util.Arrays.asList(symbols).indexOf(icon);
            System.out.println(symbolIndex);
            payout = payouts[symbolIndex] * bet;
        }

        // Update the credits and display the payout
        credits += payout - bet;
        JOptionPane.showMessageDialog(this, "Payout: " + payout + "\nCredits: " + credits);

        // Disable the spin button if the player is out of credits
        if (credits < bet | credits == 0) {
            spinButton.setEnabled(false);
        }
    }
    private int generateRandomSymbolIndex() {
        double[] probabilities = {0.3, 0.2, 0.15, 0.15, 0.08, 0.07, 0.05}; // Adjust the probabilities as desired
        
        double randomValue = Math.random();
        double cumulativeProbability = 0.0;
        
        for (int i = 0; i < probabilities.length; i++) {
            cumulativeProbability += probabilities[i];
            if (randomValue <= cumulativeProbability) {
                return i;
            }
        }
        
        return probabilities.length - 1;
    }
}
