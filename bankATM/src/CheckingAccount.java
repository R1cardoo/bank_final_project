import java.util.ArrayList;
import java.util.List;

/**
 * this class represents a checking account, which is a type of bank account
 */
public class CheckingAccount extends Account {

    private double loanAmount;

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

}
