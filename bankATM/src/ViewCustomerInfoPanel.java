import javax.swing.*;
import java.awt.*;

public class ViewCustomerInfoPanel extends JPanel {
    public static final String COMMAND_COMBO_BOX = "ComboBox";
    public static final String COMMAND_SEARCH = "Search";

    public static JButton backBtn = new JButton("back");

    public static JComboBox<String> comboBox = new JComboBox<>(); // username

    public static JButton searchBtn = new JButton("search");
    public static JLabel label = new JLabel("null");

    public ViewCustomerInfoPanel(JFrame frame, Box basePane, String accountInfo) {
        frame.setTitle("View Customer Info");
        frame.setSize(600, 800);
        initPanel(frame, basePane, accountInfo);
    }

    private void initPanel(JFrame frame, Box basePane, String accountInfo) {
        JPanel panel0 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel0.add(backBtn);
        backBtn.addActionListener(new BackButtonListener(frame, basePane));

        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        comboBox.removeAllItems();
        // TODO comboBox add all user
        comboBox.addItem("123");
        panel1.add(comboBox);
        comboBox.setActionCommand(COMMAND_COMBO_BOX);
        comboBox.addActionListener(new ViewCustomerInfoButtonListener());
        searchBtn.setEnabled(false);
        searchBtn.setActionCommand(COMMAND_SEARCH);
        searchBtn.addActionListener(new ViewCustomerInfoButtonListener());
        panel1.add(searchBtn);

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        label.setText(accountInfo);
        panel2.add(label);

        Box vBox = Box.createVerticalBox();
        vBox.add(panel0);
        vBox.add(panel1);
        vBox.add(panel2);

        add(vBox);
    }
}
