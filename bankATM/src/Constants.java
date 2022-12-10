/**
 * this class keeps track of all the hard-coded constants needed for the bank functioning
 */
public class Constants {

    private static double minimumSavingsAccountBalanceForSecurities = 5000.00;
    private static double savingsAccountInterestPercentage = 0.02;

    public static double getMinimumSavingsAccountBalanceForSecurities() {
        return minimumSavingsAccountBalanceForSecurities;
    }

    public static double getSavingsAccountInterestPercentage() {
        return savingsAccountInterestPercentage;
    }

}