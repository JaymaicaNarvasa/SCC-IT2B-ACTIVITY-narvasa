package MAIN;

import java.util.Scanner;

public class Narvasa2B {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String choice;
        
        do{
        System.out.println("     WELCOME TO MY SYSTEM    ");
        System.out.println("------------------------------");
        System.out.println("Choose the following Option ");
        System.out.println("a. Receipt");
        System.out.println("b. Salary");
        System.out.println("c. Account");
        System.out.println("d. Exit");
        System.out.println("------------------------------");
        
            System.out.printf("Choose Option: ");
            String opt = sc.next();
            
            
                switch(opt){
                    case "a": case "A":
                        Receipt rc = new Receipt();
                        rc.getReciept();
                    break;
                        
                    case "b": case "B":
                        Salary sl = new Salary();
                        sl.addSalaries();
                    break;
                        
                    case "c": case "C":
                        Account ac = new Account ();
                        ac.addAccount();
                    break;
                    
                    case "d": case "D":
                        System.out.println("System Exit");
                        System.exit(0);
                    break;
                    
                    default:
                            System.out.println("The option need only letter A to C.");
                    break;
                }
                System.out.println("Choose Again from the system yes or no?: ");
                choice = sc.next();
                
            }while(choice.equals("Yes") || choice.equals("yes"));
            System.out.println("Thank you and Good bye, Allevo!.");
            System.exit(0);
    }
    
}
