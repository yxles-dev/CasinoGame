package com.dabest.games;

import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

import com.dabest.AccountInformation;
import com.dabest.GameSelector;

import net.miginfocom.swing.MigLayout;

public class RPS extends JFrame implements ActionListener {
    AccountInformation accInf = new AccountInformation();
    GameSelector gsl = new GameSelector();
    private JButton rockButton, paperButton, scissorsButton;
    private JLabel resultLabel;
    private int Cash = accInf.getCash();
    private int userScore, computerScore;
    private ImageIcon[] symbols = {
        new ImageIcon("src/icons/RPS/R.png"),
        new ImageIcon("src/icons/RPS/P.png"), 
        new ImageIcon("src/icons/RPS/S.png")
    };
    private JLabel resultImage = new JLabel(new ImageIcon("src/icons/RPS/R.png"));

    public void rpsGame() {

        JFrame rps = new JFrame();
        setLayout(new MigLayout("fill"));
        setLocationRelativeTo(null);
        setTitle("Digibet");
        

        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");


        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);


        resultLabel = new JLabel("Choose your move!");

        JButton back = new JButton("Go Back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                gsl.Game1();
            }
        });


        add(back, "dock north");
        add(rockButton, "cell 0 0");
        add(paperButton, "cell 0 0");
        add(scissorsButton, "cell 0 0");
        add(resultLabel, "cell 0 1, center");
        add(resultImage, "cell 0 2");


        rps.setSize(592, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String userMove = e.getActionCommand();
        String computerMove = getComputerMove();
        String result = getResult(userMove, computerMove);
        System.out.println(computerMove);


        Image img1 = symbols[0].getImage();
        Image img2 = symbols[1].getImage();
        Image img3 = symbols[2].getImage();
        resultLabel.setText("You chose " + userMove + ". Computer chose " + computerMove + ". " + result);
        if (computerMove.contains("Rock")) {
            resultImage.setIcon(new ImageIcon(img1));
        } if (computerMove.contains("Paper")) {
            resultImage.setIcon(new ImageIcon(img2));
        } if (computerMove.contains("Scissor")) {
            resultImage.setIcon(new ImageIcon(img3));
        }



        if (result.equals("You win!")) {
            int newvalue = Cash + 50;
            Cash = newvalue;
            AccountInformation.Cash = Cash;
            userScore++;
            finalScore();
        } else if (result.equals("Computer wins!")) {
            int newvalue = Cash - 50;
            Cash = newvalue;
            AccountInformation.Cash = Cash;
            computerScore++;
            finalScore();
        }
    }

    public void finalScore() {
        String finalResult = "Final score: You " + userScore + ", Computer " + computerScore + ", Your current money is " + Cash;
        JOptionPane.showMessageDialog(this, finalResult);
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