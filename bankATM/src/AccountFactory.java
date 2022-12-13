public class AccountFactory { //confirm this because I'm not sure about this

    public static Account createAccount() {
        Account account = new Account();
        account.setUsername(account.getUsername());
        account.setType(account.getType());
        account.setCurrencies(account.getCurrencies());
        return account;
    }

}