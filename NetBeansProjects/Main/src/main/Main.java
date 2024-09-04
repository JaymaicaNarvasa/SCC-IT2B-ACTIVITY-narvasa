package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
    Scanner sc = new Scanner(System.in);
    Salaries[] sl = new Salaries[10];
    
    String res;
        System.out.print("Enter no. of Employees: ");
        int num = sc.nextInt();
    
        double totalGross = 0, totalNetPay = 0;
        int totalDeductions = 0;
        
        if(num == 0){
            System.out.println("You inputed " + num);
        }else{
        for(int j = 0; j < num; j++){
            System.out.println("Enter details of employee "+(j +  1));
            sl[j] = new Salaries();
            sl[j].addSalaries();
            totalGross += sl[j].getGrossPay();
            totalDeductions += sl[j].getDeduction();
            totalNetPay += sl[j].getNetPay();
        }
        
        for(int j = 0; j < num; j++){
            sl[j].viewSalaries();
        }
        System.out.println("----------------------------------------------------------");
        System.out.printf("Total Salary Request: %.2f\n", totalGross);
        System.out.println("Total Employee Deduction : " + totalDeductions);
        System.out.printf("Total Net pay: %.2f\n", totalNetPay);
        System.out.println("NO. of employees: " + num);
        }
        
         Salary emp1 = new Salary();
        emp1.addSalary("Emp01", "Jema", 600, 40, 1450);

        Salary emp2 = new Salary();
        emp2.addSalary("Emp02", "Makang", 750, 35, 2300);
        
        emp1.viewSalary();
        emp2.viewSalary();

         totalGross = (emp1.rh * emp1.hw) + (emp2.rh * emp2.hw);
         totalDeductions = emp1.deduc + emp2.deduc;
         totalNetPay = (totalGross - totalDeductions);

        System.out.println("Total Salary Request: " + totalGross);
        System.out.println("Total Employee Deduction: " + totalDeductions);
        System.out.println("Total Net Pay: " + totalNetPay);
        System.out.println("NO. of employees: 2");
    }
    
}

