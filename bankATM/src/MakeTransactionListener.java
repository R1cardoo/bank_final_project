import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import static java.lang.Double.parseDouble;

public class MakeTransactionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals(MakeTransactionPanel.COMMAND_SELECT_ACCOUNT)) {
            String selectedText = (String) MakeTransactionPanel.comboBox1.getSelectedItem();
            if (selectedText== null) return;
            if (selectedText.equals(MakeTransactionPanel.CHECKING)) {
                MakeTransactionPanel.comboBox2.removeAllItems();
                MakeTransactionPanel.comboBox2.addItem("deposit");
                MakeTransactionPanel.comboBox2.addItem("withdraw");
                MakeTransactionPanel.comboBox2.addItem("loan");
            } else if ( selectedText.equals(MakeTransactionPanel.SAVING)) {
                MakeTransactionPanel.comboBox2.removeAllItems();
                MakeTransactionPanel.comboBox2.addItem("deposit");
                MakeTransactionPanel.comboBox2.addItem("withdraw");
            } else if (selectedText.equals(MakeTransactionPanel.SECURITY)) {
                MakeTransactionPanel.comboBox2.removeAllItems();
                MakeTransactionPanel.comboBox2.addItem("deposit");
                MakeTransactionPanel.comboBox2.addItem("withdraw");
            }
        } else if (command.equals(MakeTransactionPanel.COMMAND_SELECT_TYPE)) {
            String selectedText = (String) MakeTransactionPanel.comboBox2.getSelectedItem();
            if (selectedText != null) {
                MakeTransactionPanel.submitBtn.setEnabled(true);
            }
        } else if (command.equals(MakeTransactionPanel.COMMAND_SUBMIT)) {
            String account = (String) MakeTransactionPanel.comboBox1.getSelectedItem();
            String type = (String) MakeTransactionPanel.comboBox2.getSelectedItem();
            double amount = parseDouble(MakeTransactionPanel.amount.getText());

            if (account.equals(MakeTransactionPanel.CHECKING) && Objects.equals(type, "deposit")) {
                CustomerHome.getCustomer().getCheckAccount().depositMoney(amount);
            } else if (account.equals(MakeTransactionPanel.CHECKING) && Objects.equals(type, "withdraw")) {
                CustomerHome.getCustomer().getCheckAccount().withdrawMoney(amount);
            } else if (account.equals(MakeTransactionPanel.CHECKING) && Objects.equals(type, "loan")) {
                CustomerHome.getCustomer().getCheckAccount().requestLoan(amount);
            } else if (account.equals(MakeTransactionPanel.SAVING) && Objects.equals(type, "deposit")) {
                CustomerHome.getCustomer().getSaveAccount().depositMoney(amount);
            } else if (account.equals(MakeTransactionPanel.SAVING) && Objects.equals(type, "withdraw")) {
                CustomerHome.getCustomer().getSaveAccount().withdrawMoney(amount);
            } else if (account.equals(MakeTransactionPanel.SECURITY) && Objects.equals(type, "deposit")) {
                CustomerHome.getCustomer().getSecuritiesAccount().depositMoney(amount);
            } else if (account.equals(MakeTransactionPanel.SECURITY) && Objects.equals(type, "withdraw")) {
                CustomerHome.getCustomer().getSecuritiesAccount().withdrawMoney(amount);
            }
        }
    }
}
