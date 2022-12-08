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
    private String saveAccount;

    /**
     * CheckAccount
     */
    private String checkAccount;


    private ArrayList<Transaction> transactionArrayList  = new ArrayList<>();



    public ArrayList<Transaction> viewTransactions(){
        return transactionArrayList;
    }

    public Customer(){
        super();
    }

    public Customer(String userName,String password){
        super(userName,password);
    }

    public Customer(String userName, String passWord, String id, boolean isLogin, double balance, String saveAccount, String checkAccount,
                    ArrayList<Transaction> transactionArrayList) {
        super(userName, passWord, id, isLogin);
        this.balance = balance;
        this.saveAccount = saveAccount;
        this.checkAccount = checkAccount;
        this.transactionArrayList=transactionArrayList;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getSaveAccount() {
        return saveAccount;
    }

    public void setSaveAccount(String saveAccount) {
        this.saveAccount = saveAccount;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Customer{");
        sb.append("balance=").append(balance);
        sb.append(", saveAccount='").append(saveAccount).append('\'');
        sb.append(", checkAccount='").append(checkAccount).append('\'');
        sb.append(", transactionArrayList=").append(transactionArrayList);
        sb.append('}');
        return sb.toString();
    }
}
