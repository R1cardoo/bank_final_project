import java.util.List;

/**
 * this class represents a savings account, which is a type of bank account
 */
public class SavingsAccount extends Account {

    public SavingsAccount(String username, double balance, TypeOfAccount type, List<Currency> currencies) {
        super(username, balance, type, currencies);
    }

    public void addInterest() { //interest if the balance is high in the savings account
        if (this.getBalance() > Constants.getMinimumSavingsAccountBalanceForSecurities()) {
            this.setBalance(this.getBalance() + (this.getBalance() * Constants.getSavingsAccountInterestPercentage()));
        }
    }

}
