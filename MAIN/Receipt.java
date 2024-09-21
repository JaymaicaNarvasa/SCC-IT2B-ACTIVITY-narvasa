package MAIN;

import java.util.*;

public class Receipt {
        Scanner input = new Scanner(System.in);
        Receipts rc = new Receipts();
        Set<String>  nameSet = new HashSet<>();
        Set<String>  prodSet = new HashSet<>();
        String fname,product, choice, name;
        int quan, price, cash, num;
        
     public void getReciept(){
        do{
        System.out.println("--------------------------");
        System.out.println("WELCOME TO PRODUCT APP");
        System.out.println("--------------------------");
        System.out.println("1. ADD");
        System.out.println("2. VIEW");
        System.out.println("3. EDIT");
        System.out.println("4. DELETE");
        System.out.println("5. EXIT");
        System.out.println("--------------------------");
        
        System.out.print("Enter Option: ");
        int option = input.nextInt();

        while(option > 5){
            System.out.print("Invalid Selection, Try Again: ");
            option = input.nextInt();
        }
            
            switch(option){
                case 1:
                    while (true){
                        
                        System.out.printf("Enter no. of Employee: ");
                            if (input.hasNextInt()){
                                 num = input.nextInt();
                     
                            if (num > 100){
                                System.out.println("You can only enter 100 employee");
                  
                            }else {  
                                
                                for (int j = 0; j < num; j++){
                                     System.out.println("-------------------------------------------");
                                     System.out.println("Details of employee no. " + (j+1) + ":");
                            
                                     while(true){
                                        System.out.printf("Customer Name: ");
                                            name = input.next();
                                            
                                                if(isValidName(name)){
                                                    System.out.println("I don't think " + name + " is valid.");
                                                }   else if (nameSet.contains(name))    {
                                                    System.out.println("This NAME already exist. Please enter a new name.");
                                                }   else    {
                                                    nameSet.add(name);
                                 break;
                                }
                            }
                     
                                    while(true){
                                        System.out.printf("Product Name: ");
                                            product = input.next();
                                            
                                                if(isValidName(product)){
                                                    System.out.println("I don't think " + product + " is valid.");
                                                }   else if (prodSet.contains(product))    {
                                                    System.out.println("This NAME already exist. Please enter a new name.");
                                                }   else    {
                                                    prodSet.add(product);
                                 break;
                                }
                            }
                                    quan = getValid("Quantity");
                        
                                    price = getValid("Price");
                        
                                    cash = getValid("Cash");
                                }
                                break;
                            }
                            }else{
                                 System.out.println(" INVALID INPUT, Please try Again");;
                                input.next();
                            }
                            }
                    break;
                    
                case 2:
                    if(num == 0){
                        System.out.println("It's Empty! Add product first.");
                    }else {
                        System.out.printf("%-10s | %-10s | %-10s |%-10s | %-10s | %-10s | %-10s \n", "NAME", "PRODUCT", "QUANTITY", "PRICE", "TOTAL DUE", "CASH", "CHANGE");
                   
                        for(int j = 0; j < num; j++){
                            rc.addRecepits(name, product, quan, price, cash);
                         }
                    }
                    break;
                    
                case 3:
                    
                    break;
                    
                case 4:
                    
                    break;
                    
                case 5:
                    System.exit (0) ;
                    break;
                    
                default:
                    System.out.println("Invalid Option!");
                    break;
        }
        System.out.println("Still want to try(yes/no)?: ");
                choice = input.next();
                
    } while(choice.equals("yes")  || choice.equals("Yes"));
            System.out.println("Thank you for using the app.");
    }
     
     
     
     public boolean isValidName (String name){
         return name.isEmpty() || !name.matches("[a-zA-Z]+");
     }
     
     
     
     public int getValid(String validType) {
        int valid;
        while (true) {
            System.out.printf("%s: ", validType);
            if (input.hasNextInt()) {
                valid = input.nextInt();
                break;
            } else {
                System.out.println("INVALID, Please input a number.");
                input.next(); 
            }
        }
        return valid;
    }
     
}
