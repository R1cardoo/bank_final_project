/**
 * @author cqin
 * @project_name bank_final_project
 * @date 2022/12/6
 */

public class Currency {
    private double value;  //the value of currency
    private String kind; //kind of currency  US dollar, pound, RMB, Rupee

    public Currency(String kind, double value) {
        this.value = value;
        this.kind = kind;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
