import java.util.List;

/**
 * this class represents a checking account, which is a type of bank account
 */
public class CheckingAccount extends Account {

    private int loanAmount;

    public CheckingAccount(String username, double balance, TypeOfAccount type, List<Currency> currencies, int loanAmount) {
        super(username, balance, type, currencies);
        this.loanAmount = loanAmount;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

}