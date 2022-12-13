import javax.swing.*;
import java.awt.*;

public class AdjustExchangeRatePanel extends JPanel{
    public static final String COMMAND_SELECT_COMBOBOX = "SelectComboBox";
    public static final String COMMAND_SUBMIT = "Submit";

    public static JButton backBtn = new JButton("back");

    public String[] currencies = {"CNY", "INR", "GBP"};

    public static JLabel label1 = new JLabel("currency: ");

    public static JComboBox<String> comboBox = new JComboBox<>(); // select a currency

    public static JLabel label2 = new JLabel("Worth (USD)");
    public static JTextField worth = new JTextField(10);

    public static JButton submit = new JButton("Submit");

    public AdjustExchangeRatePanel() {
        ManagerHome.frame.setTitle("Adjust Exchange Rate");
        ManagerHome.frame.setSize(400, 300);
        initPanel();
    }

    private void initPanel() {
        JPanel panel0 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel0.add(backBtn);
        backBtn.addActionListener(new BackButtonListener(ManagerHome.frame, ManagerHome.basePane));

        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(label1);
        comboBox.removeAllItems();
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
        submit.setEnabled(false);
        submit.setActionCommand(COMMAND_SUBMIT);
        submit.addActionListener(new AdjustExchangeRateButtonListener());

        Box vBox = Box.createVerticalBox();
        vBox.add(panel0);
        vBox.add(panel1);
        vBox.add(panel2);
        vBox.add(panel3);

        add(vBox);
    }
}
