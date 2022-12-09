import java.util.ArrayList;
import java.util.UUID;

public class CustomerFactory {

    /**
     * create customer list
     * @return ArrayList<Customer>
     */
    public static ArrayList<Customer> createCustomerList(int size) {
        ArrayList<Customer> customers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Customer customer = new Customer();
            generateId(customer);
            customers.add(customer);
        }
        return customers;
    }

    public static Customer createCustomer(String userName,String passWord) {
        Customer customer = new Customer(userName,passWord);
        generateId(customer);
        return customer;

    }

    /**
     * generate id for customer
     * @return boolean
     */
    public static boolean generateId(Customer customer) {
        if (customer.getId() == null || "".equals(customer.getId())){
            customer.setId(UUID.randomUUID().toString());
            return true;
        }else {
            System.err.println("CustomerPortals" +customer.getUserName()+"ID exists, please try a new one");
            return false;
        }


    }
}
