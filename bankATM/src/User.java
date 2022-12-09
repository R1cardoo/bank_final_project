import java.io.Serializable;
import java.util.List;
import java.io.IOException;

public class User implements Serializable {
    private String userName;
    private String passWord;
    private String id;
    private boolean isLogin = false;

    public static Customer login(String userName, String passWord) throws IOException{
        Admin admin = new Admin();
        List<Customer> customers = admin.loadAllCustomers();
        for (Customer customer : customers) {
            if (customer.getUserName().equals(userName) && customer.getPassWord().equals(passWord)) {
                return customer;
            }
        }
        return null;
    }

    public User(){

    }

    public User(String userName, String passWord, String id, boolean isLogin) {
        this.userName = userName;
        this.passWord = passWord;
        this.id = id;
        this.isLogin = isLogin;
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public boolean logout(){
        this.isLogin = false;
        return true;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("userName='").append(userName).append('\'');
        sb.append(", passWord='").append(passWord).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append(", isLogin=").append(isLogin);
        sb.append('}');
        return sb.toString();
    }
}
