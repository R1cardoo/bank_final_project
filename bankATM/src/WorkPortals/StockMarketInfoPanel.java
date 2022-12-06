package WorkPortals;

import javax.swing.*;
import java.awt.*;

public class StockMarketInfoPanel extends JPanel{

    public static JLabel label = new JLabel("null");

    public StockMarketInfoPanel(JFrame frame, String stockMarketInfo) {
        frame.setTitle("Stock Market");
        frame.setSize(600, 800);
        initPanel(stockMarketInfo);
    }

    private void initPanel(String stockMarketInfo) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        label.setText(stockMarketInfo);
        panel.add(label);

        Box vBox = Box.createVerticalBox();
        vBox.add(panel);

        add(vBox);
    }
}
