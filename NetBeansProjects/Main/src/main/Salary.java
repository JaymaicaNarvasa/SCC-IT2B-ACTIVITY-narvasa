package main;

public class Salary {
    String id, name;
    int rh, hw, deduc;
    public void addSalary(String sid, String sname, int srh, int shw, int sdeduc){
        this.id = sid;
        this.name = sname;
        this.rh = srh;
        this.hw = shw;
        this. deduc = sdeduc;
    }
    public void viewSalary(){
        double gross = rh * hw;
        double nPay = gross - deduc; 
        System.out.println("ID    Name    Rate    Hour   Gross   Deduction     Net Pay");
        System.out.println(" " + this.id + " " + this.name + " " + this.rh + " " + this.hw + " " + gross + " " + this.deduc + " " + nPay);
        System.out.println("----------------------------------------------------------------------------");
        
    }
}
