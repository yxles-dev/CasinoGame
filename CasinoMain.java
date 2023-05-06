
import javax.swing.JFrame;

import java.awt.*;
import java.io.FileNotFoundException;

public class CasinoMain extends JFrame {
    public void BackgroundImageJFrame() throws InterruptedException, FileNotFoundException   
    {
        this.setUndecorated(true);
        setTitle("DigiBet ICT201");
        setSize(899,421);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        Thread.sleep(3000);
        this.dispose();
    }

    public void paint(Graphics g)
    {
        Image img = Toolkit.getDefaultToolkit().getImage("src/icons/Intro.png");

        g.drawImage(img, 0, 0, this);
    }
    public static void main (String[] args) throws FileNotFoundException, InterruptedException{
        Login login = new Login();
        CasinoMain bim = new CasinoMain();
        bim.BackgroundImageJFrame();
        login.LoginScreen();
    }
}
