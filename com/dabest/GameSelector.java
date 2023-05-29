package com.dabest;
/*  Game 1 = Pula Puti
    Game 2 = Tao-Ibon Coin Flip
    Game 3 = Sabong
    Game 4 = Slot Machine 
*/

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.*;

import com.dabest.tools.WindowClosedCallback;

import net.miginfocom.swing.MigLayout;

public class GameSelector {
    AccountInformation accInf = new AccountInformation();
    DebugMenu dbgMenu = new DebugMenu();
    Purchase buyCash = new Purchase();
    JFrame coinflip = new JFrame();

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

        JLabel name = new JLabel("Select a Game");

        name.setFont(new Font(null, Font.PLAIN, 24));

        accInf.setAccInf();

        ImageIcon img1 = new ImageIcon("src/icons/taoibon.png");
        Image img11 = img1.getImage();
        Image newimg1 = img11.getScaledInstance(156, 186, java.awt.Image.SCALE_SMOOTH);

        ImageIcon img2 = new ImageIcon("src/icons/rockscissorpaper.png");
        Image img22 = img2.getImage();
        Image newimg2 = img22.getScaledInstance(156, 186, java.awt.Image.SCALE_SMOOTH);

        ImageIcon img4 = new ImageIcon("src/icons/slotmachine.png");
        Image img44 = img4.getImage();
        Image newimg4 = img44.getScaledInstance(156, 186, java.awt.Image.SCALE_SMOOTH);

        JButton game1 = new JButton(new ImageIcon(newimg1)); // Tao-Ibon
        JButton game2 = new JButton(new ImageIcon(newimg2)); // Rock Paper Scissor
        JButton game3 = new JButton(new ImageIcon(newimg4)); // Slot Machine

        game1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent g2) {
                coinflip.setEnabled(false);
                TCTutorial tct = new TCTutorial(new WindowClosedCallback() {
                    public void onWindowClosed() {
                        coinflip.setEnabled(true);  // Enable the button when the JFrame is closed
                    }
                });
                try {
                    tct.tc();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        game2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent g3) {
                coinflip.setEnabled(false);
                RPSTutorial rpst = new RPSTutorial(new WindowClosedCallback() {
                    public void onWindowClosed() {
                        coinflip.setEnabled(true);  // Enable the button when the JFrame is closed
                    }
                });
                try {
                    rpst.rps();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        game3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent g3) {
                coinflip.setEnabled(false);
                SMTutorial smt = new SMTutorial(new WindowClosedCallback() {
                    public void onWindowClosed() {
                        coinflip.setEnabled(true);  // Enable the button when the JFrame is closed
                    }
                });
                try {
                    smt.sm();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        JLabel money = new JLabel("₱ "+String.valueOf(accInf.getCash())+".00");
        // money.setBounds(498, 69, 162, 24);
        money.setFont(new Font("Serif", Font.BOLD, 20));
        
        Timer timer = new Timer(1000, e -> {
            Runnable labelUpdater = () -> money.setText("₱ "+String.valueOf(accInf.getCash())+".00");
            SwingUtilities.invokeLater(labelUpdater);
        });
        timer.start();

        JButton purchase = new JButton("+");
        // purchase.setBounds(635, 69, 25, 24);
        purchase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent p) {
                buyCash.purchaseScreen();
            }
        });

        JButton debug = new JButton("Debug");
        debug.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent debug) {
                dbgMenu.debugMenu();
            }
        });
        
        
        coinflip.setSize(698, 458);
        coinflip.setLayout(new MigLayout("fill"));
        coinflip.setLocationRelativeTo(null);
        coinflip.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        coinflip.add(money, "cell 0 0, gapbefore push");
        coinflip.add(purchase, "cell 0 0");
        coinflip.add(name, "cell 0 1, span 2, center, wrap");
        // coinflip.add(game1, "cell 0 2, center, width 156!, height 186!, gapleft 20, gapright 20");
        coinflip.add(game1, "cell 0 2, center, width 156!, height 186!, gapleft 20, gapright 20");
        coinflip.add(game2, "cell 0 2, center, width 156!, height 186!, gapright 20");
        coinflip.add(game3, "cell 0 2, center, width 156!, height 186!, gapright 20");
        coinflip.add(debug, "cell 0 3, center");
        loading.dispose();
        coinflip.pack();
        // coinflip.setMinimumSize(new Dimension(698, 458));
        coinflip.setVisible(true);
    }

    public JFrame getFrame() {
        return coinflip;
    }

    public void enableGS() {
        coinflip.setEnabled(true);
    }
}
