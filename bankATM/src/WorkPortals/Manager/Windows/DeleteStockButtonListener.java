package WorkPortals.Manager.Windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteStockButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals(DeleteStockFrame.COMMAND_SELECT_COMBOBOX)) {
            // TODO only when a stock is selected, change Button to valid
        } else if (command.equals(DeleteStockFrame.COMMAND_SUBMIT)) {
            // TODO delete the stock
        }

    }
}
