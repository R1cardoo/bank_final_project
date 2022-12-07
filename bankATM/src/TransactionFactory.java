import java.sql.Timestamp;
import java.util.Date;

public class TransactionFactory {


    public static Transaction createTransaction(Customer customer,double fee,String type){
        Transaction transaction = new Transaction();
        transaction.setAccountId("accountId");
        transaction.setAccountName("accountName");
        transaction.setAccountType("accountType");
        transaction.setFeeCharged(fee);
        transaction.setAmount(customer.getBalance());
        transaction.setDate(new Timestamp(System.currentTimeMillis()));

        transaction.setType(type);
        return transaction;
    }
}
