package main;
 
import java.util.Scanner;

public class Salaries {
    Scanner sc = new Scanner(System.in);
    String id, name;
    int rh, hw, deduc;
    double gross,nPay;
    public void addSalaries(){
            
            System.out.print("ID: ");
            id = sc.next();
            
            System.out.print("Name: ");
            name = sc.next();
            
            System.out.print("Rate Hourly: ");
            rh = sc.nextInt();
            
            System.out.print("Hour Worked: ");
            hw = sc.nextInt();
            
            System.out.print("Deduction: ");
            deduc = sc.nextInt();
        
    }
    
    public void viewSalaries(){
        double gross = rh * hw;
        double nPay = gross - deduc; 
            System.out.println(" | " + id + " | " + name + " | " + rh + " | " + hw + " | " + gross + " | " + deduc + " | " + nPay);
    }
     public double getGrossPay() {
        return gross;
    }
    
    public int getDeduction() {
        return deduc;
    }
    
    public double getNetPay() {
        return nPay;
    }
    
}
