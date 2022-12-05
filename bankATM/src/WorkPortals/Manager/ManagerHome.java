package WorkPortals.Manager;

import WorkPortals.myButton;

import javax.swing.*;
import java.awt.*;

public class ManagerHome {
    public static JFrame frame = new JFrame("Manager Home");

    public static JLabel username = new JLabel("Manager");

    public static JButton LogOutBtn = new JButton("LogOut");

    public static JButton getReportBtn = new myButton("Get Daily Report");

    public static JButton getCustomerInfo = new myButton("Get Customer Info");

    public static JButton adjustExchangeRate = new myButton("Adjust Exchange Rate"); // select currency(except USD), input exchange rate to USD

    public static JButton showStockMarketBtn = new myButton("Show Stock Market Info");

    public static JButton manageAccountBtn = new myButton("Manage Account"); // delete account

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
        panel6.add(manageAccountBtn);
        manageAccountBtn.addActionListener(new ManagerButtonListener());

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

    // 1. show all accounts         (frame)
    // 2. individual accountInfo    (frame)
    // 3. stockMarket Info          (frame)
    // 4. buy stock and sell stock  (window)
}
