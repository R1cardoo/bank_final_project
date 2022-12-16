import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccountListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        Customer customer = CustomerHome.getCustomer();

        if (command.equals(CreateAccountPanel.COMMAND_CREAT_CHECKING)) {
            if (customer.getCheckAccount() != null) {
                MessageDialogHelper.createAccountDuplicate();
            } else {
                customer.setCheckAccount(new CheckingAccount(customer.getUserName()));
                MessageDialogHelper.createAccountSuccessful();
            }
        } else if (command.equals(CreateAccountPanel.COMMAND_CREATE_SAVING)) {
            if (customer.getSaveAccount() != null) {
                MessageDialogHelper.createAccountDuplicate();
            } else {
                customer.setSaveAccount(new SavingsAccount(customer.getUserName()));
                MessageDialogHelper.createAccountSuccessful();
            }

        } else if (command.equals(CreateAccountPanel.COMMAND_CREATE_SECURITY)) {
            if (customer.getSecuritiesAccount() != null) {
                MessageDialogHelper.createAccountDuplicate();
            } else {
                if (customer.getCheckAccount()!= null && customer.getCheckAccount().getCurrencies().get(0).getValue() > 5000) {
                    customer.setSecuritiesAccount(new SecuritiesAccount(customer.getUserName()));
                    MessageDialogHelper.createAccountSuccessful();
                } else {
                    MessageDialogHelper.securityAccountNotApplicable();
                }
            }
        }
    }
}
