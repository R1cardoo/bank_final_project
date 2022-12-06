package WorkPortals;

import javax.swing.*;
import java.awt.*;

public class AccountInfoFrame {
    public static JFrame frame = new JFrame("Account Info");

    public static JLabel label = new JLabel("null");

    public AccountInfoFrame(String accountInfo) {
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initFrame(accountInfo);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void initFrame(String accountInfo) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        label.setText(accountInfo);
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
