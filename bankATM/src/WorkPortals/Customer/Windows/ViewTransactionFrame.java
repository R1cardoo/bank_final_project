package WorkPortals.Customer.Windows;

import javax.swing.*;
import java.awt.*;

public class ViewTransactionFrame {
    public static JFrame frame = new JFrame("View Transaction");

    public static JLabel label = new JLabel("null");

    public ViewTransactionFrame(String transactionString) {
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
