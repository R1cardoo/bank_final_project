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
}
