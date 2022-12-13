import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccountListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        Customer customer = CustomerHome.getCustomer();

        if (command.equals(CreateAccountPanel.COMMAND_CREAT_CHECKING)) {
            if (customer.getCheckAccount() != null) {
                PWHelper.fail(CustomerHome.frame);
            } else {
                customer.setCheckAccount(new CheckingAccount(customer.getUserName()));
                PWHelper.success(CustomerHome.frame);
            }
        } else if (command.equals(CreateAccountPanel.COMMAND_CREATE_SAVING)) {
            if (customer.getSaveAccount() != null) {
                PWHelper.fail(CustomerHome.frame);
            } else {
                customer.setSaveAccount(new SavingsAccount(customer.getUserName()));
                PWHelper.success(CustomerHome.frame);
            }

        } else if (command.equals(CreateAccountPanel.COMMAND_CREATE_SECURITY)) {
            if (customer.getSecuritiesAccount() != null) {
                PWHelper.fail(CustomerHome.frame);
            } else {
                customer.setSecuritiesAccount(new SecuritiesAccount(customer.getUserName()));
                PWHelper.success(CustomerHome.frame);
            }
        }
    }
}
