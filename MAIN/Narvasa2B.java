package MAIN;

import java.util.Scanner;

public class Narvasa2B {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String choice;
        
        System.out.println("     WELCOME TO MY SYSTEM    ");
        System.out.println("------------------------------");
        System.out.println("Choose the following Option ");
        System.out.println("a. Product");
        System.out.println("b. Salary");
        System.out.println("c. Account");
        System.out.println("------------------------------");
        
            System.out.printf("Choose Option: ");
            String opt = sc.next();
            
                switch(opt){
                    case "a": case "A":
                        break;
                        
                    case "b": case "B":
                        Salary sl = new Salary();
                        sl.addSalaries();
                        break;
                        
                    case "c": case "C":
                        Account ac = new Account ();
                        ac.addAccount();
                        break;
                        
                    default:
                        if(opt.equals(opt)){
                            System.out.println("The option need only Alphabetical");
                        }
                        break;
                }
    }
    
}
