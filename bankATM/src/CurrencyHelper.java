import java.util.HashMap;

/**
 * @author cqin
 * @project_name bank_final_project
 * @date 2022/12/6
 */

//this class is designed for converting value for different kinds of currency
//manager can update the latest exchange rate
public class CurrencyHelper {
    // Our exchange rates are calculated using foreign currency to US dollar exchange rates.
    private HashMap<String, Double> currencyConvert;

    public CurrencyHelper() {
        currencyConvert=new HashMap<>();
        initialRate();
    }

    public void initialRate(){
        currencyConvert.put("Pound",1.24);
        currencyConvert.put("RMB",0.14);
        currencyConvert.put("Rupee",0.012);
    }

    //add new kinds of currency or update currency already existed
    public void updateRate(String kind,double value){
        currencyConvert.put(kind, value);
    }

    public double transferToDollar(String kind, double value){
        return value*currencyConvert.get(kind);
    }

    //if our bank don't support a kind of currency anymore, call this func to delete it.
    public boolean delCurrency(String kind){
        if(!currencyConvert.containsKey(kind)){
           return false;  //already existed
        }
        currencyConvert.remove(kind);
        return true;

    }
}
