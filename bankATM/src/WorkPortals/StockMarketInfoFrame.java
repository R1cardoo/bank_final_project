package WorkPortals;

import javax.swing.*;
import java.awt.*;

public class StockMarketInfoFrame {
    public static JFrame frame = new JFrame("Account Info");

    public static JLabel label = new JLabel("null");

    public StockMarketInfoFrame(String stockMarketInfo) {
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initFrame(stockMarketInfo);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void initFrame(String stockMarketInfo) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        label.setText(stockMarketInfo);
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
