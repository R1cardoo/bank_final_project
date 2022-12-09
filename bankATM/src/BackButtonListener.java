import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackButtonListener implements ActionListener {

    private JFrame frame;

    private Box basePane;

    public BackButtonListener(JFrame frame, Box basePane) {
        this.frame = frame;
        this.basePane = basePane;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setSize(800, 600);
        frame.setContentPane(basePane);
    }
}
