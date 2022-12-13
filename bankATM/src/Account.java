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

    public ArrayList<Currency> getCurrencies() {
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

    public void depositMoney(double amount) {
        Transaction myTransaction = new Transaction(CustomerHome.getCustomer().getUserName(), type.getTypeOfAccount(),
                TimeHelper.getInstance().getTime(),0, amount, CurrencyType.USD.toString(),"deposit");
        Admin.getInstance().getTransactionsList().add(myTransaction);

        // TODO now only USD, can implement more later.
        double value = currencies.get(1).getValue();
        currencies.get(1).setValue(value);

        if (this.getClass().equals(CheckingAccount.class)) {
            Admin.getInstance().updateChecking((CheckingAccount) this);
        } else if (this.getClass().equals(SavingsAccount.class)) {
            Admin.getInstance().updateSaving((SavingsAccount) this);
        } else if (this.getClass().equals(SecuritiesAccount.class)) {
            Admin.getInstance().updateSecurities((SecuritiesAccount) this);
        }
    }


    public boolean withdrawMoney(double amount) {
        double curAmount = currencies.get(1).getValue();
        if (curAmount < amount) {
            System.out.println("Not enough balance"); //show not enough balance in GUI
            return false;
        } else { //withdraw only if current balance is more than amount that needs to be withdrawn
            Transaction myTransaction = new Transaction(CustomerHome.getCustomer().getUserName(), type.getTypeOfAccount(),
                    TimeHelper.getInstance().getTime(),0, amount, CurrencyType.USD.toString(),"withdraw");
            Admin.getInstance().getTransactionsList().add(myTransaction);

            currencies.get(1).setValue(curAmount - amount);

            if (this.getClass().equals(CheckingAccount.class)) {
                Admin.getInstance().updateChecking((CheckingAccount) this);
            } else if (this.getClass().equals(SavingsAccount.class)) {
                Admin.getInstance().updateSaving((SavingsAccount) this);
            } else if (this.getClass().equals(SecuritiesAccount.class)) {
                Admin.getInstance().updateSecurities((SecuritiesAccount) this);
            }
            return true;
        }
    }

    public void setUSD(double amount) {
        currencies.get(1).setValue(amount);
    }

}
