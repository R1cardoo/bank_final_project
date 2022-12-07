package WorkPortals.Customer.Windows;

import WorkPortals.Customer.CustomerHome;
import WorkPortals.BackButtonListener;

import javax.swing.*;
import java.awt.*;

public class ViewTransactionPanel extends JPanel{

    public static JButton backBtn = new JButton("back");
    public static JLabel label = new JLabel("null");

    public ViewTransactionPanel(String transactionString) {
        CustomerHome.frame.setTitle("View Transactions");
        CustomerHome.frame.setSize(600, 800);

        initPanel(transactionString);
    }

    private void initPanel(String transactionString) {
        JPanel panel0 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel0.add(backBtn);
        backBtn.addActionListener(new BackButtonListener(CustomerHome.frame, CustomerHome.basePane));

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        label.setText(transactionString);
        panel.add(label);

        Box vBox = Box.createVerticalBox();
        vBox.add(panel0);
        vBox.add(panel);

        add(vBox);
    }
}
