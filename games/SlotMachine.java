package games;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SlotMachine extends JFrame implements ActionListener {
    private JButton spinButton;
    private JLabel[] reels;
    private String[] symbols = {"Cherry", "Lemon", "Orange", "Plum", "Bell", "Bar", "Seven"};
    private int[] payouts = {2, 3, 4, 5, 10, 20, 50};
    private int credits = 100;
    private int bet = 1;

    public SlotMachine() {
        super("Slot Machine");

        // Create the reels
        reels = new JLabel[3];
        for (int i = 0; i < 3; i++) {
            reels[i] = new JLabel(symbols[0], JLabel.CENTER);
            reels[i].setFont(new Font("SansSerif", Font.BOLD, 24));
            reels[i].setOpaque(true);
            reels[i].setBackground(Color.white);
            reels[i].setPreferredSize(new Dimension(100, 100));
        }

        // Create the spin button
        spinButton = new JButton("Spin");
        spinButton.addActionListener(this);

        // Add the components to the content pane
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JPanel reelsPanel = new JPanel(new GridLayout(1, 3));
        for (int i = 0; i < 3; i++) {
            reelsPanel.add(reels[i]);
        }
        c.add(reelsPanel, BorderLayout.CENTER);
        c.add(spinButton, BorderLayout.SOUTH);

        // Set the size and show the frame
        setSize(400, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Spin the reels
        for (int i = 0; i < 3; i++) {
            int symbolIndex = (int) (Math.random() * symbols.length);
            reels[i].setText(symbols[symbolIndex]);
        }

        // Calculate the payout
        int payout = 0;
        if (reels[0].getText().equals(reels[1].getText()) && reels[1].getText().equals(reels[2].getText())) {
            int symbolIndex = java.util.Arrays.asList(symbols).indexOf(reels[0].getText());
            payout = payouts[symbolIndex] * bet;
        }

        // Update the credits and display the payout
        credits += payout - bet;
        JOptionPane.showMessageDialog(this, "Payout: " + payout + "\nCredits: " + credits);

        // Disable the spin button if the player is out of credits
        if (credits < bet) {
            spinButton.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        new SlotMachine();
    }
}
