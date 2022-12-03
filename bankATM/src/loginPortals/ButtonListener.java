package loginPortals;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ButtonListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (Login.COMMAND_SIGNIN.equals(command)) { // press signIn button
            System.out.println("Login Button pressed");
            // TODO check here     if failed ????
            PWHelper.loginSuccessful();

        } else if (Register.COMMAND_REGISTER.equals(command)) { // press register button
            System.out.println("Register Button pressed");
            if(Arrays.equals(Register.conpassword.getPassword(), Login.password.getPassword())) {
                PWHelper.registerSuccessful();
                Register.dismiss();
                // TODO if manager  else user
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
        }
    }
}