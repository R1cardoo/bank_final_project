/**
 * this class keeps track of all the hard-coded constants needed for the bank functioning
 */
public class Constants {

    private static double minimumSavingsAccountBalanceForSecurities = 5000.00;
    private static double savingsAccountInterestPercentage = 0.03;
    private static double openAccountFee = 15.00;
    private static double closeAccountFee = 25.00;
    private static double minOpenAccountBalance = 100.00;
    private static double minOpenSecuritiesAccountBalance = 1000.00;
    private static double loanInterestPercentage = 0.1;
    private static double withdrawFeePercentage = 0.01;
    private static double transactionFeeRate = 0.05;

    public static double getMinimumSavingsAccountBalanceForSecurities() {
        return minimumSavingsAccountBalanceForSecurities;
    }

    public static double getSavingsAccountInterestPercentage() {
        return savingsAccountInterestPercentage;
    }

    public static double getOpenAccountFee() {
        return openAccountFee;
    }

    public static double getCloseAccountFee() {
        return closeAccountFee;
    }

    public static double getMinOpenAccountBalance() {
        return minOpenAccountBalance;
    }

    public static double getMinOpenSecuritiesAccountBalance() {
        return minOpenSecuritiesAccountBalance;
    }

    public static double getLoanInterestPercentage() {
        return loanInterestPercentage;
    }

    public static double getWithdrawFeePercentage() {
        return withdrawFeePercentage;
    }

    public static double getTransactionFeeRate() {
        return transactionFeeRate;
    }

}
