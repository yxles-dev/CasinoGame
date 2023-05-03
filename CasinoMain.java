import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CasinoMain {
    public static void main (String[] args) throws InterruptedException, FileNotFoundException{
        JFrame splash = new JFrame();
        TermsCon termsCon = new TermsCon();

        JLabel splashName = new JLabel("ICT201 ComProg3");
        splashName.setBounds(50,50,100,100);

        splash.setSize(500, 300);
        splash.setResizable(false);
        splash.setVisible(true);
        splash.setLayout(null);
        splash.setLocationRelativeTo(null);
        splash.add(splashName);

        Thread.sleep(3000);
        splash.dispose();
        termsCon.Terms();

    }
}
