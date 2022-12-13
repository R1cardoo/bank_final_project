import java.util.ArrayList;
import java.util.List;

/**
 * this class represents a checking account, which is a type of bank account
 */
public class CheckingAccount extends Account {

    private double loanAmount = 0;

    public CheckingAccount(String username, TypeOfAccount type, ArrayList<Currency> currencies, double loanAmount) {
        super(username, type, currencies);
        this.loanAmount = loanAmount;
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


        loanAmount +=amount;
        double value = this.getCurrencies().get(1).getValue();
        this.getCurrencies().get(1).setValue(value + amount);

        Admin.getInstance().updateChecking((CheckingAccount) this);
    }

    public void chargeLoanInterest() {
        double amount = loanAmount * Constants.getLoanInterestPercentage();
        Transaction myTransaction = new Transaction(CustomerHome.getCustomer().getUserName(), TypeOfAccount.Checking.getTypeOfAccount(),
                TimeHelper.getInstance().getTime(),0, amount, CurrencyType.USD.toString(),"loanInterest");
        Admin.getInstance().getTransactionsList().add(myTransaction);

        loanAmount += amount;
        Admin.getInstance().updateChecking(this);
    }

    @Override
    public String toString() {
        return "CheckingAccount:<br>" + this.getCurrencies().toString() + "<br>" + "loan: " + loanAmount + "<br>";
    }
}
