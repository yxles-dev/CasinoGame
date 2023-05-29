package testcodes;

import javax.swing.*;

public class point extends JFrame{
    public void test() {
        
        JLabel location = new JLabel();
        location.setText(getLocation().toString());

        setSize(300, 200);
        setLocationRelativeTo(null);
        add(location);
        setVisible(true);

        
        Timer timer = new Timer(1, e -> {
            Runnable labelUpdater = () -> location.setText(getLocation().toString());
            SwingUtilities.invokeLater(labelUpdater);
        });
        timer.start();
    }
    public static void main(String[] args) {
        point pnt = new point();
        pnt.test();
    }
}
