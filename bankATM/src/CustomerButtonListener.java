import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        // TODO if (command == COMMMAND_XXXXXX)
        switch (command) {
            case CustomerHome.COMMAND_CREATE_ACCOUNT:
                CustomerHome.frame.setContentPane(new CreateAccountPanel());
                break;
            case CustomerHome.COMMAND_MAKE_TRANSACTION:
                CustomerHome.frame.setContentPane(new MakeTransactionPanel());
                break;
            case CustomerHome.COMMAND_SHOW_ACCOUNT:
                CustomerHome.frame.setContentPane(new AccountInfoPanel(CustomerHome.frame, CustomerHome.basePane,CustomerHome.getCustomer().toString()));
                break;
            case CustomerHome.COMMAND_SHOW_MARKET:
                CustomerHome.frame.setContentPane(new StockMarketInfoPanel(CustomerHome.frame, CustomerHome.basePane,"TODO StockMarketInfo"));
                break;
            case CustomerHome.COMMAND_VIEW_TRANSACTIONS:
                CustomerHome.frame.setContentPane(new ViewTransactionPanel("TODO StockMarketInfo"));
                break;
        }
    }
}
