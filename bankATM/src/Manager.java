import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

public class Manager extends User {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


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
        double checkAccount = 0;
        double saveAccount = 0;
        double securitiesAccount = 0;
        StringBuffer sb = new StringBuffer();
        for (Customer customer : customers) {
            checkAccount += customer.getCheckAccount().getCurrencies().get(1).getValue();
            saveAccount += customer.getSaveAccount().getCurrencies().get(1).getValue();
            securitiesAccount += customer.getSecuritiesAccount().getCurrencies().get(1).getValue();
            sb.append(customer.getTransactionString());
        }
        String ans = "";
        ans+= "checkAccount: <br><br>" + checkAccount +"<br><br>";
        ans+= "saveAccount: <br><br>" + saveAccount +"<br><br>";
        ans+= "securitiesAccount: <br><br>" + securitiesAccount +"<br><br>";
        ans+= "Transactions: <br><br>" + sb +"<br><br>";
        return ans;
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

    public static void newDay(){
        Admin admin = Admin.getInstance();
        for (Customer customer : admin.loadAllCustomers()) {
            //deposit gain interest
            payInterest(customer);
            //loan charge interest
            chargeInterest(customer);
        }
        TimeHelper.getInstance().increase();
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
        customer.getCheckAccount().chargeLoanInterest( customer);
    }

}
