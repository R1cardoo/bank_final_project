import java.util.HashMap;

/**
 * @author cqin
 * @project_name bank_final_project
 * @date 2022/12/6
 */

//this class is designed for converting value for different kinds of currency
//manager can update the latest exchange rate
public class CurrencyHelper {

    private static CurrencyHelper instance = null;

    public static CurrencyHelper getInstance() {
        if (instance == null) {
            instance = new CurrencyHelper();
        }
        return instance;
    }
    // Our exchange rates are calculated using foreign currency to US dollar exchange rates.
    private HashMap<CurrencyType, Double> currencyConvert;

    public CurrencyHelper() {
        currencyConvert=new HashMap<>();
        initialRate();
    }

    public void initialRate(){
        currencyConvert.put(CurrencyType.GBP,1.24);
        currencyConvert.put(CurrencyType.CNY,0.14);
        currencyConvert.put(CurrencyType.INR,0.012);
    }

    //add new kinds of currency or update currency already existed
    public void updateRate(CurrencyType type,double value){
        currencyConvert.put(type, value);
    }

    public double transferToDollar(String kind, double value){
        return value*currencyConvert.get(CurrencyType.valueOf(kind));
    }

    //if our bank don't support a kind of currency anymore, call this func to delete it.
    public boolean delCurrency(CurrencyType type){
        if(!currencyConvert.containsKey(type)){
           return false;  //currency does not exist
        }
        currencyConvert.remove(type);
        return true;

    }
}
