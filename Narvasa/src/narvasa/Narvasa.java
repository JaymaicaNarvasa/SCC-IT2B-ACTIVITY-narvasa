package narvasa;

import java.util.Scanner;

public class Narvasa {
    public static void main(String[] args) {
            Scanner sc = new Scanner (System.in);
           String contchoice;
        System.out.println("     WELCOME TO MY SYSTEM    ");
        do{
        System.out.println("------------------------------");
        System.out.println("Choose the following Option ");
        System.out.println("a. Grade");
        System.out.println("b. Product");
        System.out.println("c. Salary");
        System.out.println("d. Account");
        System.out.println("e. Loan");
        System.out.println("f. Reciept");
        System.out.println("g. Hotel Booking Management");
        System.out.println("------------------------------");
        
        System.out.printf("Enter Choice: ");
        String choice = sc.nextLine();
        
      switch(choice){
          case "a": case "A":
              Grade gr = new Grade();
              gr.addGrade();
              break;
          case "b": case "B":
              System.out.println("      Note: Product is STATIC either" 
                      + "\n 1. AddPrudtct" 
                      + "\n 2. EditProduct");
              System.out.printf("Choose option:");
              int cho = sc.nextInt();
              
              switch (cho){
                  case 1:
                       Product pr = new Product();
                       pr. AddProduct("Lipstick", 1001, 30, 20, 10 );
                       pr.ViewProduct();
                       
                       pr.RestockProduct(20);
                       pr.ViewProduct();
                      break;
                  case 2:
                      Product prs = new Product();
                      prs.EditProduct("Eyeliner", 1002, 20, 5, 5);
                      prs.ViewProduct();
        
                      prs.RestockProduct(10);
                      prs.ViewProduct();
                      break;
                  default:
                      System.out.println("  OPTION ERROR!");
              }
              break;
          case "c": case "C":
              Salary sl = new Salary();
              sl.addSalaries();
              break;
          case "d": case "D":
              Account ac = new Account();
              ac.addAccount();
              break;
          case "e": case "E":
              Loan ln= new Loan();
              ln.addLoans();
              break;
          case "f": case "F":
              FristCodeinIT2B reciept = new FristCodeinIT2B();
              reciept.getReciept();
              break;
          case "g": case "G":
              Hotel hl = new Hotel();
              hl.addHotel();
              break;
          default:
              System.out.println("Invalid Input");
              break;
      }
       System.out.print("Do you want to continue? (yes/no): ");
            contchoice = sc.nextLine();
            
     } while (contchoice.equalsIgnoreCase("yes"));

        sc.close();
        System.out.println("Thank you for using the system!");
   }
}
