import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Double.parseDouble;

public class UpdateStockButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String stockSelcted = (String) DeleteStockPanel.comboBox.getSelectedItem();
        if (command.equals(UpdateStockPanel.COMMAND_SELECT_COMBOBOX)) {
            // TODO only when a stock is selected, change Button to valid and set value to textField
            if (stockSelcted != null) {
                UpdateStockPanel.price.setText( String.valueOf(StockMarket.getInstance().getStockByName(stockSelcted).getStockPrice()));
                UpdateStockPanel.submit.setEnabled(true);
            }
        } else if (command.equals(UpdateStockPanel.COMMAND_SUBMIT)) {
            // TODO Update the stock.   if textfield has illegal input, set to 1.
            if (StockMarket.getInstance().updateStock(stockSelcted, parseDouble(UpdateStockPanel.price.getText()))) {
                PWHelper.success(ManagerHome.frame);
            } else {
                PWHelper.fail(ManagerHome.frame);
            }
        }
    }
}
