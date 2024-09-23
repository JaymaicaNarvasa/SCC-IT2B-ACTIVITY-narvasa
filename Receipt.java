package MAIN;

import java.util.*;

public class Receipt {
        Scanner input = new Scanner(System.in);
        Receipts[] rc = new Receipts[1000];
        
        Set<String>  nameSet = new HashSet<>();
        Set<String>  prodSet = new HashSet<>();
        
        String fname,product, choice, name;
        int quan, price, cash, num;
        
     public void getReciept(){
        do{
        System.out.println("--------------------------");
        System.out.println("WELCOME TO RECEIPT APP");
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
                    addReceipt();
                break;
                    
                case 2:
                    viewReceipt();
                break;
                    
                case 3:
                    editReceipt();
                break;
                    
                case 4:
                    deleteReceipt();
                break;
                    
                case 5:
                    System.out.println("Receipt App exit!");
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
     
     
     
     public String validString  (String validstring)    {
         
         String valid;
         
         while (true) {
            System.out.printf("%s: ", validstring);
                valid = input.next();
                
                   if(isValidName(valid)){
                       System.out.println("I don't think " + valid + " is valid.");
                       
                   }   else if (nameSet.contains(valid))    {
                       System.out.println("Already exist. Please enter again.");
                       
                   }   else    {
                       nameSet.add(valid);
                       break;
                   }
        }
         return valid;
     }
     
     
     public void addReceipt(){
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
                                     
                                    name = validString("Costumer Name");
                                     
                                    product = validString("Product Name");
                                            
                                    quan = getValid("Quantity");
                        
                                    price = getValid("Price");
                        
                                    cash = getValid("Cash");
                                    
                                    rc[j] = new Receipts ();
                                    rc[j].addRecepits(name, product, quan, price, cash);
                                }
                                break;
                            }
                            }else{
                                 System.out.println(" INVALID INPUT, Please try Again");
                                input.next();
                 }
             }
         }
     
     
     
     public void viewReceipt(){
         if(num == 0){
                        System.out.println("It's Empty! Add product first.");
                    }else {
                        System.out.printf("%-10s | %-10s | %-10s |%-10s | %-10s | %-10s | %-10s \n", "NAME", "PRODUCT", "QUANTITY", "PRICE", "TOTAL DUE", "CASH", "CHANGE");
                   
                        for(int j = 0; j < num; j++){
                            rc[j].viewReceipts();
                         }
                    }
     }
     
     
    public void editReceipt(){
        if (num == 0) {
            System.out.println("No records to edit. Add a receipt first.");
            return;
        }else if (num > 1000) {
            System.out.println("Maximum reached, System can only accept 1000 receipt.");
        }

        System.out.print("Enter Customer Name to Edit: ");
        String cName = input.next();

        for (int j = 0; j < num; j++) {
            if (rc[j] != null && rc[j].name.equalsIgnoreCase(cName)) {
                System.out.println("Editing Receipt for " + cName);

                product = validString("New Product Name");

                quan = getValid("New Quantity");

                price = getValid("New Price");

                cash = getValid("New Cash");

                rc[j].editReceipts(cName, product, quan, price, cash);
                System.out.println("Receipt updated successfully.");
                return;
            }
        }
        System.out.println("No receipt found with that name.");
    }
    
    
    public void deleteReceipt(){
        if (num == 0) {
            System.out.println("No records to delete. Add a receipt first.");
            return;
        }

            System.out.print("Enter Customer Name to Delete: ");
            String cName = input.next();

        for (int j = 0; j < num; j++) {
            if (rc[j] != null && rc[j].name.equalsIgnoreCase(cName)) {
                rc[j] = null; 
                System.out.println("Receipt for " + cName + " deleted successfully.");
                
                for (int a = j; a < num - 1; a++) {
                    rc[a] = rc[a + 1];
                }
                rc[num - 1] = null; 
                num--;
                return;
            }
        }
        System.out.println("No receipt found with that name.");
    }
}
