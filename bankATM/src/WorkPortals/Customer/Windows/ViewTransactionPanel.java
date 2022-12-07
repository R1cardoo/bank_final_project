package WorkPortals.Customer.Windows;

import WorkPortals.Customer.CustomerHome;

import javax.swing.*;
import java.awt.*;

public class ViewTransactionPanel extends JPanel{
    public static JLabel label = new JLabel("null");

    public ViewTransactionPanel(String transactionString) {
        CustomerHome.frame.setTitle("View Transactions");
        CustomerHome.frame.setSize(600, 800);

        initPanel(transactionString);
    }

    private void initPanel(String transactionString) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        label.setText(transactionString);
        panel.add(label);

        Box vBox = Box.createVerticalBox();
        vBox.add(panel);

        add(vBox);
    }
}
