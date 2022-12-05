package WorkPortals.Customer.Windows;

import javax.swing.*;
import java.awt.*;

public class makeTransactionFrame {
    public static final String CHECKING = "checkingAccount";
    public static final String SAVING = "savingAccount";
    public static final String SECURITY = "securityAccount";

    public static JFrame frame = new JFrame();
    public static JLabel label1 = new JLabel("Account");
    public static JComboBox<String> comboBox1 = new JComboBox<>(); // account

    public static JLabel label2 = new JLabel("Transaction Type");      // action
    public static JComboBox<String> comboBox2 = new JComboBox<>();

    public static JLabel label3 = new JLabel("Amount");      // action
    public static JTextField amount = new JTextField(10);

    public static JButton submitBtn = new JButton("Submit");

    public makeTransactionFrame() { // TODO input user
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initFrame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void initFrame() { // TODO input user
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(label1);
        comboBox1.addActionListener(new makeTransactionListener());
        panel1.add(comboBox1);


        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(label2);
        panel2.add(comboBox1);

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel3.add(label3);
        panel3.add(amount);

        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        submitBtn.addActionListener(new makeTransactionListener());
        panel4.add(submitBtn);


        Box vBox = Box.createVerticalBox();
        vBox.add(panel1);
        vBox.add(panel2);
        vBox.add(panel3);
        vBox.add(panel4);

        frame.setContentPane(vBox);
    }

    public static void dismiss() {
        frame.setVisible(false);
        frame.dispose();
    }


}
