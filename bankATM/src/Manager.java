import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

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
    public static String getDailyReport(){
        Admin admin = Admin.getInstance();
        List<Customer> customers = admin.loadAllCustomers();
        double count = 0;
        for (Customer customer : customers) {
            count += customer.getCheckAccount().getCurrencies().get(1).getValue() +
                    customer.getSaveAccount().getCurrencies().get(1).getValue() +
                    customer.getSecuritiesAccount().getCurrencies().get(1).getValue();
        }
        return String.valueOf(count);
    }



    public static String checkCustomer(String username) throws IOException {
        Admin admin = Admin.getInstance();
        for (Customer customer : admin.loadAllCustomers()) {
            if (customer.getUserName().equals(username)){
                return customer.toString();
            }
        }
        return "null";
    }

    /**
     * charge fee
     */
    public static void chargeFee(Customer customer, double fee,String type) {
        double originalAmount = customer.getCheckAccount().getCurrencies().get(1).getValue();

        if (originalAmount - fee < 0) {
            System.err.println("fail to charge fee, not enough balance");
        } else {
            Transaction transaction = TransactionFactory.createTransaction(customer, fee, TimeHelper.getInstance().getTime(), "fee");
            customer.addTransaction(transaction);
            customer.getCheckAccount().getCurrencies().get(1).setValue(originalAmount - fee);
            Admin.getInstance().updateChecking(customer.getCheckAccount());
        }

    }

    public static void newDay(){
        Admin admin = Admin.getInstance();
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
        customer.getSaveAccount().addInterest();
    }

    /**
     * charge interest from people apply loan
     *
     * @return
     */
    public static void chargeInterest(Customer customer) {
        customer.getCheckAccount().chargeLoanInterest();
    }

}
