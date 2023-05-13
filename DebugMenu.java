import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class DebugMenu {
    AccountInformation accInf = new AccountInformation();
    public void debugMenu() {
        JFrame menu = new JFrame();
        menu.setLayout(new MigLayout("fill"));
        menu.setLocationRelativeTo(null);

        JLabel dbgText = new JLabel("Debug Menu");
        JLabel fName = new JLabel("First Name: ");
        JLabel fNameVal = new JLabel(accInf.getFName());
        JLabel lName = new JLabel("Last Name: ");
        JLabel lNameVal = new JLabel(accInf.getLName());
        JLabel uName = new JLabel("Username: ");
        JLabel uNameVal = new JLabel(accInf.getUName());
        JLabel cash = new JLabel("Cash: ");
        toString();
        JLabel cashVal = new JLabel(String.valueOf(accInf.getCash()));

        Runnable labelUpdater = () -> cashVal.setText(String.valueOf(accInf.getCash()));

        JButton decreaseCash = new JButton("Decrease Cash");
        decreaseCash.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int decrease = Integer.parseInt(JOptionPane.showInputDialog(null, "By how much?"));
                System.out.println("Decrease money by "+decrease);
                AccountInformation.Cash = AccountInformation.Cash - decrease;
                SwingUtilities.invokeLater(labelUpdater);
            }
        });

        JButton increaseCash = new JButton("Increase Cash");
        increaseCash.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent i) {
                int increase = Integer.parseInt(JOptionPane.showInputDialog(null, "By how much?"));
                System.out.println("Increase money by "+increase);
                AccountInformation.Cash = AccountInformation.Cash + increase;
                SwingUtilities.invokeLater(labelUpdater);
            }
        });

        JButton updateCash = new JButton("Update Cash on SQL");
        updateCash.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent u) {
                accInf.updateCash();
                JOptionPane.showMessageDialog(null, "Successful");
            }
        });

        menu.add(dbgText, "span 2, center, wrap");
        menu.add(fName, "cell 0 1");
        menu.add(fNameVal, "cell 1 1");
        menu.add(lName, "cell 0 2");
        menu.add(lNameVal, "cell 1 2");
        menu.add(uName, "cell 0 3");
        menu.add(uNameVal, "cell 1 3");
        menu.add(cash, "cell 0 4");
        menu.add(cashVal, "cell 1 4");
        menu.add(decreaseCash, "cell 0 5, center");
        menu.add(increaseCash, "cell 1 5, center");
        menu.add(updateCash, "cell 0 6");
        menu.pack();
        menu.setVisible(true);
    }
}
