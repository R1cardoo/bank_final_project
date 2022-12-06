package WorkPortals.Customer;

import WorkPortals.AccountInfoFrame;
import WorkPortals.Customer.Windows.CreateAccountFrame;
import WorkPortals.Customer.Windows.MakeTransactionFrame;
import WorkPortals.Customer.Windows.ViewTransactionFrame;
import WorkPortals.StockMarketInfoFrame;
import loginPortals.Register;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        // TODO if (command == COMMMAND_XXXXXX)
        switch (command) {
            case CustomerHome.COMMAND_CREATE_ACCOUNT:
                new CreateAccountFrame();
                break;
            case CustomerHome.COMMAND_MAKE_TRANSACTION:
                new MakeTransactionFrame();
                break;
            case CustomerHome.COMMAND_SHOW_ACCOUNT:
                new AccountInfoFrame("TODO info");
                break;
            case CustomerHome.COMMAND_SHOW_MARKET:
                new StockMarketInfoFrame("TODO StockMarketInfo");
                break;
            case CustomerHome.COMMAND_VIEW_TRANSACTIONS:
                new ViewTransactionFrame("TODO transactions");
                break;
        }
    }
}
