import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteStockButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals(DeleteStockPanel.COMMAND_SELECT_COMBOBOX)) {
            // TODO only when a stock is selected, change Button to valid
            DeleteStockPanel.submit.setEnabled(true);
        } else if (command.equals(DeleteStockPanel.COMMAND_SUBMIT)) {
            // TODO delete the stock
            String stockSelcted = (String) DeleteStockPanel.comboBox.getSelectedItem();
            if (StockMarket.getInstance().removeStock(stockSelcted)) {
                PWHelper.success(ManagerHome.frame);
                DeleteStockPanel.comboBox.removeItem(stockSelcted);
            } else {
                PWHelper.fail(ManagerHome.frame);
            }
        }

    }
}
