import java.util.ArrayList;

public class CustomerFactory {

    /**
     * create customer list
     * @return ArrayList<Customer>
     */
    public static ArrayList<Customer> createCustomerList(int size) {
        ArrayList<Customer> customers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Customer customer = new Customer();
            customers.add(customer);
        }
        return customers;
    }

    public static Customer createCustomer(String userName,String passWord) {
        return new Customer(userName,passWord);
    }


    public static Customer registerCustomer(String userName,String passWord) {
        Customer customer = new Customer(userName, passWord);
        Admin admin = new Admin();
        admin.saveNameAndPSWD(customer);
        return customer;
    }
}
