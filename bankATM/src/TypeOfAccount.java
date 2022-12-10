/**
 * Enum that handles all types of accounts
 */
public enum TypeOfAccount {

    Savings("Savings"),
    Checking("Checking"),
    Securities("Securities");

    private String typeOfAccount;

    TypeOfAccount(String typeOfAccount) {
        this.setTypeOfAccount(typeOfAccount);
    }

    public String getTypeOfAccount() {
        return typeOfAccount;
    }

    public void setTypeOfAccount(String typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }

}