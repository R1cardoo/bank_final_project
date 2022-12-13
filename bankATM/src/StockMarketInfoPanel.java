import javax.swing.*;
import java.awt.*;

public class StockMarketInfoPanel extends JPanel{
    public static JButton backBtn = new JButton("back");
    public static JLabel label = new JLabel("null");

    public StockMarketInfoPanel(JFrame frame, Box basePane,  String stockMarketInfo) {
        frame.setTitle("Stock Market");
        frame.setSize(600, 800);
        initPanel(frame, basePane ,stockMarketInfo);
    }

    private void initPanel(JFrame frame, Box basePane, String stockMarketInfo) {
        JPanel panel0 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel0.add(backBtn);
        backBtn.addActionListener(new BackButtonListener(frame, basePane));

        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        label.setText("<html><body>" + stockMarketInfo + "<body></html>");
        panel1.add(label);

        Box vBox = Box.createVerticalBox();
        vBox.add(panel0);
        vBox.add(panel1);

        add(vBox);
    }
}
