import javax.swing.*;

public class MessageDialogHelper {

    public static void createAccountSuccessful() {
        JOptionPane.showMessageDialog(
                CustomerHome.frame,
                "Account Created Successfully",
                "Notice",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void createAccountDuplicate() {
        JOptionPane.showMessageDialog(
                CustomerHome.frame,
                "You already have this account!",
                "Notice",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void securityAccountNotApplicable() {
        JOptionPane.showMessageDialog(
                CustomerHome.frame,
                "You don't have enough saving to create a security account!",
                "Notice",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
