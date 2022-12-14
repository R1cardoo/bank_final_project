import java.util.ArrayList;

/**
 * this class represents a checking account, which is a type of bank account
 */
public class CheckingAccount extends Account {

    private double loanAmount = 0;

    public CheckingAccount(String username, ArrayList<Currency> currencies, double loanAmount) {
        super(username, TypeOfAccount.Checking, currencies);
        this.loanAmount = loanAmount;
    }
    public CheckingAccount(String username) {
        super(username, TypeOfAccount.Checking);
        this.loanAmount = 0;
        Admin.getInstance().saveChecking(this);
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void requestLoan(double amount) {
        Transaction myTransaction = new Transaction(CustomerHome.getCustomer().getUserName(), TypeOfAccount.Checking.getTypeOfAccount(),
                TimeHelper.getInstance().getTime(),0, amount, CurrencyType.USD.toString(),"loan");
        Admin.getInstance().getTransactionsList().add(myTransaction);
        Admin.getInstance().saveTransaction(myTransaction);
        CustomerHome.getCustomer().addTransaction(myTransaction);

        loanAmount +=amount;
        double value = this.getCurrencies().get(0).getValue();
        this.getCurrencies().get(0).setValue(value + amount);

        Admin.getInstance().updateChecking((CheckingAccount) this);
    }

    public void chargeLoanInterest(Customer customer) {
        double amount = loanAmount * Constants.getLoanInterestPercentage();
        Transaction myTransaction = new Transaction(customer.getUserName(), TypeOfAccount.Checking.getTypeOfAccount(),
                TimeHelper.getInstance().getTime(),0, amount, CurrencyType.USD.toString(),"loanInterest");
        Admin.getInstance().getTransactionsList().add(myTransaction);
        Admin.getInstance().saveTransaction(myTransaction);
        customer.addTransaction(myTransaction);

        loanAmount += amount;
        Admin.getInstance().updateChecking(this);
    }

    @Override
    public String toString() {
        return "CheckingAccount:<br>" + this.getCurrencies().toString() + "<br>" + "loan: " + loanAmount + "<br>";
    }
}
