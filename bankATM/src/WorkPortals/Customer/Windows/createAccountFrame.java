package WorkPortals.Customer.Windows;

import WorkPortals.Customer.CustomerButtonListener;
import WorkPortals.myButton;

import javax.swing.*;
import java.awt.*;

public class createAccountFrame extends JDialog {

    public static JFrame frame = new JFrame("Create Account Portal");

    public static JButton createCheckingAccountBtn = new myButton("Create Checking Account");

    public static JButton createSavingAccountBtn = new myButton("Create Saving Account");

    public static JButton createSecurityAccountBtn = new myButton("Create Security Account");
    public createAccountFrame() {
        frame.setSize(300, 200);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initFrame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void initFrame() {
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel1.add(createCheckingAccountBtn);
        createCheckingAccountBtn.addActionListener(new createAccountListener());

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(createSavingAccountBtn);
        createSavingAccountBtn.addActionListener(new CustomerButtonListener());

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel3.add(createSecurityAccountBtn);
        createSecurityAccountBtn.addActionListener(new CustomerButtonListener());

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
