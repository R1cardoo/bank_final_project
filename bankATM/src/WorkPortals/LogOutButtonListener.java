package WorkPortals;

import loginPortals.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogOutButtonListener implements ActionListener {
    private JFrame myFrame;
    public LogOutButtonListener(JFrame frame) {
        this.myFrame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        myFrame.setVisible(false);
        myFrame.dispose();
        new Login();
    }
}
