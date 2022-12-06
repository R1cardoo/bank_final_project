package WorkPortals.Manager.Windows;

import javax.swing.*;
import java.awt.*;

public class AdjustExchangeRateFrame {
    public static JFrame frame = new JFrame("Adjust Exchange Rate");

    public static JLabel label1 = new JLabel("currency: ");

    public static JComboBox<String> comboBox = new JComboBox<>(); // select a currency

    public static JLabel label2 = new JLabel("Worth (USD)");
    public static JTextField worth = new JTextField(10);

    public AdjustExchangeRateFrame() {
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initFrame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void initFrame() {
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(label1);
        for ()
        panel1.add(comboBox);


        Box vBox = Box.createVerticalBox();
        vBox.add(panel);

        frame.setContentPane(vBox);
    }

}
