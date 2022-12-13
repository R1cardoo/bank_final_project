import java.util.ArrayList;

public class Customer extends User {

    /**
     * balance
     */
    private double balance;

    /**
     *  SavingsAccount
     */
    private SavingsAccount savingsAccount;

    /**
     * CheckAccount
     */
    private CheckingAccount checkingAccount;


    private SecuritiesAccount securitiesAccount;


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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addTransaction(Transaction transaction) {
        this.transactionArrayList.add(transaction);
    }

    public SavingsAccount getSaveAccount() {
        return savingsAccount;
    }

    public void setSaveAccount(SavingsAccount saveAccount) {
        this.savingsAccount = saveAccount;
    }

    public CheckingAccount getCheckAccount() {
        return checkingAccount;
    }

    public void setCheckAccount(CheckingAccount checkAccount) {
        this.checkingAccount = checkAccount;
    }

    public SecuritiesAccount getSecuritiesAccount() {
        return securitiesAccount;
    }

    public void setSecuritiesAccount(SecuritiesAccount securitiesAccount) {
        this.securitiesAccount = securitiesAccount;
    }

    public void saveCustomerInfo(){
        Admin admin = new Admin();
        admin.saveNameAndPSWD(this);
        admin.saveChecking(this.checkingAccount);
        admin.saveSaving(this.savingsAccount);
        admin.saveSecurities(this.securitiesAccount);
        transactionArrayList.forEach(admin::saveTransaction);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Customer{");
        sb.append("balance=").append(balance);
        sb.append(", transactionArrayList=").append(transactionArrayList);
        sb.append('}');
        return sb.toString();
    }
}
