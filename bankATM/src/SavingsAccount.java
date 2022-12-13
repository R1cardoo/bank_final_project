import java.util.ArrayList;
import java.util.List;

/**
 * this class represents a savings account, which is a type of bank account
 */
public class SavingsAccount extends Account {

    public SavingsAccount(String username, ArrayList<Currency> currencies) {
        super(username, TypeOfAccount.Savings, currencies);
    }

    public SavingsAccount(String username) {
        super(username, TypeOfAccount.Savings);
    }

    public void addInterest() { //interest if the balance is high in the savings account
        if (this.getCurrencies().get(1).getValue() > Constants.getMinimumSavingsAccountBalanceForSecurities()) {
            double balanceUSD = this.getCurrencies().get(1).getValue() + (this.getCurrencies().get(1).getValue() * Constants.getSavingsAccountInterestPercentage());
            this.setUSD(balanceUSD);
            // directly update the
            Admin.getInstance().updateSaving(this);
        }
    }

    @Override
    public String toString() {
        return "SavingsAccount:<br>" + this.getCurrencies().toString() + "<br>";
    }

}
