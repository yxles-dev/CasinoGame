import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameSelector {
    public void Game1() {
        System.out.println("Debug Game 1");
        System.out.println("To be used for Coin-Flip unless changed");

        JFrame coinflip = new JFrame();
        JLabel name = new JLabel("Select a Game");

        name.setBounds(256,105,165,29);
        name.setFont(new Font(null, Font.PLAIN, 24));

        

        ImageIcon img1 = new ImageIcon("src/icons/taoibon.jpg");
        Image img11 = img1.getImage();
        Image newimg1 = img11.getScaledInstance(156, 186, java.awt.Image.SCALE_SMOOTH);

        ImageIcon img2 = new ImageIcon("src/icons/pulaputi.jpg");
        Image img22 = img2.getImage();
        Image newimg2 = img22.getScaledInstance(156, 186, java.awt.Image.SCALE_SMOOTH);

        ImageIcon img3 = new ImageIcon("src/icons/sabong.jpg");
        Image img33 = img3.getImage();
        Image newimg3 = img33.getScaledInstance(156, 186, java.awt.Image.SCALE_SMOOTH);

        JButton game1 = new JButton(new ImageIcon(newimg2));
        JButton game2 = new JButton(new ImageIcon(newimg1));
        JButton game3 = new JButton(new ImageIcon(newimg3));


        game1.setBounds(69, 154, 156, 186);
        game2.setBounds(261, 154, 156, 186);
        game3.setBounds(453, 154, 156, 186);

        JLabel money = new JLabel("P 1000.00");
        money.setBounds(498, 69, 162, 24);
        money.setFont(new Font("Serif", Font.BOLD, 20));

        JButton purchase = new JButton("+");
        purchase.setBounds(635, 69, 25, 24);
        
        coinflip.setSize(678, 391);
        coinflip.setVisible(true);
        coinflip.setLayout(null);
        coinflip.setLocationRelativeTo(null);
        coinflip.setBackground(Color.decode("#2EC4B6"));
        coinflip.add(name);
        coinflip.add(game1);
        coinflip.add(game2);
        coinflip.add(game3);
        coinflip.add(money);
        coinflip.add(purchase);
    }
}