import javax.swing.*;
import java.awt.*;

public class CustomerHome {
    public static final String COMMAND_CREATE_ACCOUNT = "CreateAccount";
    public static final String COMMAND_MAKE_TRANSACTION = "MakeTransaction";
    public static final String COMMAND_SHOW_ACCOUNT = "ShowAccount";
    public static final String COMMAND_SHOW_MARKET = "ShowMarket";
    public static final String COMMAND_VIEW_TRANSACTIONS = "ViewTransactions";

    // User currentUser;
    public static JFrame frame = new JFrame("Customer Home");

    public static JLabel username = new JLabel("currentUser.name");

    public static JButton logOutBtn = new JButton("Log Out");

    public static JButton createAccountBtn = new MyButton("Create Account"); // Jcheckbox

    public static JButton makeTransactionBtn = new MyButton("Make a Transaction"); // select a account, then action, then amount

    public static JButton showAccountBtn = new MyButton("Show Account Info");

    public static JButton showStockMarketBtn = new MyButton("Show Stock Market Info");

    public static JButton viewTransactionsBtn = new MyButton("View transactions");

    public static Box basePane;

    private static Customer customer = null;

    public CustomerHome(Customer curCustomer) { // 传入一个user
        customer = curCustomer;
        frame.setSize(800, 600);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initFrame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void initFrame() {
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel1.add(username);
        panel1.add(logOutBtn);
        logOutBtn.addActionListener(new LogOutButtonListener(frame));

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        createAccountBtn.setActionCommand(COMMAND_CREATE_ACCOUNT);
        createAccountBtn.addActionListener(new CustomerButtonListener());
        panel2.add(createAccountBtn);

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        makeTransactionBtn.setActionCommand(COMMAND_MAKE_TRANSACTION);
        makeTransactionBtn.addActionListener(new CustomerButtonListener());
        panel3.add(makeTransactionBtn);

        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        showAccountBtn.setActionCommand(COMMAND_SHOW_ACCOUNT);
        showAccountBtn.addActionListener(new CustomerButtonListener());
        panel4.add(showAccountBtn);

        JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        showStockMarketBtn.setActionCommand(COMMAND_SHOW_MARKET);
        showStockMarketBtn.addActionListener(new CustomerButtonListener());
        panel5.add(showStockMarketBtn);

        JPanel panel6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        viewTransactionsBtn.setActionCommand(COMMAND_VIEW_TRANSACTIONS);
        viewTransactionsBtn.addActionListener(new CustomerButtonListener());
        panel6.add(viewTransactionsBtn);

        basePane = Box.createVerticalBox();
        basePane.add(panel1);
        basePane.add(panel2);
        basePane.add(panel3);
        basePane.add(panel4);
        basePane.add(panel5);
        basePane.add(panel6);

        frame.setContentPane(basePane);
    }

    public static Customer getCustomer() {
        return customer;
    }

    public static void dismiss() {
        frame.setVisible(false);
        frame.dispose();
    }
}
