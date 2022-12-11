/**
 * @author cqin
 * @project_name bank_final_project
 * @date 2022/12/6
 */

public class Currency {

    private CurrencyType type; //kind of currency  US dollar, pound, RMB, Rupee
    private double value;  //the value of currency

    public Currency(CurrencyType type, double value) {
        this.value = value;
        this.type=type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public CurrencyType getType() {
        return type;
    }
}
