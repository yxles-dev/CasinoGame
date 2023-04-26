/* CasinoGame (Group 1)
 * Members: Soria
 *          Ouano
 *          Ceriola
 *          Soliven
 *          Nazareno
 *          Patosa
 * Subject: Computer Programming 3
 */

import javax.swing.*;

public class CasinoGame {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        JFrame frame1 = new JFrame("Casino Game");
        JPanel panel = new JPanel();
        JButton accept = new JButton("Accept");
        JButton deny = new JButton("Deny");

        // Set-up Window
        accept.setBounds(50,100,95,30);
        deny.setBounds(60,10,95,30);
        frame1.setSize(500,300);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
        frame1.add(accept);
        frame1.add(deny);
    }
}