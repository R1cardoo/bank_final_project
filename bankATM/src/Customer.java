import java.sql.Timestamp;
import java.util.ArrayList;

public class Customer extends User{

    /**
     * balance
     */
    private double balance;

    /**
     *  SavingsAccount
     */
    private String SaveAccount;

    /**
     * CheckAccount
     */
    private String checkAccount;

    /**
     * last pay interest date
     */
    private Timestamp lastPayInterestDate;

    private final ArrayList<Transaction> transactionArrayList;


    public ArrayList<Transaction> viewTransactions(){
        return transactionArrayList;
    }

    public Customer(String userName, String passWord) {
        super(userName, passWord);
        transactionArrayList = new ArrayList<>();
        lastPayInterestDate = new Timestamp(System.currentTimeMillis());
    }

    public Customer() {
        transactionArrayList = new ArrayList<>();
        lastPayInterestDate = new Timestamp(System.currentTimeMillis());
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getSaveAccount() {
        return SaveAccount;
    }

    public void setSaveAccount(String saveAccount) {
        SaveAccount = saveAccount;
    }

    public String getCheckAccount() {
        return checkAccount;
    }

    public void setCheckAccount(String checkAccount) {
        this.checkAccount = checkAccount;
    }

    public void addTransaction(Transaction transaction) {
        this.transactionArrayList.add(transaction);
    }

    public Timestamp getLastPayInterestDate() {
        return lastPayInterestDate;
    }

    public void setLastPayInterestDate(Timestamp lastPayInterestDate) {
        this.lastPayInterestDate = lastPayInterestDate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Customer{");
        sb.append("balance=").append(balance);
        sb.append(", SaveAccount='").append(SaveAccount).append('\'');
        sb.append(", checkAccount='").append(checkAccount).append('\'');
        sb.append(", lastPayInterestDate=").append(lastPayInterestDate);
        sb.append(", transactionArrayList=").append(transactionArrayList);
        sb.append('}');
        return sb.toString();
    }
}
