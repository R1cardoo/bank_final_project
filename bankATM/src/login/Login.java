package login;

import javax.swing.*;
import java.awt.*;

public class Login {

    public static JFrame frame = new JFrame("Login Portal");
    public static JLabel label1 = new JLabel("Username");
    public static JTextField username = new JTextField(10);
    public static JLabel label2 = new JLabel("Password");
    public static JPasswordField password = new JPasswordField(10);
    public static JButton Signinbtn = new JButton("LogIn");
    public static JButton registerbtn = new JButton("Register");
    public static JButton resetbtn = new JButton("Reset");
    public Login() {
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initFrame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void initFrame() {
        JPanel panel01 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel01.add(label1);
        panel01.add(username);

        JPanel panel02 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel02.add(label2);
        panel02.add(password);

        JPanel panel03 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel03.add(Signinbtn);
        panel03.add(registerbtn);
        panel03.add(resetbtn);

        Box vBox = Box.createVerticalBox();
        vBox.add(panel01);
        vBox.add(panel02);
        vBox.add(panel03);

        frame.setContentPane(vBox);
    }
}
