
import javax.swing.JFrame;

import java.awt.*;
import java.io.FileNotFoundException;

public class CasinoMain extends JFrame {
    public void BackgroundImageJFrame() throws InterruptedException, FileNotFoundException   
    {
        this.setUndecorated(true);
        setTitle("DigiBet ICT201");
        setSize(899,421);
        setLocation(0, 0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        AccountInformation accInf = new AccountInformation();
        // accInf.setwindowLocation(getLocation());
        // System.out.println(accInf.getwindowLocation());

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
        Login login = new Login();
        // ImproveLogin ipl = new ImproveLogin();
        CasinoMain bim = new CasinoMain();
        bim.BackgroundImageJFrame();
        // ipl.loginPage();
        login.loginScreen();
    }
}
