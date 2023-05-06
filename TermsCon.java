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

public class TermsCon {
    public void Terms() throws FileNotFoundException {
        Login login = new Login();
        TextReader readText = new TextReader();

        // TaC Components
        JLabel text = new JLabel("Terms and Conditions");
        text.setFont(new Font(null, Font.PLAIN, 20));
        text.setBounds(146, 14, 207, 24);

        JCheckBox checkBox = new JCheckBox("I agree to the terms and policy of the game");
        checkBox.setBounds(135, 256, 229, 12);

        // Show terms.txt to TaC
        readText.setText("src/terms.txt");
        JTextArea TaC = new JTextArea(readText.getText());
        

        // Frame initialization
        JFrame frame1 = new JFrame("Casino Game");
        JScrollPane scroll = new JScrollPane(TaC);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        JPanel panel = new JPanel();
        ImageIcon icon = new ImageIcon("src/icon.png");
        frame1.setIconImage(icon.getImage());
        

        // Terms and Conditions Screen
        JButton accept = new JButton(new ImageIcon("src/icons/Accept.png"));
        JButton deny = new JButton(new ImageIcon("src/icons/Deny.png"));
        

        scroll.setBounds(60, 48, 379, 168);
        TaC.setEditable(false);
        TaC.setLineWrap(true);
        TaC.setWrapStyleWord(true);

        
        accept.setBounds(24,247,84,36);
        accept.setBorderPainted(false);
        deny.setBounds(380,247,84,36);
        deny.setBorderPainted(false);

        frame1.setSize(520,357);
        frame1.setMinimumSize(new Dimension(520, 357));
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setResizable(true);
        frame1.setLayout(null);
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        frame1.add(scroll);
        frame1.add(accept);
        frame1.add(panel);
        frame1.add(deny);
        frame1.add(text);
        frame1.add(checkBox);

        deny.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                    System.exit(0);
            }  
        });
        
        accept.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(checkBox.isSelected());
                if (checkBox.isSelected() == true) {
                    try {
                        login.LoginScreen();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    frame1.dispose();
                }
            }
        });
    }
}