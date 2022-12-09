import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

public class ButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (Login.COMMAND_SIGNIN.equals(command)) { // press signIn button
            System.out.println("Login Button pressed");
            // check manager
            String username = Login.username.getText();
            String password = Login.password.getText();
            if (username.equals("admin")) {
                if (password.equals("admin")) {
                    new ManagerHome();
                    Login.dismiss();
                } else {
                    PWHelper.loginFailed();
                }
            }

            Customer curUser = null;
            try {
                curUser = User.login(username, password);
            } catch (IOException ex) {
                System.out.println("Login Error!");
                throw new RuntimeException(ex);
            }
            if (curUser == null) {
                PWHelper.loginFailed();
            } else {
                PWHelper.loginSuccessful();
                Login.dismiss();
                new CustomerHome();
            }
        } else if (Register.COMMAND_REGISTER.equals(command)) { // press register button
            System.out.println("Register Button pressed");
            if(Arrays.equals(Register.conpassword.getPassword(), Login.password.getPassword())) {
                PWHelper.registerSuccessful();
            }
            else {
                PWHelper.registerFailed();
            }

        } else if (Login.COMMAND_RESET.equals(command)) { // press reset button
            System.out.println("Reset Button pressed");
            Login.username.setText("");
            Login.password.setText("");
            Register.conpassword.setText("");
            Login.username.requestFocus(); // reset cursor
        } else if (Login.COMMAND_REGISTER.equals(command)) { // press go to register
            System.out.println("Go to register page");
            Login.dismiss();
            Register.register();
        } else if (Register.COMMAND_BACK.equals(command)) {
            Register.dismiss();
            new Login();
        }
    }
}