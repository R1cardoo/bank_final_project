package WorkPortals.Customer;

import WorkPortals.myButton;

import javax.swing.*;
import java.awt.*;

public class CustomerHome {

    // User currentUser;
    public static JFrame frame = new JFrame("Customer Home");

    public static JLabel username = new JLabel("currentUser.name");

    public static JButton LogOutBtn = new JButton("Log Out");

    public static JButton createAccountBtn = new myButton("Create Account"); // Jcheckbox

    public static JButton makeTransactionBtn = new myButton("Make a Transaction"); // select a account, then action, then amount

    public static JButton showAccountBtn = new myButton("Show Account Info");

    public static JButton showStockMarketBtn = new myButton("Show Stock Market Info");

    public static JButton viewTransactionsBtn = new myButton("View transactions");

    public CustomerHome() { // 传入一个user
        frame.setSize(800, 600);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initFrame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void initFrame() {
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel1.add(username);
        panel1.add(LogOutBtn);


        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(createAccountBtn);
        createAccountBtn.addActionListener(new CustomerButtonListener());

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel3.add(makeTransactionBtn);
        makeTransactionBtn.addActionListener(new CustomerButtonListener());

        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel4.add(showAccountBtn);
        showAccountBtn.addActionListener(new CustomerButtonListener());

        JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel5.add(showStockMarketBtn);
        showStockMarketBtn.addActionListener(new CustomerButtonListener());

        JPanel panel6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel6.add(viewTransactionsBtn);
        viewTransactionsBtn.addActionListener(new CustomerButtonListener());

        Box vBox = Box.createVerticalBox();
        vBox.add(panel1);
        vBox.add(panel2);
        vBox.add(panel3);
        vBox.add(panel4);
        vBox.add(panel5);
        vBox.add(panel6);

        frame.setContentPane(vBox);
    }

    public static void dismiss() {
        frame.setVisible(false);
        frame.dispose();
    }
}
