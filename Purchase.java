import javax.swing.JFrame;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

public class Purchase extends JFrame{
    public void purchaseScreen() {
        JLabel text = new JLabel("Purchase Cash");
        setLayout(new MigLayout("fill"));
        setLocationRelativeTo(null);
        add(text, "cell 0 0");
        pack();
        setVisible(true);
    }
}