import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ViewCustomerInfoButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals(ViewCustomerInfoPanel.COMMAND_COMBO_BOX)) {
            if ((String)ViewCustomerInfoPanel.comboBox.getSelectedItem() != null) {
                String temp = (String) ViewCustomerInfoPanel.comboBox.getSelectedItem();
                ViewCustomerInfoPanel.searchBtn.setEnabled(true);
            } else {
                ViewCustomerInfoPanel.searchBtn.setEnabled(false);
            }
        } else if (command.equals(ViewCustomerInfoPanel.COMMAND_SEARCH)) {
            String username = (String) ViewCustomerInfoPanel.comboBox.getSelectedItem();
            try {
                String info= "<html><body>" + Manager.checkCustomer(username) + "<body></html>";
                ViewCustomerInfoPanel.label.setText(info);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
