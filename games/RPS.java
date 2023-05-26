package games;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RPS extends JFrame implements ActionListener {
    private JButton rockButton, paperButton, scissorsButton;
    private JLabel resultLabel;
    private int userScore, computerScore;

    public RPS() {
        super("Rock Paper Scissors");

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
        Container c = getContentPane();
        c.setLayout(new GridLayout(4, 1));
        c.add(rockButton);
        c.add(paperButton);
        c.add(scissorsButton);
        c.add(resultLabel);

        // Set window properties
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    public static void main(String[] args) {
        new RPS();
    }
}