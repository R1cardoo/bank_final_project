package WorkPortals.Manager.Windows;

import javax.swing.*;
import java.awt.*;

public class DeleteStockFrame {
    public static final String COMMAND_SELECT_COMBOBOX = "SelectComboBox";
    public static final String COMMAND_SUBMIT = "Submit";

    public static JFrame frame = new JFrame("Delete Stock");

    public static JLabel label1 = new JLabel("Stock: ");

    public static JComboBox<String> comboBox = new JComboBox<>(); // select a Stock

    public static JButton submit = new JButton("Submit");

    public DeleteStockFrame() {
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initFrame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void initFrame() {
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

        frame.setContentPane(vBox);
    }

    public static void dismiss() {
        frame.setVisible(false);
        frame.dispose();
    }
}
