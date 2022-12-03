package login;
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

    public static JFrame frame2 = new JFrame("注册界面");
    public static JLabel label3 = new JLabel("确认密码");
    public static JPasswordField conpassword = new JPasswordField(8);
    public static JButton rregisterbtn = new JButton("注册");

    public Register() {

        //设置窗口大小
        frame2.setSize(350, 200);
        //设置按下右上角X号后关闭
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //调用函数初始化窗体的组件
        initFrame2();
        //新窗口与旧窗口错开50像素。
        frame2.setBounds(
                new Rectangle(
                        (int) Login.frame.getBounds().getX()+ 50,
                        (int) Login.frame.getBounds().getY() + 50,
                        (int) Login.frame.getBounds().getWidth(),
                        (int) Login.frame.getBounds().getHeight()
                ));
        //窗口可见
        frame2.setVisible(true);
    }

    public void initFrame2() {

        JPanel panel11 = new JPanel();
        panel11.add(Login.label1);
        panel11.add(Login.username);

        JPanel panel12 = new JPanel();
        panel12.add(Login.label2);
        panel12.add(Login.password);

        JPanel panel13 = new JPanel();
        panel13.add(label3);
        panel13.add(conpassword);

        JPanel panel14 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel14.add(rregisterbtn);
        panel14.add(Login.resetbtn);

        Box vBox = Box.createVerticalBox();
        vBox.add(panel11);
        vBox.add(panel12);
        vBox.add(panel13);
        vBox.add(panel14);

        frame2.setContentPane(vBox);
    }
    public static void register() {
        new Register();
    }

}