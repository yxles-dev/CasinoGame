import java.awt.*;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImproveLogin extends JFrame {
    public void loginFrame() throws InterruptedException, FileNotFoundException {
        // init Frame
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(688, 370);

    // !! change to JLabel!!
    JLabel painting = new JLabel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Image img = Toolkit.getDefaultToolkit().getImage("src/icons/Intro.png");
            // Image img = Toolkit.getDefaultToolkit().getImage("src/loginbackground.png");

            g.drawImage(img, 0, 0, this);
            repaint();
        }
    };
    window.add(painting);
    window.setVisible(true);
    }

    public void loginPage() throws FileNotFoundException, InterruptedException{
        ImproveLogin bim = new ImproveLogin();
        bim.loginFrame();
    }
}
