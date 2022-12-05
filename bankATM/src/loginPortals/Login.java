package loginPortals;

import javax.swing.*;
import java.awt.*;

public class Login {
    public static final String COMMAND_SIGNIN = "SignIn";
    public static final String COMMAND_REGISTER = "register";
    public static final String COMMAND_RESET = "reset";

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

    private void initFrame() {
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(label1);
        panel1.add(username);

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(label2);
        panel2.add(password);

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Signinbtn.setActionCommand(COMMAND_SIGNIN);
        Signinbtn.addActionListener(new ButtonListener());
        registerbtn.setActionCommand(COMMAND_REGISTER);
        registerbtn.addActionListener(new ButtonListener());
        resetbtn.setActionCommand(COMMAND_RESET);
        resetbtn.addActionListener(new ButtonListener());
        panel3.add(Signinbtn);
        panel3.add(registerbtn);
        panel3.add(resetbtn);

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
