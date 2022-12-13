import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import static java.lang.Double.parseDouble;

public class AddStockButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // String command = e.getActionCommand();
        String stockName = AddStockPanel.name.getText();
        double price = parseDouble(AddStockPanel.price.getText());

        if (StockMarket.getInstance().addStock(stockName, (int) TimeHelper.getInstance().getTime(),price)) {
            PWHelper.success(ManagerHome.frame);
        }
        // TODO add it to market
    }
}
