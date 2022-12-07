public class TransactionFactory {


    public static Transaction createTransaction(Customer customer,double fee,long date, String transType){
        Transaction transaction = new Transaction();
        transaction.setUserName("userName");
        transaction.setAccountType("accountType");
        transaction.setFeeCharged(fee);
        transaction.setAmount(customer.getBalance());
        transaction.setDate(date);
        transaction.setTransactionType(transType);
        return transaction;
    }
}
