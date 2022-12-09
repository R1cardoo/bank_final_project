import javax.swing.*;
import java.awt.*;

public class CreateAccountPanel extends JPanel {

    public static JButton backBtn = new JButton("back");
    public static JButton createCheckingAccountBtn = new MyButton("Create Checking Account");

    public static JButton createSavingAccountBtn = new MyButton("Create Saving Account");

    public static JButton createSecurityAccountBtn = new MyButton("Create Security Account");
    public CreateAccountPanel() {
        CustomerHome.frame.setTitle("Create Account");
        CustomerHome.frame.setSize(400, 500);

        initPanel();
    }

    private void initPanel() {
        JPanel panel0 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel0.add(backBtn);
        backBtn.addActionListener(new BackButtonListener(CustomerHome.frame, CustomerHome.basePane));

        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(createCheckingAccountBtn);
        createCheckingAccountBtn.addActionListener(new CreateAccountListener());

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(createSavingAccountBtn);
        createSavingAccountBtn.addActionListener(new CustomerButtonListener());

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel3.add(createSecurityAccountBtn);
        createSecurityAccountBtn.addActionListener(new CustomerButtonListener());

        Box vBox = Box.createVerticalBox();
        vBox.add(panel0);
        vBox.add(panel1);
        vBox.add(panel2);
        vBox.add(panel3);

        add(vBox);
    }

}
