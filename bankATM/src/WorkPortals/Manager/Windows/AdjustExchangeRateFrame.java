package WorkPortals.Manager.Windows;

import javax.swing.*;
import java.awt.*;

public class AdjustExchangeRateFrame {
    public static final String COMMAND_SELECT_COMBOBOX = "SelectComboBox";
    public static final String COMMAND_SUBMIT = "Submit";

    public static JFrame frame = new JFrame("Adjust Exchange Rate");

    public String[] currencies = {"Pound", "RMB", "Rupee"};

    public static JLabel label1 = new JLabel("currency: ");

    public static JComboBox<String> comboBox = new JComboBox<>(); // select a currency

    public static JLabel label2 = new JLabel("Worth (USD)");
    public static JTextField worth = new JTextField(10);

    public static JButton submit = new JButton("Submit");

    public AdjustExchangeRateFrame() {
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initFrame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void initFrame() {
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(label1);
        for (String cur : currencies) {
            comboBox.addItem(cur);
        }
        comboBox.setActionCommand(COMMAND_SELECT_COMBOBOX);
        comboBox.addActionListener(new AdjustExchangeRateButtonListener());
        panel1.add(comboBox);

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(label2);
        panel2.add(worth);

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel3.add(submit);
        submit.setActionCommand(COMMAND_SUBMIT);
        submit.addActionListener(new AdjustExchangeRateButtonListener());

        Box vBox = Box.createVerticalBox();
        vBox.add(panel1);
        vBox.add(panel2);
        vBox.add(panel3);

        frame.setContentPane(vBox);
    }

    public static void dismiss() {
        frame.setVisible(false);
        frame.dispose();
    }
}
