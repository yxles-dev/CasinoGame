import java.awt.*;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class ImproveLogin extends JFrame {
    public void loginFrame() throws InterruptedException, FileNotFoundException {
        // init Frame
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(688, 370);
        window.setLocationRelativeTo(null);
        JLayeredPane pane = new JLayeredPane();
        JPanel panel1 = new JPanel();

        // Set MigLayout with zero margins
        // MigLayout layout = new MigLayout("fill, insets 0");
        // window.setLayout(layout);

        JPanel paintingPanel = new JPanel(new BorderLayout());

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

        JButton login = new JButton("Login");
        paintingPanel.add(painting, BorderLayout.CENTER);
        panel1.add(paintingPanel, "grow");
        pane.add(panel1, JLayeredPane.DEFAULT_LAYER);
        pane.add(login, JLayeredPane.POPUP_LAYER);
        window.add(pane);
        window.setVisible(true);
    }

    public void loginPage() throws FileNotFoundException, InterruptedException {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    loginFrame();
                } catch (FileNotFoundException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
