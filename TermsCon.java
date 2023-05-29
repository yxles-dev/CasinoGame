/* CasinoGame (Group 1)
 * Members: Soria
 *          Ouano
 *          Ceriola
 *          Soliven
 *          Nazareno
 *          Patosa
 * Subject: Computer Programming 3
 */

import java.io.FileNotFoundException;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import net.miginfocom.swing.MigLayout;
import tools.TextReader;

public class TermsCon {

    public void Terms() throws FileNotFoundException {
        Register reg = new Register();
        Login login = new Login();
        TextReader readText = new TextReader();

        // TaC Components
        JLabel text = new JLabel("Terms and Conditions");
        text.setFont(new Font(null, Font.PLAIN, 20));
        // text.setBounds(146, 14, 207, 24);

        JCheckBox checkBox = new JCheckBox("I agree to the terms and policy of the game");
        // checkBox.setBounds(135, 256, 229, 12);

        // Show terms.txt to TaC
        JTextArea TaC = new JTextArea(readText.getText("src/terms.txt"));
        

        // Frame initialization
        JFrame frame1 = new JFrame("Casino Game");
        JScrollPane scroll = new JScrollPane(TaC);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        ImageIcon icon = new ImageIcon("src/icon.png");
        frame1.setIconImage(icon.getImage());
        

        // Terms and Conditions Screen
        JButton accept = new JButton(new ImageIcon("src/icons/Accept.png"));
        JButton deny = new JButton(new ImageIcon("src/icons/Deny.png"));

        accept.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accept.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accept.setCursor(Cursor.getDefaultCursor());
            }
        });
        deny.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deny.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deny.setCursor(Cursor.getDefaultCursor());
            }
        });
        

        // scroll.setBounds(60, 48, 379, 168);
        TaC.setEditable(false);
        TaC.setLineWrap(true);
        TaC.setWrapStyleWord(true);

        
        // accept.setBounds(24,247,84,36);
        accept.setBorderPainted(false);
        // deny.setBounds(380,247,84,36);
        deny.setBorderPainted(false);

        frame1.setSize(520,357);
        frame1.setMinimumSize(new Dimension(520, 357));
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setResizable(true);
        frame1.setLayout(new MigLayout("fill"));
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        frame1.add(text, "span 2, center, wrap");
        frame1.add(scroll, "cell 0 1, center, grow, gapleft 20, gapright 20, wrap");
        frame1.add(checkBox, "cell 0 2, center");
        frame1.add(accept, "cell 0 3, center, gapright 60, width 84!, height 36!");
        frame1.add(deny, "cell 0 3, center, width 84!, height 36!");

        deny.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                    try {
                        login.loginScreen();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    frame1.dispose();
            }  
        });
        
        accept.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(checkBox.isSelected());
                if (checkBox.isSelected() == true) {
                    reg.registerScreen();
                    frame1.dispose();
                }
            }
        });
    }
}