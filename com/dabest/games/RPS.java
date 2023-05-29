package com.dabest.games;

import java.awt.event.*;
import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class RPS extends JFrame implements ActionListener {
    private JButton rockButton, paperButton, scissorsButton;
    private JLabel resultLabel;
    private int userScore, computerScore;

    public void rpsGame() {
        setLayout(new MigLayout("fill"));
        setLocationRelativeTo(null);

        // Create buttons
        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");

        // Add action listeners to buttons
        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);

        // Create result label
        resultLabel = new JLabel("Choose your move!");

        // Add components to content pane
        add(rockButton, "cell 0 0");
        add(paperButton, "cell 0 0");
        add(scissorsButton, "cell 0 0");
        add(resultLabel, "cell 0 1, center");

        // Set window properties
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String userMove = e.getActionCommand();
        String computerMove = getComputerMove();
        String result = getResult(userMove, computerMove);

        // Update result label
        resultLabel.setText("You chose " + userMove + ". Computer chose " + computerMove + ". " + result);

        // Update scores
        if (result.equals("You win!")) {
            userScore++;
        } else if (result.equals("Computer wins!")) {
            computerScore++;
        }

        // Show final score after 3 rounds
        if (userScore + computerScore == 3) {
            String finalResult = "Final score: You " + userScore + ", Computer " + computerScore;
            JOptionPane.showMessageDialog(this, finalResult);
        }
    }

    private String getComputerMove() {
        String[] moves = {"Rock", "Paper", "Scissors"};
        int index = (int) (Math.random() * moves.length);
        return moves[index];
    }

    private String getResult(String userMove, String computerMove) {
        if (userMove.equals(computerMove)) {
            return "It's a tie!";
        } else if (userMove.equals("Rock") && computerMove.equals("Scissors")
                || userMove.equals("Paper") && computerMove.equals("Rock")
                || userMove.equals("Scissors") && computerMove.equals("Paper")) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
}