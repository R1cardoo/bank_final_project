package WorkPortals.Manager.Windows;

import WorkPortals.Manager.ManagerHome;

import javax.swing.*;
import java.awt.*;

public class DeleteStockPanel extends JPanel{
    public static final String COMMAND_SELECT_COMBOBOX = "SelectComboBox";
    public static final String COMMAND_SUBMIT = "Submit";

    public static JLabel label1 = new JLabel("Stock: ");

    public static JComboBox<String> comboBox = new JComboBox<>(); // select a Stock

    public static JButton submit = new JButton("Submit");

    public DeleteStockPanel() {
        ManagerHome.frame.setTitle("Delete Stock");
        ManagerHome.frame.setSize(350, 200);
        initPanel();
    }

    private void initPanel() {
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(label1);
        // TODO add elements
        panel1.add(comboBox);
        comboBox.setActionCommand(COMMAND_SELECT_COMBOBOX);
        comboBox.addActionListener(new DeleteStockButtonListener());

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(submit);
        submit.setEnabled(false);
        submit.addActionListener(new DeleteStockButtonListener());

        Box vBox = Box.createVerticalBox();
        vBox.add(panel1);
        vBox.add(panel2);

        add(vBox);
    }
}
