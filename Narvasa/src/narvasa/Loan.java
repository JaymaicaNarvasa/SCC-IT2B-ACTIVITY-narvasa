package narvasa;

import java.util.Scanner;

public class Loan {
    Scanner sc = new Scanner(System.in);
    int cscore;
   public void addLoans (){
       while(true){
                System.out.printf("Enter your credit score (0-850): ");
                if (sc.hasNextInt()){
                     cscore = sc.nextInt();
                     
                     if (cscore > 850 && cscore < 0){
                    System.out.println("Again, please input only 0-850");
                  
                     }else {
                         break;
                     }
                }else{
                      System.out.println(" INVALID INPUT, Please try Again");;
                      sc.next();
                    }
             }

        double income = getLoan("Enter your annual income (in PHP)");

        double edebt = getLoan("Enter your existing debt (in PHP)");
        
        boolean Approved = true;
        
         if (cscore < 700) {
            Approved = false;
            System.out.println("Loan rejected: Credit score is less than 700.");
        }

        if (income < 300000) {
            Approved = false;
            System.out.println("Loan rejected: Annual income is less than 300,000 PHP.");
        }

        if (edebt > (0.5 * income)) {
            Approved = false;
            System.out.println("Loan rejected: Existing debt exceeds 50% of the annual income.");
        }
       
        if (Approved) {
            System.out.println("Loan approved!");
        } else {
            System.out.println("Loan not approved.");
        }
        Loans ls = new Loans();
        ls.getLoans(cscore, income, edebt);
        sc.close();
   }
   private double getLoan(String loanType) {
        double loan;
        while (true) {
            System.out.printf("%s: ", loanType);
            if (sc.hasNextDouble()) {
                loan = sc.nextDouble();
                break;
            } else {
                System.out.println("INVALID, Please input a number.");
                sc.next(); 
            }
        }   
        return loan;
    }
}
