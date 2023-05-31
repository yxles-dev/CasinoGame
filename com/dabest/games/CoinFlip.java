package com.dabest.games;

import java.awt.event.*;
import javax.swing.*;

import com.dabest.AccountInformation;
import com.dabest.GameSelector;

import net.miginfocom.swing.MigLayout;

public class CoinFlip {
  GameSelector gsl = new GameSelector();
  AccountInformation accInf = new AccountInformation();
  private int playerChoice = 0;
  private JLabel coinLabel;
  private int Cash = accInf.getCash();

  public void cfGame() {
    JFrame cf = new JFrame();
    cf.setTitle("Coin Flip");
    cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cf.setSize(300, 300);
    cf.setLayout(new MigLayout("fill"));

    JButton back = new JButton("Go Back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cf.dispose();
                gsl.Game1();
            }
        });

    JButton head = new JButton("Head");
    head.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        playerChoice = 1;
        play();
      }
    });

    JButton tails = new JButton("Tails");
    tails.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        playerChoice = 0;
        play();
      }
    });

    coinLabel = new JLabel();
    coinLabel.setHorizontalAlignment(JLabel.CENTER);

    cf.add(back, "dock north");
    cf.add(head, "cell 0 0, center");
    cf.add(tails, "cell 0 0, center");
    cf.add(coinLabel, "cell 0 1, center");
    cf.setSize(300, 300);
    cf.setVisible(true);
  }

  public void play() {
    ImageIcon headIcon = new ImageIcon("src/icons/CoinFlip/Head.png");
    ImageIcon tailsIcon = new ImageIcon("src/icons/CoinFlip/Tails.png");
    ImageIcon resultImage;
    String resultString;
    int result = (int) (Math.random() * 1);
    switch (result) {
      case 0:
        resultImage = headIcon;
        resultString = "Head";
        break;
      case 1:
        resultImage = tailsIcon;
        resultString = "Tails";
        break;
      default:
        resultImage = headIcon;
        resultString = "Head";
        break;
    }
    if (playerChoice == result) {
      int newCash = Cash - 50;
      Cash = newCash;
      AccountInformation.Cash = Cash;
      coinLabel.setIcon(resultImage);
      JOptionPane.showMessageDialog(null, "The computer chose " + resultString + " and you lose 50 cash" + "\nCash: " + Cash);
    } else {
      int newCash = Cash + 50;
      Cash = newCash;
      AccountInformation.Cash = Cash;
      coinLabel.setIcon(resultImage);
      JOptionPane.showMessageDialog(null, "The computer chose " + resultString + " and you won 50 cash" + "\nCash: " + Cash);
    }
  }
}