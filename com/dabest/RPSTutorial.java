package com.dabest;
import javax.swing.*;

import com.dabest.games.RPS;
import com.dabest.tools.TextReader;
import com.dabest.tools.WindowClosedCallback;

import net.miginfocom.swing.MigLayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;

public class RPSTutorial {
    TextReader readText = new TextReader();
    GameSelector gs = new GameSelector();
    private WindowClosedCallback callback;

    public RPSTutorial(WindowClosedCallback callback) {
        this.callback = callback;
    }
    
    public void rps() throws FileNotFoundException {
        RPS rps = new RPS();

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
                gs.enableGS();
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
                game.dispose();
                rps.rpsGame();
            }
        });

        String ToContent = readText.getText("src/tutorial/rps.txt");
        JTextArea Tutorial = new JTextArea(ToContent);


        JScrollPane scroll = new JScrollPane(Tutorial);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        Tutorial.setEditable(false);
        Tutorial.setLineWrap(true);
        Tutorial.setWrapStyleWord(true);

        game.setTitle("Rock Paper Scissor");
        game.setMinimumSize(new Dimension(592, 366));
        game.setVisible(true);
        game.setLocationRelativeTo(null);
        game.add(text, "span 2, center, wrap");
        game.add(scroll, "cell 0 1, center, grow, gapleft 20, gapright 20, wrap");
        game.add(backb, "cell 0 2, center, width 112!, height 32!, gapright 40");
        game.add(play, "cell 0 2, center, width 112!, height 32!");
    }
}