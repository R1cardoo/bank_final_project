import javax.swing.*;
import java.awt.*;

public class ManagerHome {
    public static final String COMMAND_GET_REPORT = "GetDailyReport";
    public static final String COMMAND_GET_CUSTOMER_INFO = "GetCustomerInfo";
    public static final String COMMAND_ADJUST_EXCHANGE_RATE = "AdjustExchangeRate";
    public static final String COMMAND_SHOW_STOCK_MARKET = "ShowStockMarket";
    public static final String COMMAND_ADD_STOCK = "AddStock";
    public static final String COMMAND_DELETE_STOCK = "DeleteStock";
    public static final String COMMAND_UPDATE_STOCK = "UpdateStock";
    public static final String COMMAND_NEW_BUSINESS_DAY = "NewBusinessDay";

    public static JFrame frame = new JFrame("Manager Home");

    public static JLabel username = new JLabel("ManagerPortals");

    public static JButton logOutBtn = new JButton("LogOut");

    public static JButton getReportBtn = new MyButton("Get Daily Report");

    public static JButton getCustomerInfo = new MyButton("Get Customer Info"); // AccountInfo Frame

    public static JButton adjustExchangeRate = new MyButton("Adjust Exchange Rate"); // select currency(except USD), input exchange rate to USD

    public static JButton showStockMarketBtn = new MyButton("Stock Market Info");

    public static JButton addStockBtn = new MyButton("Add Stock");

    public static JButton deleteStockBtn = new MyButton("Delete Stock");

    public static JButton updateStockBtn = new MyButton("UpdateStock");

    public static JButton newBusinessDayBtn = new MyButton("New Business Day"); //

    public static Box basePane;

    public ManagerHome() { // 传入一个user
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
        panel2.add(getReportBtn);
        getReportBtn.setActionCommand(COMMAND_GET_REPORT);
        getReportBtn.addActionListener(new ManagerButtonListener());

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel3.add(getCustomerInfo);
        getCustomerInfo.setActionCommand(COMMAND_GET_CUSTOMER_INFO);
        getCustomerInfo.addActionListener(new ManagerButtonListener());

        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel4.add(adjustExchangeRate);
        adjustExchangeRate.setActionCommand(COMMAND_ADJUST_EXCHANGE_RATE);
        adjustExchangeRate.addActionListener(new ManagerButtonListener());

        JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel5.add(showStockMarketBtn);
        showStockMarketBtn.setActionCommand(COMMAND_SHOW_STOCK_MARKET);
        showStockMarketBtn.addActionListener(new ManagerButtonListener());

        JPanel panel6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel6.add(addStockBtn);
        panel6.add(deleteStockBtn);
        panel6.add(updateStockBtn);
        addStockBtn.setActionCommand(COMMAND_ADD_STOCK);
        addStockBtn.addActionListener(new ManagerButtonListener());
        deleteStockBtn.setActionCommand(COMMAND_DELETE_STOCK);
        deleteStockBtn.addActionListener(new ManagerButtonListener());
        updateStockBtn.setActionCommand(COMMAND_UPDATE_STOCK);
        updateStockBtn.addActionListener(new ManagerButtonListener());

        JPanel panel7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel7.add(newBusinessDayBtn);
        newBusinessDayBtn.setActionCommand(COMMAND_NEW_BUSINESS_DAY);
        newBusinessDayBtn.addActionListener(new ManagerButtonListener());

        basePane = Box.createVerticalBox();
        basePane.add(panel1);
        basePane.add(panel2);
        basePane.add(panel3);
        basePane.add(panel4);
        basePane.add(panel5);
        basePane.add(panel6);
        basePane.add(panel7);

        frame.setContentPane(basePane);
    }

    public static void dismiss() {
        frame.setVisible(false);
        frame.dispose();
    }

    // 1. show all accounts         (frame)
    // 2. individual accountInfo    (frame)
    // 2. adjust exchange rate      (frame)
    // 3. stockMarket Info          (frame)
    // 3. addStock,deleteStock, updateStock(frame)
    // 4. buy stock and sell stock  (window)
}
