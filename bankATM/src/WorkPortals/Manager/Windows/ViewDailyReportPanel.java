package WorkPortals.Manager.Windows;

import WorkPortals.Manager.ManagerHome;

import javax.swing.*;
import java.awt.*;

public class ViewDailyReportPanel extends JPanel{
    public static JLabel label = new JLabel("null");

    public ViewDailyReportPanel(String dailyReport) {
        ManagerHome.frame.setTitle("View Daily Report");
        ManagerHome.frame.setSize(600, 800);
        initPanel(dailyReport);
    }

    private void initPanel(String dailyReport) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        label.setText(dailyReport);
        panel.add(label);

        Box vBox = Box.createVerticalBox();
        vBox.add(panel);

        add(vBox);
    }
}
