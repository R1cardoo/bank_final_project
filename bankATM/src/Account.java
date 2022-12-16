import java.util.ArrayList;

/**
 * this class is to represent any type of Account
 */
public class Account {

    private String username;
    private TypeOfAccount type;
    private ArrayList<Currency> currencies = new ArrayList<Currency>(){};

    public Account(String username, TypeOfAccount type, ArrayList<Currency> currencies) { // load from CSV
        this.username = username;
        this.type = type;
        this.currencies = currencies;
    }

    public Account(String username, TypeOfAccount type) { // initialize
        this.username = username;
        this.type = type;
        currenciesInitialization();
    }

    public String getUsername() {
        return username;
    }

    private void currenciesInitialization() {
        Currency currency1 = new Currency(CurrencyType.USD, 0);
        Currency currency2 = new Currency(CurrencyType.INR, 0);
        Currency currency3 = new Currency(CurrencyType.CNY, 0);
        Currency currency4 = new Currency(CurrencyType.GBP, 0);
        currencies.add(currency1);
        currencies.add(currency2);
        currencies.add(currency3);
        currencies.add(currency4);
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
        Admin.getInstance().saveTransaction(myTransaction);
        CustomerHome.getCustomer().addTransaction(myTransaction);

        // TODO now only USD, can implement more later.
        double value = currencies.get(0).getValue();
        currencies.get(0).setValue(value + amount);

        if (this.getClass().equals(CheckingAccount.class)) {
            Admin.getInstance().updateChecking((CheckingAccount) this);
        } else if (this.getClass().equals(SavingsAccount.class)) {
            Admin.getInstance().updateSaving((SavingsAccount) this);
        } else if (this.getClass().equals(SecuritiesAccount.class)) {
            Admin.getInstance().updateSecurities((SecuritiesAccount) this);
        }
    }


    public boolean withdrawMoney(double amount) {
        double curAmount = currencies.get(0).getValue();
        if (curAmount < amount) {
            System.out.println("Not enough balance"); //show not enough balance in GUI
            return false;
        } else { //withdraw only if current balance is more than amount that needs to be withdrawn
            Transaction myTransaction = new Transaction(CustomerHome.getCustomer().getUserName(), type.getTypeOfAccount(),
                    TimeHelper.getInstance().getTime(),0, amount, CurrencyType.USD.toString(),"withdraw");
            Admin.getInstance().getTransactionsList().add(myTransaction);
            Admin.getInstance().saveTransaction(myTransaction);
            CustomerHome.getCustomer().addTransaction(myTransaction);

            currencies.get(0).setValue(curAmount - amount);

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
        currencies.get(0).setValue(amount);
    }

}
