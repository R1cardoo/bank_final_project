import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StockMarket {

    private static StockMarket instance = null;

    public static StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
            admin = Admin.getInstance();
            allStocks = admin.loadStockInfo();
        }
        return instance;
    }

    private static Admin admin = null;

    private static List<Stock> allStocks = null;



    public List<Stock> getAvailableStocks(){
        allStocks = admin.loadStockInfo();
        return allStocks;
    }


    public boolean updateStock(String stockName, double newPrice){
        Stock stock = admin.getStockByName(stockName);
        if (stock != null){
            stock.setStockPrice(newPrice);
            admin.updateStock(stock);
            for (Stock stok: allStocks) {
                if (stok.getStockName().equals(stockName)) {
                    stok.setStockPrice(newPrice);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean addStock(String stockName, int stockId, double stockPrice){
        Stock stock = new Stock(stockName, stockId, stockPrice);
        allStocks.add(stock);
        admin.saveStock(stock);
        return true;
    }

    public boolean removeStock(String stockName){
        Stock stock = admin.getStockByName(stockName);
        if (stock!=null) {
            admin.delStock(stock);
            for (Stock stok: allStocks) {
                if (stok.getStockName().equals(stockName)) {
                    allStocks.remove(stok);
                    return true;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public Stock getStockByName(String stockName) {
        for (Stock stok: allStocks) {
            if (stok.getStockName().equals(stockName)) return stok;
        }
        return null;
    }
}
