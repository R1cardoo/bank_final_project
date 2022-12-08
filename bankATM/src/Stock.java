import java.util.List;

/**
 * class for representing type of stock
 */
public class Stock {

    private final String stockName;
    private final int stockId;
    private final double stockPrice;
    private final boolean enabled;
    private final List<Double> historyPrice;

    public Stock(String stockName, int stockId, double stockPrice, boolean enabled, List<Double> historyPrice) {
        this.stockName = stockName;
        this.stockId = stockId;
        this.stockPrice = stockPrice;
        this.enabled = enabled;
        this.historyPrice = historyPrice;
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

    public boolean isEnabled() {
        return enabled;
    }

    public List<Double> getHistoryPrice() {
        return historyPrice;
    }

}