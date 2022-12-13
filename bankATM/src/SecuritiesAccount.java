import java.util.ArrayList;
import java.util.List;

/**
 * this class represents a securities account, which is a type of bank account
 */
public class SecuritiesAccount extends Account {

    private boolean enabled;
    private double realizedProfit;
    private double unrealizedProfit;
    private List<Stock> stockOwned;

    private ArrayList<Integer> ownedNum;

    public SecuritiesAccount(String username, TypeOfAccount type, ArrayList<Currency> currencies, boolean enabled, double realizedProfit, double unrealizedProfit, List<Stock> stockOwned) {
        super(username, type, currencies);
        this.enabled = enabled;
        this.realizedProfit = realizedProfit;
        this.unrealizedProfit = unrealizedProfit;
        this.stockOwned = stockOwned;
    }

    //need to add these methods: buyStocks() and sellStocks()
    //but these methods are related to the StockMarket class so need to work on that first?

    public double getRealizedProfit() {
        return realizedProfit;
    }

    public void setRealizedProfit(double realizedProfit) {
        this.realizedProfit = realizedProfit;
    }

    public double getUnrealizedProfit() {
        return unrealizedProfit;
    }

    public void setUnrealizedProfit(double unrealizedProfit) {
        this.unrealizedProfit = unrealizedProfit;
    }

}
