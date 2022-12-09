import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Manager extends User {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * interest rate
     *
     */
    static double interestRate = 0.001;

    public Manager(String userName, String passWord) {
        super(userName, passWord);
    }


    /**
     * return all deposit
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public String getDailyReport(){
        Admin admin = new Admin();
        List<Customer> customers = admin.loadAllCustomers();
        double count = 0;
        for (Customer customer : customers) {
            count += customer.getBalance();
        }
        return String.valueOf(count);
    }



    public static String checkCustomer(String id) throws IOException {
        Admin admin = new Admin();
        for (Customer customer : admin.loadAllCustomers()) {
            if (customer.getId().equals(id)){
                return "balance:"+customer.getBalance()+"\n\n";
            }
        }
        return "";
    }

    /**
     * charge fee
     */
    public static void chargeFee(Customer customer, double fee,String type) {
        if (customer.getBalance() <= 0) {
            System.err.println("fail to charge fee, not enough balance");
        } else {
            customer.setBalance(customer.getBalance() - fee);
            Transaction transaction = TransactionFactory.createTransaction(customer, fee, TimeHelper.getInstance().getTime(), type);
            customer.addTransaction(transaction);
        }

    }

    public static void newDay(){
        Admin admin = new Admin();
        for (Customer customer : admin.loadAllCustomers()) {
            //deposit gain interest
            payInterest(customer);
            //loan charge interest
            chargeInterest(customer);
        }
    }

    /**
     * pay interest to saving account that > 5000
     * @return
     */
    public static void payInterest(Customer customer) {
        if (customer.getBalance() > 5000){
            double value = customer.getBalance() * interestRate;
            customer.setBalance(customer.getBalance()+value);
            Transaction transaction = TransactionFactory.createTransaction(customer, value,TimeHelper.getInstance().getTime(), "depositInterest");
            customer.addTransaction(transaction);
        }
    }

    /**
     * charge interest from people apply loan
     *
     * @return
     */
    public static void chargeInterest(Customer customer) {

    }

    public static void addStock(){

    }

    public static void deleteStock(){

    }

    public static void updateStockPrice(){

    }

    /**
     * change exchange rate
     */
    public static void changeExchangeRate() {

    }
}
