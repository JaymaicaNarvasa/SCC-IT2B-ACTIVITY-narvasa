package narvasa;

public class Salaries {
    String id, name;
    int rh, hw, deduc;
    double gross , nPay;
    public void addSalary(String sid, String sname, int srh, int shw, int sdeduc){
        this.id = sid;
        this.name = sname;
        this.rh = srh;  
        this.hw = shw;
        this. deduc = sdeduc;
        calcuGross();
        calcuNPay();
    }
    public void viewSalary(){
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s | %-10s | %-10d | %-10d | %-10.2f | %-10d | %-10.2f\n", this.id, this.name,this.rh, this.hw, gross, this.deduc, nPay);      
    }
    public void calcuGross() {
        this.gross = rh * hw;
    }
    public void calcuNPay () {
        this.nPay = gross - deduc; 
    }
    public double getDeduc () {
        return deduc;
    }
    public double getGross () {
        return gross;
    }
    public double getNpay () {
        return nPay;
    }
}
 