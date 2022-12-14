import javax.swing.*;
import java.awt.*;

public class BuyStockPanel extends JPanel {
    public static final String COMMAND_SELECT_COMBOBOX = "SelectComboBox";
    public static final String COMMAND_SUBMIT = "Submit";

    public static JButton backBtn = new JButton("back");
    public static JLabel label1 = new JLabel("Stock: ");

    public static JComboBox<String> comboBox = new JComboBox<>(); // select a Stock

    public static JLabel label2 = new JLabel("Amount: ");

    public static JTextField amount = new JTextField(10);

    public static JButton submit = new JButton("Submit");

    public BuyStockPanel() {
        CustomerHome.frame.setTitle("Buy Stock");
        CustomerHome.frame.setSize(350, 200);
        initPanel();
    }

    private void initPanel() {
        JPanel panel0 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel0.add(backBtn);
        backBtn.addActionListener(new BackButtonListener(CustomerHome.frame, CustomerHome.basePane));

        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(label1);
        // TODO add elements
        panel1.add(comboBox);
        comboBox.removeAllItems();
        for (Stock stock: StockMarket.getInstance().getAvailableStocks()) {
            comboBox.addItem(stock.getStockName());
        }
        comboBox.setActionCommand(COMMAND_SELECT_COMBOBOX);
        comboBox.addActionListener(new BuyStockButtonListener());

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(label2);
        panel2.add(amount);

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel3.add(submit);
        submit.setActionCommand(COMMAND_SUBMIT);
        submit.addActionListener(new BuyStockButtonListener());

        Box vBox = Box.createVerticalBox();
        vBox.add(panel0);
        vBox.add(panel1);
        vBox.add(panel2);
        vBox.add(panel3);

        add(vBox);
    }
}
