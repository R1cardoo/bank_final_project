import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Double.parseDouble;

public class TransferMoneyButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String FromAccount = (String) TransferMoneyPanel.comboBox1.getSelectedItem();
        String ToAccount = (String) TransferMoneyPanel.comboBox2.getSelectedItem();
        double amount = parseDouble(TransferMoneyPanel.amount.getText());
        if (FromAccount == null || ToAccount == null) {
            PWHelper.fail(CustomerHome.frame);
            return;
        }
        if (amount <= getAmountFromAccount(FromAccount)) {
            withdrawFromAccount(FromAccount, amount);
            depositToAccount(ToAccount, amount);
            PWHelper.success(CustomerHome.frame);
        } else {
            PWHelper.fail(CustomerHome.frame);
        }

    }

    public double getAmountFromAccount(String FromAccount) {
        if (FromAccount.equals(TransferMoneyPanel.CHECKING)) {
            return CustomerHome.getCustomer().getCheckAccount().getCurrencies().get(0).getValue();
        } else if (FromAccount.equals(TransferMoneyPanel.SAVING)) {
            return CustomerHome.getCustomer().getSaveAccount().getCurrencies().get(0).getValue();
        } else if (FromAccount.equals(TransferMoneyPanel.SECURITY)) {
            return CustomerHome.getCustomer().getSecuritiesAccount().getCurrencies().get(0).getValue();
        }
        return 0;

    }

    public void withdrawFromAccount(String account, double amount) {
        if (account.equals(TransferMoneyPanel.CHECKING)) {
            CustomerHome.getCustomer().getCheckAccount().withdrawMoney(amount);
        } else if (account.equals(TransferMoneyPanel.SAVING)) {
            CustomerHome.getCustomer().getSaveAccount().withdrawMoney(amount);
        } else if (account.equals(TransferMoneyPanel.SECURITY)) {
            CustomerHome.getCustomer().getSecuritiesAccount().withdrawMoney(amount);
        }
    }

    public void depositToAccount(String account, double amount) {
        if (account.equals(TransferMoneyPanel.CHECKING)) {
            CustomerHome.getCustomer().getCheckAccount().depositMoney(amount);
        } else if (account.equals(TransferMoneyPanel.SAVING)) {
            CustomerHome.getCustomer().getSaveAccount().depositMoney(amount);
        } else if (account.equals(TransferMoneyPanel.SECURITY)) {
            CustomerHome.getCustomer().getSecuritiesAccount().depositMoney(amount);
        }
    }
}
