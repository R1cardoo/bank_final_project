package WorkPortals.Manager.Windows;

import javax.swing.*;
import java.awt.*;

public class AddStockFrame {
    public static JFrame frame = new JFrame("Add Stock");

    public static JLabel label1 = new JLabel("Name: ");

    public static JTextField name = new JTextField(10);

    public static JLabel label2 = new JLabel("Id: ");
    public static JTextField id = new JTextField(10);

    public static JLabel label3 = new JLabel("Price: ");
    public static JTextField price = new JTextField(10);
    public static JButton submit = new JButton("Submit");

    public AddStockFrame() {
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initFrame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void initFrame() {
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(label1);
        panel1.add(name);

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(label2);
        panel2.add(id);

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel3.add(label3);
        panel3.add(price);

        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel4.add(submit);
        submit.addActionListener(new AddStockButtonListener());

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
