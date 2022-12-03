package loginPortals;
//注册界面类
import java.awt.FlowLayout;
import java.awt.Rectangle;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class Register {
    public static final String COMMAND_REGISTER = "Register";
    public static JFrame frame = new JFrame("Register Portal");
    public static JLabel label = new JLabel("Re-enter Password");
    public static JPasswordField conpassword = new JPasswordField(8);
    public static JButton registerbtn = new JButton("Register");

    public Register() {
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initFrame2();
        frame.setBounds(
                new Rectangle(
                        (int) Login.frame.getBounds().getX()+ 50,
                        (int) Login.frame.getBounds().getY() + 50,
                        (int) Login.frame.getBounds().getWidth(),
                        (int) Login.frame.getBounds().getHeight()
                ));
        frame.setVisible(true);
    }

    public void initFrame2() {
        JPanel panel1 = new JPanel();
        panel1.add(Login.label1);
        panel1.add(Login.username);

        JPanel panel2 = new JPanel();
        panel2.add(Login.label2);
        panel2.add(Login.password);

        JPanel panel3 = new JPanel();
        panel3.add(label);
        panel3.add(conpassword);

        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        registerbtn.setActionCommand(COMMAND_REGISTER);
        registerbtn.addActionListener(new ButtonListener());
        panel4.add(registerbtn);
        panel4.add(Login.resetbtn);

        Box myVerticalBox = Box.createVerticalBox();
        myVerticalBox.add(panel1);
        myVerticalBox.add(panel2);
        myVerticalBox.add(panel3);
        myVerticalBox.add(panel4);

        frame.setContentPane(myVerticalBox);
    }
    public static void register() {
        new Register();
    }

    public static void dismiss() {
        frame.setVisible(false);
        frame.dispose();
    }

}