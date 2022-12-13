import javax.swing.*;

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

    public static void success(JFrame frame) {
        JOptionPane.showMessageDialog(
                frame,
                "You did it Successfully!",
                "Notice",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public static void fail(JFrame frame) {
        JOptionPane.showMessageDialog(
                frame,
                "You fail to do that due to some reasons!",
                "Notice",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public static void loginFailed() {
        JOptionPane.showMessageDialog(
                Login.frame,
                "Login Failed",
                "Notice",
                JOptionPane.WARNING_MESSAGE
        );
    }

}
