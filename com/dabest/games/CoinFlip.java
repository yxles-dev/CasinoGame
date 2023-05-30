package com.dabest.games;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CoinFlip extends JFrame implements ActionListener {
  private JButton flipButton;
  private JLabel coinLabel;

  public void cfGame() {

    JFrame cf = new JFrame("Digibet");
    JButton backb = new JButton("Go Back");

      ImageIcon Heads = new ImageIcon("src/icons/");
      Image one = Heads.getImage();

      ImageIcon Tails = new ImageIcon("src/icons/");
      Image two = Tails.getImage();

        backb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cf.dispose();
                //callback.onWindowClosed();
            }
        });


        JButton play = new JButton("Play");

        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cf.dispose();
            }
        });


    coinLabel = new JLabel();
    coinLabel.setHorizontalAlignment(JLabel.CENTER);

    setSize(592, 366);
    setLayout(new BorderLayout());
    setLocationRelativeTo(null);
    setResizable(false);


    //cf.add(flipButton, BorderLayout.NORTH);
    //cf.add(coinLabel, BorderLayout.CENTER);
    cf.add(flipButton, "cell 0 2, center, width 112!, height 32!");
    cf.add(backb, "cell 0 2, center, width 112!, height 32!, gapright 40");
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    int result = (int) (Math.random() * 2);
    if (result == 0) {
       new ImageIcon(Heads);
    } else {
      coinLabel.setIcon("Tails");
    }
  }
}