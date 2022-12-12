import java.util.List;

/**
 * this class is to represent any type of Account
 */
public class Account {

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

    public Account() {

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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setType(TypeOfAccount type) {
        this.type = type;
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
