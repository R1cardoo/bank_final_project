import javax.swing.*;
import java.awt.*;

public class AccountInfoPanel extends JPanel{
    public static JButton backBtn = new JButton("back");
    public static JLabel label = new JLabel("null", JLabel.CENTER);

    public AccountInfoPanel(JFrame frame, Box basePane, String accountInfo) {
        frame.setTitle("Account Info");
        frame.setSize(600, 800);
        initPanel(frame, basePane, accountInfo);
    }

    private void initPanel(JFrame frame, Box basePane, String accountInfo) {
        JPanel panel0 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel0.add(backBtn);
        backBtn.addActionListener(new BackButtonListener(frame, basePane));

        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        label.setText("<html><body>" +accountInfo + "<body></html>");
        label.setBounds(100,100,300,600);
        panel1.add(label);

        Box vBox = Box.createVerticalBox();
        vBox.add(panel0);
        vBox.add(panel1);

        add(vBox);
    }

}
