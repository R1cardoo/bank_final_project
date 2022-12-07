import java.io.Serializable;
import java.sql.Timestamp;

public class Transaction implements Serializable {
    /**
     * account name
     */
    String userName;
    /**
     * account type
     */
    String accountType;

    long date;
    /**
     * fee charged
     */
    double feeCharged;

    /**
     * amount
     */
    double amount;
    /**
     * currency
     */
    String currency;

    /**
     * type: withdraw，deposit，loan
     */
    String transactionType;

    @Override
    public String toString() {
        return "Transaction{" +
                "userName='" + userName + '\'' +
                ", accountType='" + accountType + '\'' +
                ", date=" + date +
                ", feeCharged=" + feeCharged +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", transactionType='" + transactionType + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public double getFeeCharged() {
        return feeCharged;
    }

    public void setFeeCharged(double feeCharged) {
        this.feeCharged = feeCharged;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
