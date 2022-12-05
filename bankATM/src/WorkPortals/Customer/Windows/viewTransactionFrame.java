package WorkPortals.Customer.Windows;

import WorkPortals.Customer.CustomerButtonListener;

import javax.swing.*;
import java.awt.*;

public class viewTransactionFrame {
    public static JFrame frame = new JFrame("Create Account Portal");

    public static JLabel label = new JLabel("null");

    public viewTransactionFrame(String transactionString) {
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initFrame(transactionString);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void initFrame(String transactionString) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        label.setText(transactionString);
        panel.add(label);

        Box vBox = Box.createVerticalBox();
        vBox.add(panel);

        frame.setContentPane(vBox);
    }

    public static void dismiss() {
        frame.setVisible(false);
        frame.dispose();
    }

}
