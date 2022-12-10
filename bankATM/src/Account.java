import java.util.List;

/**
 * this abstract class is to represent any type of Account
 */
public abstract class Account {

    private String username;
    private double balance;
    private TypeOfAccount type;
    private List<Currency> currencies;
    
    public Account(String username, double balance, TypeOfAccount type, List<Currency> currencies) {
        this.username = username;
        this.balance = balance;
        this.type = type;
        this.currencies = currencies;
    }

    public String getUsername() {
        return username;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public TypeOfAccount getType() {
        return type;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public void depositMoney(double amount) {
        this.balance += amount;
    }

    public void withdrawMoney(double amount) {
        if (balance > amount) { //withdraw only if current balance is more than amount that needs to be withdrawn
            this.balance -= amount;
        }
        else {
            System.out.println("Not enough balance"); //show not enough balance in GUI
        }
    }

}