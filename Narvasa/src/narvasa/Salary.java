package narvasa;

import java.util.*;

public class Salary {
    Scanner sc = new Scanner(System.in);
    Salaries[] sl = new Salaries[100];
    Set<String>  nameSet = new HashSet<>();
    
    String  id, name;
    int rh, hw, deduc, num;
    double gross, nPay, tSalary = 0.0, tDeduc = 0.0, tNpay = 0.0;
    public void addSalaries(){
             while(true){
                System.out.printf("Enter no. of Employee: ");
                if (sc.hasNextInt()){
                     num = sc.nextInt();
                     
                     if (num > 100){
                    System.out.println("You can only enter 100 employee");
                  
                     }else {
                         break;
                     }
                }else{
                      System.out.println(" INVALID INPUT, Please try Again");;
                      sc.next();
                    }
             }
         
            for (int j = 0; j < num; j++){
            System.out.println("-------------------------------------------");
            System.out.println("Details of employee no. " + (j+1) + ":");
                
            String format = String.format("Emp%03d", (j + 1));
            System.out.printf("ID: %s\n", format);
            
            while(true){
             System.out.printf("Name: ");
              name = sc.next();
                    if(isValidName(name)){
                        System.out.println("I don't think " + name + " is valid.");
                    }else if(nameSet.contains(name)){
                        System.out.println("This NAME already exist. Please enter a new name.");
                    }else{
                        nameSet.add(name);
                     break;
                }
             }
            
            
            rh = getValid("Rate Hourly");
            hw = getValid("Hours Worked");
            deduc = getValid("Deduction");
            
            sl[j] = new Salaries();
            sl[j].addSalary(format, name, rh, hw, deduc);
            
            tSalary += sl[j].getGross();
            tDeduc += sl[j].getDeduc();
            tNpay += sl[j].getNpay();
            }
            
            System.out.printf("%-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s\n", "ID", "Name", "Rate", "Hour", "Gross", "Deduction", "Net Pay");
            
            for(int j = 0; j < num; j++){
                sl[j].viewSalary();
            }
            System.out.printf("Total Salary Request: %.2f\n", tSalary);
            System.out.printf("Total Employee Deduction: %.2f\n", tDeduc);
            System.out.printf("Total Net Pay: %.2f \n", tNpay);
            System.out.println("No. of Employees: " + num);
    }
    public boolean isValidName (String name){
         return name.isEmpty() || !name.matches("[a-zA-Z]+");
     }
    private int getValid(String validType) {
        int valid;
        while (true) {
            System.out.printf("%s: ", validType);
            if (sc.hasNextInt()) {
                valid = sc.nextInt();
                break;
            } else {
                System.out.println("INVALID, Please input a number.");
                sc.next(); 
            }
        }
        return valid;
    }
}
