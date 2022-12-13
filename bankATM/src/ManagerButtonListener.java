import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case ManagerHome.COMMAND_GET_REPORT: // get daily report
                // ManagerHome.dismiss();
                ManagerHome.frame.setContentPane(new ViewDailyReportPanel("TODO the report"));
                break;
            case ManagerHome.COMMAND_ADJUST_EXCHANGE_RATE: // adjust exchange rate
                // ManagerHome.dismiss();
                ManagerHome.frame.setContentPane(new AdjustExchangeRatePanel());
                break;
            case ManagerHome.COMMAND_GET_CUSTOMER_INFO:  // get customer info
                // ManagerHome.dismiss();
                ManagerHome.frame.setContentPane(new ViewCustomerInfoPanel(ManagerHome.frame,ManagerHome.basePane, "TODO INFO"));
                break;
            case ManagerHome.COMMAND_SHOW_STOCK_MARKET:    // show stock market info
                // ManagerHome.dismiss();
                ManagerHome.frame.setContentPane(new StockMarketInfoPanel(ManagerHome.frame, ManagerHome.basePane,"TODO stock info"));
                break;
            case ManagerHome.COMMAND_ADD_STOCK:     // add a stock to stock market
                // ManagerHome.dismiss();

                ManagerHome.frame.setContentPane(new AddStockPanel());
                break;
            case ManagerHome.COMMAND_DELETE_STOCK:      // delete a stock from stock market
                // ManagerHome.dismiss();
                ManagerHome.frame.setContentPane(new DeleteStockPanel());
                break;
            case ManagerHome.COMMAND_UPDATE_STOCK:      // update stock price
                // ManagerHome.dismiss();
                ManagerHome.frame.setContentPane(new UpdateStockPanel());
                break;
            case ManagerHome.COMMAND_NEW_BUSINESS_DAY:     // get to a new day. pay interests
                // TODO pay depositInterest and get loanInterest
                break;
        }
    }
}
