import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class GameSelector {
    AccountInformation accInf = new AccountInformation();
    DebugMenu dbgMenu = new DebugMenu();
    Purchase buyCash = new Purchase();
    public void Game1() {
        //Loading Screen
        JFrame loading = new JFrame();
        JLabel text = new JLabel("Loading...");
        text.setBounds(74, 30, 121, 26);
        loading.setTitle("Loading");
        loading.setSize(269,86);
        loading.setLocationRelativeTo(null);
        loading.add(text);
        loading.setVisible(true);

        System.out.println("Launching GameSelector");
        // System.out.println("Debug Game 1");
        // System.out.println("To be used for Coin-Flip unless changed");

        JFrame coinflip = new JFrame();
        JLabel name = new JLabel("Select a Game");

        name.setFont(new Font(null, Font.PLAIN, 24));

        accInf.setAccInf();

        ImageIcon img1 = new ImageIcon("src/icons/taoibon.png");
        Image img11 = img1.getImage();
        Image newimg1 = img11.getScaledInstance(156, 186, java.awt.Image.SCALE_SMOOTH);

        ImageIcon img2 = new ImageIcon("src/icons/pulaputi.png");
        Image img22 = img2.getImage();
        Image newimg2 = img22.getScaledInstance(156, 186, java.awt.Image.SCALE_SMOOTH);

        ImageIcon img3 = new ImageIcon("src/icons/sabong.png");
        Image img33 = img3.getImage();
        Image newimg3 = img33.getScaledInstance(156, 186, java.awt.Image.SCALE_SMOOTH);

        JButton game1 = new JButton(new ImageIcon(newimg2));
        JButton game2 = new JButton(new ImageIcon(newimg1));
        JButton game3 = new JButton(new ImageIcon(newimg3));


        game1.setBounds(69, 154, 156, 186);
        game1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dbgMenu.debugMenu();
            }
        });

        game2.setBounds(261, 154, 156, 186);
        game2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent g2) {
                RPSTutorial rpst = new RPSTutorial();
                try {
                    coinflip.dispose();
                    rpst.rps();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });


        game3.setBounds(453, 154, 156, 186);

        JLabel money = new JLabel("₱ "+String.valueOf(accInf.getCash())+".00");
        money.setBounds(498, 69, 162, 24);
        money.setFont(new Font("Serif", Font.BOLD, 20));
        
        Timer timer = new Timer(1000, e -> {
            Runnable labelUpdater = () -> money.setText("₱ "+String.valueOf(accInf.getCash())+".00");
            SwingUtilities.invokeLater(labelUpdater);
        });
        timer.start();

        JButton purchase = new JButton("+");
        purchase.setBounds(635, 69, 25, 24);
        purchase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent p) {
                buyCash.purchaseScreen();
            }
        });
        
        coinflip.setSize(698, 458);
        coinflip.setMinimumSize(new Dimension(698, 458));
        coinflip.setLayout(null);
        coinflip.setLocationRelativeTo(null);
        coinflip.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        coinflip.add(name);
        coinflip.add(game1);
        coinflip.add(game2);
        coinflip.add(game3);
        coinflip.add(money);
        coinflip.add(purchase);
        loading.dispose();
        coinflip.setVisible(true);
    }
}
