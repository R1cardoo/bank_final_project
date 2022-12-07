import java.io.Serializable;
import java.sql.Timestamp;

public class Transaction implements Serializable {
    /**
     * account name
     */
    String accountName;
    /**
     * account id
     */
    String accountId;
    /**
     * account type
     */
    String accountType;

    Timestamp date;
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
                "accountName='" + accountName + '\'' +
                ", accountId='" + accountId + '\'' +
                ", accountType='" + accountType + '\'' +
                ", date=" + date +
                ", feeCharged=" + feeCharged +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", type='" + transactionType + '\'' +
                '}';
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
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
