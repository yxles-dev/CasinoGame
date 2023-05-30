package com.dabest;
import javax.swing.*;

import com.dabest.games.SlotMachine;
import com.dabest.tools.TextReader;
import com.dabest.tools.WindowClosedCallback;
import com.dabest.tools.WindowLocation;

import net.miginfocom.swing.MigLayout;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

public class SMTutorial {
    TextReader readText = new TextReader();
    GameSelector gs = new GameSelector();
    SlotMachine smg = new SlotMachine();
    private WindowClosedCallback callback;

    public SMTutorial(WindowClosedCallback callback) {
        this.callback = callback;
    }

    public void sm() throws FileNotFoundException {

        JFrame game = new JFrame();
        game.setLayout(new MigLayout("fill"));

        game.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                callback.onWindowClosed();  // Invoke the callback when the JFrame is closed
            }
        });

        JLabel text = new JLabel("Tutorial");
        text.setFont(new Font(null, Font.PLAIN, 25));

        // ImageIcon img1 = new ImageIcon("src/icons/.png");
        // Image img11 = img1.getImage();
        // Image back = img11.getScaledInstance(156, 186, java.awt.Image.SCALE_SMOOTH);

        JButton backb = new JButton("Go Back");

        backb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.dispose();
                callback.onWindowClosed();
            }
        });

        // ImageIcon img2 = new ImageIcon("src/icons/.png");
        // Image img22 = img2.getImage();
        // Image enter = img22.getScaledInstance(156, 186, java.awt.Image.SCALE_SMOOTH);

        JButton play = new JButton("Play");

        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Dispose GameSelector
                WindowLocation wl = new WindowLocation();
                wl.setLocation(game.getLocation());
                GameSelector gsl = new GameSelector();
                JFrame coinflip = gsl.getFrame();
                coinflip.dispose();
                game.dispose();
                smg.smGame();
            }
        });

        String ToContent = readText.getText("src/tutorial/sm.txt");
        JTextArea Tutorial = new JTextArea(ToContent);


        JScrollPane scroll = new JScrollPane(Tutorial);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        Tutorial.setEditable(false);
        Tutorial.setLineWrap(true);
        Tutorial.setWrapStyleWord(true);

        game.setTitle("Slot Machine");
        game.setMinimumSize(new Dimension(592, 366));
        game.setVisible(true);
        game.setLocationRelativeTo(null);
        game.add(text, "span 2, center, wrap");
        game.add(scroll, "cell 0 1, center, grow, gapleft 20, gapright 20, wrap");
        game.add(backb, "cell 0 2, center, width 112!, height 32!, gapright 40");
        game.add(play, "cell 0 2, center, width 112!, height 32!");
    }
}