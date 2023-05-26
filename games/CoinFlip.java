package games;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CoinFlip extends JFrame implements ActionListener {
  private JButton flipButton;
  private JLabel coinLabel;

  public CoinFlip() {
    setTitle("Coin Flip");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 300);
    setLayout(new BorderLayout());

    flipButton = new JButton("Flip");
    flipButton.addActionListener(this);

    coinLabel = new JLabel();
    coinLabel.setHorizontalAlignment(JLabel.CENTER);

    add(flipButton, BorderLayout.NORTH);
    add(coinLabel, BorderLayout.CENTER);
  }

  public void actionPerformed(ActionEvent e) {
    int result = (int) (Math.random() * 2);
    if (result == 0) {
      coinLabel.setText("Heads");
    } else {
      coinLabel.setText("Tails");
    }
  }

  public static void main(String[] args) {
    CoinFlip gui = new CoinFlip();
    gui.setVisible(true);
  }
}