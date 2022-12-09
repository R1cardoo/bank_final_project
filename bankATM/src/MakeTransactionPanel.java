import javax.swing.*;
import java.awt.*;

public class MakeTransactionPanel extends JPanel{
    public static final String CHECKING = "checkingAccount";
    public static final String SAVING = "savingAccount";
    public static final String SECURITY = "securityAccount";

    public static JButton backBtn = new JButton("back");
    public static JLabel label1 = new JLabel("Account");
    public static JComboBox<String> comboBox1 = new JComboBox<>(); // account

    public static JLabel label2 = new JLabel("Transaction Type");      // action
    public static JComboBox<String> comboBox2 = new JComboBox<>();

    public static JLabel label3 = new JLabel("Amount");      // action
    public static JTextField amount = new JTextField(10);

    public static JButton submitBtn = new JButton("Submit");

    public MakeTransactionPanel() { // TODO input user
        CustomerHome.frame.setTitle("Make Transaction");
        CustomerHome.frame.setSize(350, 200);

        initPanel();
    }

    private void initPanel() { // TODO input user
        JPanel panel0 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel0.add(backBtn);
        backBtn.addActionListener(new BackButtonListener(CustomerHome.frame, CustomerHome.basePane));

        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(label1);
        comboBox1.addActionListener(new MakeTransactionListener());
        panel1.add(comboBox1);


        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(label2);
        panel2.add(comboBox1);

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel3.add(label3);
        panel3.add(amount);

        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        submitBtn.addActionListener(new MakeTransactionListener());
        panel4.add(submitBtn);


        Box vBox = Box.createVerticalBox();
        vBox.add(panel0);
        vBox.add(panel1);
        vBox.add(panel2);
        vBox.add(panel3);
        vBox.add(panel4);

        add(vBox);
    }
}
