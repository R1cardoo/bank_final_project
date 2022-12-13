import java.util.List;

/**
 * class for representing type of stock
 */
public class Stock {

    private String stockName;
    private int stockId;
    private double stockPrice;

    public Stock(String stockName, int stockId, double stockPrice) {
        this.stockName = stockName;
        this.stockId = stockId;
        this.stockPrice = stockPrice;
    }

    public Stock() {
    }

    public String getStockName() {
        return stockName;
    }

    public int getStockId() {
        return stockId;
    }

    public double getStockPrice() {
        return stockPrice;
    }


    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }
}