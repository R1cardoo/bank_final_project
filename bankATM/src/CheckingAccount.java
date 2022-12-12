import java.util.List;

/**
 * this class represents a checking account, which is a type of bank account
 */
public class CheckingAccount extends Account {

    private double loanAmount;

    public CheckingAccount(String username, double balance, TypeOfAccount type, List<Currency> currencies, double loanAmount) {
        super(username, balance, type, currencies);
        this.loanAmount = loanAmount;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

}
