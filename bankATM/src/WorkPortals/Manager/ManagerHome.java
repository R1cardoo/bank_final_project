package WorkPortals.Manager;

import WorkPortals.MyButton;

import javax.swing.*;
import java.awt.*;

public class ManagerHome {
    public static JFrame frame = new JFrame("Manager Home");

    public static JLabel username = new JLabel("Manager");

    public static JButton LogOutBtn = new JButton("LogOut");

    public static JButton getReportBtn = new MyButton("Get Daily Report");

    public static JButton getCustomerInfo = new MyButton("Get Customer Info"); // AccountInfo Frame

    public static JButton adjustExchangeRate = new MyButton("Adjust Exchange Rate"); // select currency(except USD), input exchange rate to USD

    public static JButton showStockMarketBtn = new MyButton("Stock Market Info");

    public static JButton addStockBtn = new MyButton("Add Stock");

    public static JButton deleteStockBtn = new MyButton("Delete Stock");

    public static JButton updateStockBtn = new MyButton("UpdateStock");

    public static JButton newBusinessDayBtn = new MyButton("New Business Day"); //

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
        panel1.add(LogOutBtn);


        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(getReportBtn);
        getReportBtn.addActionListener(new ManagerButtonListener());

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel3.add(getCustomerInfo);
        getCustomerInfo.addActionListener(new ManagerButtonListener());

        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel4.add(adjustExchangeRate);
        adjustExchangeRate.addActionListener(new ManagerButtonListener());

        JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel5.add(showStockMarketBtn);
        showStockMarketBtn.addActionListener(new ManagerButtonListener());



        JPanel panel6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel6.add(addStockBtn);
        panel6.add(deleteStockBtn);
        panel6.add(updateStockBtn);
        addStockBtn.addActionListener(new ManagerButtonListener());
        deleteStockBtn.addActionListener(new ManagerButtonListener());
        updateStockBtn.addActionListener(new ManagerButtonListener());

        JPanel panel7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel7.add(newBusinessDayBtn);
        newBusinessDayBtn.addActionListener(new ManagerButtonListener());

        Box vBox = Box.createVerticalBox();
        vBox.add(panel1);
        vBox.add(panel2);
        vBox.add(panel3);
        vBox.add(panel4);
        vBox.add(panel5);
        vBox.add(panel6);
        vBox.add(panel7);

        frame.setContentPane(vBox);
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
