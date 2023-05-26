import java.awt.*;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

public class ImproveLogin extends JFrame {
    public void loginFrame() throws InterruptedException, FileNotFoundException {
        // init Frame
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(688, 400);
        window.setLayout(new MigLayout("fill"));
        
        JButton login = new JButton("Login");

        // !! change to JLabel!!
        JLabel painting = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon img4 = new ImageIcon("src/icons/lgbg.png");
                Image img = img4.getImage();

                g.drawImage(img, 0, 0, this);
                repaint();
            }
        };
        window.add(painting, "center");
        window.add(login, "cell 0 0");
        window.setVisible(true);
    }

    public void loginPage() throws FileNotFoundException, InterruptedException{
        ImproveLogin bim = new ImproveLogin();
        bim.loginFrame();
    }
}
