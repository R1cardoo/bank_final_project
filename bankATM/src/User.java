import java.io.Serializable;

public class User implements Serializable {
    private String userName;
    private String passWord;
    private String id;
    private boolean isLogin = false;

    public boolean login(String userName, String passWord){
        isLogin = userName.equals(this.userName) && passWord.equals(this.passWord);
        return isLogin;
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
