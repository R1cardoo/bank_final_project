import java.util.List;

/**
 * class for representing type of stock
 */
public class Stock {

    private final String stockName;
    private final int stockId;
    private final double stockPrice;

    public Stock(String stockName, int stockId, double stockPrice) {
        this.stockName = stockName;
        this.stockId = stockId;
        this.stockPrice = stockPrice;
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

}