import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Purchase {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Label Updater");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel();
        frame.add(label);

        int value = 0;
        Runnable labelUpdater = () -> label.setText("Value: " + value);

        Thread valueUpdater = new Thread(() -> extracted(value, labelUpdater));
        valueUpdater.start();

        frame.pack();
        frame.setVisible(true);
    }

    private static void extracted(int value, Runnable labelUpdater) {
        while (true) {
            value++;
            SwingUtilities.invokeLater(labelUpdater);
            try {
                Thread.sleep(1000); // wait for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
