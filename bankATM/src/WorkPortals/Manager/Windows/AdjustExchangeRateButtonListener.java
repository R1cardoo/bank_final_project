package WorkPortals.Manager.Windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdjustExchangeRateButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals(AdjustExchangeRateFrame.COMMAND_SELECT_COMBOBOX)) {
            // TODO set textFile based on comboBox selection
        } else if (command.equals(AdjustExchangeRateFrame.COMMAND_SUBMIT)) {
            // update the exchange rate
        }
    }
}
