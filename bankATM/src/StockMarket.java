import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StockMarket {


    private static Admin admin = new Admin();

    private static List<Stock> allStocks = admin.loadStockInfo();



    public List<Stock> getAvailableStocks(){
        allStocks = admin.loadStockInfo();
        return allStocks;
    }


    public static boolean updateStock(String stockName,double newPrice){
        Stock stock;
        if ((stock = admin.getStockByName(stockName))!=null){
            stock.setStockPrice(newPrice);
            admin.updateStock(stock);
            return true;
        }else {
            return false;
        }
    }

    public static boolean addStock(String stockName, int stockId, double stockPrice){
        Stock stock = new Stock(stockName, stockId, stockPrice);
        allStocks.add(stock);
        admin.saveStock(stock);
        return true;
    }

    public static boolean removeStock(String stockName){
        Stock stock;
        if ((stock = admin.getStockByName(stockName))!=null){
            allStocks.remove(stock);
            admin.delStock(stock);
            return true;
        }else {
            return false;
        }
    }



}
