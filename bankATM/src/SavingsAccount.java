import java.util.ArrayList;
import java.util.List;

/**
 * this class represents a savings account, which is a type of bank account
 */
public class SavingsAccount extends Account {

    public SavingsAccount(String username, TypeOfAccount type, ArrayList<Currency> currencies) {
        super(username, type, currencies);
    }

    public void addInterest() { //interest if the balance is high in the savings account
//        if (this.getBalance() > Constants.getMinimumSavingsAccountBalanceForSecurities()) {
//            double balance = this.getBalance() + (this.getBalance() * Constants.getSavingsAccountInterestPercentage());
//            this.setBalance(balance);
//            // directly update the
//
//
//        }
    }

}
