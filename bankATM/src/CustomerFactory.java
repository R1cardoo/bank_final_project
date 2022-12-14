
public class CustomerFactory {

    public static Customer registerCustomer(String userName,String passWord) {
        Customer customer = new Customer(userName, passWord);
        Admin.getInstance().saveNameAndPSWD(customer);
        return customer;
    }
}
