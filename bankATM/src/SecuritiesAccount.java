import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * this class represents a securities account, which is a type of bank account
 */
public class SecuritiesAccount extends Account {

    private double realizedProfit;
    private double unrealizedProfit;
    //key:Stock,   value: buy price, count
    private HashMap<Stock,ArrayList<Double>> stockOwned;

    public SecuritiesAccount(String username, TypeOfAccount type, ArrayList<Currency> currencies, double realizedProfit, double unrealizedProfit, HashMap<Stock,ArrayList<Double>> stockOwned) {
        super(username, type, currencies);
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

    public HashMap<Stock, ArrayList<Double>> getStockOwned() {
        return stockOwned;
    }

    public void setStockOwned(HashMap<Stock, ArrayList<Double>> stockOwned) {
        this.stockOwned = stockOwned;
    }

    public boolean buyStock(String stockName, double amount) {
        List<Stock> stockList = StockMarket.getInstance().getAvailableStocks();
        for (Stock stock : stockList) {
            if (stock.getStockName().equals(stockName)) {
                double unitPrice = stock.getStockPrice();
                double totalPrice = unitPrice * amount;
                double originalMoney = getCurrencies().get(1).getValue();
                if (totalPrice < originalMoney) {
                    System.out.println("No enough money to buy!");
                    return false;
                } else {
                    // deduct money in securitiesAccount
                    Transaction myTransaction = new Transaction(CustomerHome.getCustomer().getUserName(), TypeOfAccount.Checking.getTypeOfAccount(),
                            TimeHelper.getInstance().getTime(),0, totalPrice, CurrencyType.USD.toString(),"buyStock");
                    Admin.getInstance().getTransactionsList().add(myTransaction);
                    getCurrencies().get(1).setValue(originalMoney - totalPrice);
                    // add stock to stockOwned
                    ArrayList<Double> mylist = new ArrayList<Double>();
                    mylist.add(unitPrice);
                    mylist.add(amount);
                    stockOwned.put(stock, mylist);
                    Admin.getInstance().updateSecurities(this);
                    return true;
                }
            }
        }
        System.out.println("No such stock");
        return false;
    }

    public boolean sellStock(String stockName, double amount) {
        for (Stock stock : stockOwned.keySet()) {
            if (stock.getStockName().equals(stockName)) {
                double unitPrice = stock.getStockPrice();
                double totalPrice = unitPrice * amount;
                double originalMoney = getCurrencies().get(1).getValue();
                if (amount > 0 ) {
                    amount = Math.min(amount, stockOwned.get(stock).get(1));

                    // add money in securitiesAccount
                    Transaction myTransaction = new Transaction(CustomerHome.getCustomer().getUserName(), TypeOfAccount.Checking.getTypeOfAccount(),
                            TimeHelper.getInstance().getTime(),0, totalPrice, CurrencyType.USD.toString(),"sellStock");
                    Admin.getInstance().getTransactionsList().add(myTransaction);
                    getCurrencies().get(1).setValue(originalMoney + totalPrice);

                    // deduct amount in stockOwned;
                    double profit = totalPrice - amount * stockOwned.get(stock).get(0);
                    unrealizedProfit -= profit;
                    realizedProfit += profit;

                    if ((stockOwned.get(stock).get(1) - amount) > 0 ) { // if anything left, just deduct amount
                        stockOwned.get(stock).set(1, (stockOwned.get(stock).get(1) - amount));
                    } else { // if nothing left, delete the entire record
                        stockOwned.remove(stock);
                    }

                    Admin.getInstance().updateSecurities(this);
                    return true;
                } else {
                    System.out.println("Amount should be more than 1");
                    return false;
                }
            }
        }
        System.out.println("No such stock");
        return false;
    }

    @Override
    public String toString() {
        return "SecuritiesAccount:<br>" + this.getCurrencies().toString() + "<br>" + "realizedProfit: " + realizedProfit + "<br>" + "unRealizedProfit: " + unrealizedProfit + "<br>" + stockOwned.toString();
    }
}
