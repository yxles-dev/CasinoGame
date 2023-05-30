package com.dabest;

import javax.swing.JFrame;

import com.dabest.tools.WindowLocation;

import java.awt.*;
import java.io.FileNotFoundException;

public class CasinoMain extends JFrame {
    public void BackgroundImageJFrame() throws InterruptedException, FileNotFoundException   
    {
        this.setUndecorated(true);
        setTitle("DigiBet ICT201");
        setSize(899,421);
        setLocationRelativeTo(null);
        setVisible(true);

        WindowLocation wl = new WindowLocation();
        wl.setLocation(getLocation());

        Thread.sleep(3000);
        this.dispose();
    }

    public void paint(Graphics g)
    {
        Image img = Toolkit.getDefaultToolkit().getImage("src/icons/Intro.png");
        // Image img = Toolkit.getDefaultToolkit().getImage("src/loginbackground.png");

        g.drawImage(img, 0, 0, this);
    }
    public static void main (String[] args) throws FileNotFoundException, InterruptedException{
        Login login = new Login(); // Old Login Page
        // ImproveLogin ipl = new ImproveLogin(); // New Login Page
        CasinoMain bim = new CasinoMain();
        bim.BackgroundImageJFrame();
        // ipl.loginPage(); // New Login Page
        login.loginScreen(); // Old Login Page
    }
}
