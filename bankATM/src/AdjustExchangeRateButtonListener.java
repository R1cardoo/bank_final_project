import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Double.parseDouble;

public class AdjustExchangeRateButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String selectedCurrency = (String) AdjustExchangeRatePanel.comboBox.getSelectedItem();
        if (command.equals(AdjustExchangeRatePanel.COMMAND_SELECT_COMBOBOX)) {
            // TODO set textFile based on comboBox selection
            if (selectedCurrency!= null) {
                AdjustExchangeRatePanel.submit.setEnabled(true);
                String text = String.valueOf(CurrencyHelper.getInstance().transferToDollar(selectedCurrency, 1));
                AdjustExchangeRatePanel.worth.setText(text);
            }
        } else if (command.equals(AdjustExchangeRatePanel.COMMAND_SUBMIT)) {
            double rate = parseDouble(AdjustExchangeRatePanel.worth.getText());
            CurrencyHelper.getInstance().updateRate(CurrencyType.valueOf(selectedCurrency), rate);
            PWHelper.success(ManagerHome.frame);
        }
    }
}
