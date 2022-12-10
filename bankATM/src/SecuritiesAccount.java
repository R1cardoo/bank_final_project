import java.util.List;

/**
 * this class represents a securities account, which is a type of bank account
 */
public class SecuritiesAccount extends Account {

    private boolean enabled;
    private double realizedProfit;
    private double unrealizedProfit;
    private List<Stock> stockOwned;

    public SecuritiesAccount(String username, double balance, TypeOfAccount type, List<Currency> currencies, boolean enabled, double realizedProfit, double unrealizedProfit, List<Stock> stockOwned) {
        super(username, balance, type, currencies);
        this.enabled = enabled;
        this.realizedProfit = realizedProfit;
        this.unrealizedProfit = unrealizedProfit;
        this.stockOwned = stockOwned;
    }

    //need to add these methods: buyStocks() and sellStocks()
    //but these are related to the StockMarket class so need to work on that first

}