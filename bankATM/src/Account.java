import java.util.ArrayList;
import java.util.List;

/**
 * this class is to represent any type of Account
 */
public class Account {

    private String username;
    private TypeOfAccount type;
    private ArrayList<Currency> currencies;

    public Account(String username, TypeOfAccount type, ArrayList<Currency> currencies) {
        this.username = username;
        this.type = type;
        this.currencies = currencies;
    }

    public Account() {

    }

    public String getUsername() {
        return username;
    }


    public TypeOfAccount getType() {
        return type;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(ArrayList<Currency> currencies) {
        this.currencies = currencies;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setType(TypeOfAccount type) {
        this.type = type;
    }


    public void withdrawMoney(double amount) {
//        if (balance > amount) { //withdraw only if current balance is more than amount that needs to be withdrawn
//            this.balance -= amount;
//        }
//        else {
//            System.out.println("Not enough balance"); //show not enough balance in GUI
//        }
    }

}
