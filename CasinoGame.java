/* CasinoGame (Group 1)
 * Members: Soria
 *          Ouano
 *          Ceriola
 *          Soliven
 *          Nazareno
 *          Patosa
 * Subject: Computer Programming 3
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;

public class CasinoGame {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello World!");
        Login login = new Login();

        JLabel text = new JLabel("Terms and Conditions");
        text.setFont(new Font(null, Font.PLAIN, 20));


        FileReader reader = new FileReader("src/terms.txt");
        BufferedReader br = new BufferedReader(reader);

        // Import terms.txt to String
        String line;
        StringBuilder sb = new StringBuilder();

        try {
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String ToContent = sb.toString();
        JTextArea TaC = new JTextArea(ToContent);
        

        JFrame frame1 = new JFrame("Casino Game");
        JScrollPane scroll = new JScrollPane(TaC);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        JPanel panel = new JPanel();
        ImageIcon icon = new ImageIcon("icon.png");
        frame1.setIconImage(icon.getImage());
        

        // Terms and Conditions Screen
        JButton accept = new JButton("Accept");
        JButton deny = new JButton("Deny");
        

        scroll.setBounds(60, 48, 379, 168);
        TaC.setLineWrap(true);
        TaC.setWrapStyleWord(true);

        
        accept.setBounds(24,247,95,30);
        deny.setBounds(380,247,95,30);
        frame1.setSize(500,300);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(null);
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        text.setBounds(146, 14, 207, 24);
        frame1.add(scroll);
        frame1.add(accept);
        frame1.add(panel);
        frame1.add(deny);
        frame1.add(text);

        deny.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                    System.exit(0);
            }  
        });
        
        accept.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login.LoginScreen();
                frame1.dispose();
            }
        });
    }
}