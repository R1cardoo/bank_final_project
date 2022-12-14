import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Double.parseDouble;

public class SellStockButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String stockSelcted = (String) SellStockPanel.comboBox.getSelectedItem();
        if (command.equals(SellStockPanel.COMMAND_SELECT_COMBOBOX)) {
            // TODO only when a stock is selected, change Button to valid and set value to textField
            if (stockSelcted != null) {
                SellStockPanel.amount.setText(Double.toString(CustomerHome.getCustomer().getSecuritiesAccount().getOwnedAmount(stockSelcted)));
                SellStockPanel.submit.setEnabled(true);
            }
        } else if (command.equals(SellStockPanel.COMMAND_SUBMIT)) {
            // TODO Update the stock.   if textfield has illegal input, set to 1.
            if (CustomerHome.getCustomer().getSecuritiesAccount().sellStock(stockSelcted, parseDouble(SellStockPanel.amount.getText()))) {
                PWHelper.success(CustomerHome.frame);
            } else {
                PWHelper.fail(CustomerHome.frame);
            }
        }
    }
}
