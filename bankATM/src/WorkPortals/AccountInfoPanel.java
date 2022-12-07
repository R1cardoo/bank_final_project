package WorkPortals;

import WorkPortals.Customer.CustomerHome;

import javax.swing.*;
import java.awt.*;

public class AccountInfoPanel extends JPanel{
    public static JLabel label = new JLabel("null");

    public AccountInfoPanel(JFrame frame, String accountInfo) {
        frame.setTitle("Account Info");
        frame.setSize(600, 800);
        initPanel(accountInfo);
    }

    private void initPanel(String accountInfo) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        label.setText(accountInfo);
        panel.add(label);

        Box vBox = Box.createVerticalBox();
        vBox.add(panel);

        add(vBox);
    }

}
