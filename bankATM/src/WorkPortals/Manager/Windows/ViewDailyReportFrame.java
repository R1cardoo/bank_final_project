package WorkPortals.Manager.Windows;

import javax.swing.*;
import java.awt.*;

public class ViewDailyReportFrame {
    public static JFrame frame = new JFrame("View Daily Report");

    public static JLabel label = new JLabel("null");

    public ViewDailyReportFrame(String dailyReport) {
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initFrame(dailyReport);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void initFrame(String dailyReport) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        label.setText(dailyReport);
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
