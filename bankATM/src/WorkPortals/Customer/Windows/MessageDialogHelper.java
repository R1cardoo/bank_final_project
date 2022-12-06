package WorkPortals.Customer.Windows;

import javax.swing.*;

public class MessageDialogHelper {

    public static void createAccountSuccessful() {
        JOptionPane.showMessageDialog(
                CreateAccountFrame.frame,
                "Account Created Successfully",
                "Notice",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void createAccountDuplicate() {
        JOptionPane.showMessageDialog(
                CreateAccountFrame.frame,
                "You already have this account!",
                "Notice",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void securityAccountNotApplicable() {
        JOptionPane.showMessageDialog(
                CreateAccountFrame.frame,
                "You don't have enough saving to create a security account!",
                "Notice",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
