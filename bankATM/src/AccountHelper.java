public class AccountHelper { //confirm this because I'm not sure about how this would work

    private static AccountFactory factory;
    private static Account account;

    public Account createAccount() {
        return factory.createAccount();
    }

    public boolean saveAccountInfo() {
        return true;
    }

    public boolean applyLoans() {
        return true;
    }

    public boolean transfer() {
        return true;
    }

    public boolean withdrawl() {
        return true;
    }

    public boolean requestLoan() {
        return true;
    }

    public boolean updateAccount() {
        return true;
    }

    public boolean balanceAdd() {
        return true;
    }

    public boolean balanceMinus() {
        return true;
    }

    public boolean buyStock() {
//        if (isRich()) {
//            account.buyStock();
//            return true;
//        } else {
//            return false;
//        }
        return false;
    }

    public boolean sellStock() {
        return true;
    }

}