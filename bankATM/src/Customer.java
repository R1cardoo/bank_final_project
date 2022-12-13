import java.util.ArrayList;

public class Customer extends User {

    /**
     *  SavingsAccount
     */
    private SavingsAccount savingsAccount = null;

    /**
     * CheckAccount
     */
    private CheckingAccount checkingAccount = null;


    private SecuritiesAccount securitiesAccount = null;


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
        final StringBuffer sb = new StringBuffer("Customer: " + this.getUserName() + "<br><br>");
        sb.append("Accounts: <br>")
                .append(this.checkingAccount.toString()).append("<br>")
                .append(this.savingsAccount.toString()).append("<br>")
                .append(this.securitiesAccount.toString()).append("<br><br>");
        sb.append(", transactionArrayList=<br>").append(transactionArrayList.toString());
        sb.append('}');
        return sb.toString();
    }
}
