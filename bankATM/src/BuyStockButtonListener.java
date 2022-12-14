import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Double.parseDouble;

public class BuyStockButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String stockSelcted = (String) BuyStockPanel.comboBox.getSelectedItem();
        if (command.equals(BuyStockPanel.COMMAND_SELECT_COMBOBOX)) {
            // TODO only when a stock is selected, change Button to valid and set value to textField
            if (stockSelcted != null) {
                BuyStockPanel.amount.setText("0");
                BuyStockPanel.submit.setEnabled(true);
            }
        } else if (command.equals(BuyStockPanel.COMMAND_SUBMIT)) {
            // TODO Update the stock.   if textfield has illegal input, set to 1.
            if (CustomerHome.getCustomer().getSecuritiesAccount().buyStock(stockSelcted, parseDouble(BuyStockPanel.amount.getText()))) {
                PWHelper.success(CustomerHome.frame);
            } else {
                PWHelper.fail(CustomerHome.frame);
            }
        }
    }
}
