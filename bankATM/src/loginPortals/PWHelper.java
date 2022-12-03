package loginPortals;

import javax.swing.JOptionPane;
public class PWHelper {
    public static void registerSuccessful() {
        JOptionPane.showMessageDialog(
                Register.frame,
                "Register Successfully",
                "Notice",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public static void registerFailed() {
        JOptionPane.showMessageDialog(
                Register.frame,
                "The two passwords are different",
                "Notice",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public static void loginSuccessful() {
        JOptionPane.showMessageDialog(
                Login.frame,
                "Login Successfully",
                "Notice",
                JOptionPane.WARNING_MESSAGE
        );
    }
}
