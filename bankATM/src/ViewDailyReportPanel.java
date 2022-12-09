import javax.swing.*;
import java.awt.*;

public class ViewDailyReportPanel extends JPanel{
    public static JButton backBtn = new JButton("back");
    public static JLabel label = new JLabel("null");

    public ViewDailyReportPanel(String dailyReport) {
        ManagerHome.frame.setTitle("View Daily Report");
        ManagerHome.frame.setSize(600, 800);
        initPanel(dailyReport);
    }

    private void initPanel(String dailyReport) {
        JPanel panel0 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel0.add(backBtn);
        backBtn.addActionListener(new BackButtonListener(ManagerHome.frame, ManagerHome.basePane));

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        label.setText(dailyReport);
        panel.add(label);

        Box vBox = Box.createVerticalBox();
        vBox.add(panel0);
        vBox.add(panel);

        add(vBox);
    }
}
