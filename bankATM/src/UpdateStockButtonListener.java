import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateStockButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals(UpdateStockPanel.COMMAND_SELECT_COMBOBOX)) {
            // TODO only when a stock is selected, change Button to valid and set value to textField
        } else if (command.equals(UpdateStockPanel.COMMAND_SUBMIT)) {
            // TODO Update the stock.   if textfield has illegal input, set to 1.
        }
    }
}
