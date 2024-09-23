package MAIN;

import java.util.Scanner;

public class Account {
    Scanner sc = new Scanner(System.in);
    Accounts [] ac = new Accounts[100];
    
    String choice;
    int num;
    public void addAccount(){
    do {
        System.out.println("--------------------------");
        System.out.println("ACCOUNT MANAGEMENT MENU");
        System.out.println("--------------------------");
        System.out.println("1. ADD ACCOUNT");
        System.out.println("2. VIEW ACCOUNTS");
        System.out.println("3. EDIT ACCOUNT");
        System.out.println("4. DELETE ACCOUNT");
        System.out.println("5. EXIT");
        System.out.println("--------------------------");

        System.out.print("Enter Option: ");
        int option = sc.nextInt();

        while(option > 5){
            System.out.print("Invalid Selection, Try Again: ");
            option = sc.nextInt();
        }
        
        switch(option){
            case 1:
                Add();
            break;
                
            case 2:
                View();    
            break;
                
            case 3:
                Edit();
            break;
                
            case 4:
                Delete();
            break;
                
            case 5:
                System.out.println("Account App exit!");
                System.exit (0) ;
                break;
                
            default:
                System.out.println("Invalid Option!");
                break;
        }
        
        System.out.println("Still want to try(yes/no)?: ");
                choice = sc.next();
    } while(choice.equals("yes")  || choice.equals("Yes"));
            System.out.println("Thank you for using the app.");
}
    
    
    
    public boolean passVerify(String pass) {
            if(!(pass.length() > 8)){
                System.out.println("Must be above 8 characters.");
            return false;
            }
            if(pass.equals("admin") || pass.equals("1234") || pass.equals(" ")){
                System.out.println("Must not have common password like 'admin', '1234' and blanck space '   '.");
            return false;
            }
            
            boolean UpperCase = false;
            boolean LowerCase = false;
            boolean Digit = false;
            boolean Specialchar = false;
            
            for(char c: pass.toCharArray()){
                if(Character.isLowerCase(c)){
                    LowerCase = true;
                }
                else if(Character.isUpperCase(c)){
                    UpperCase = true;
                }
                else if(Character.isDigit(c)){
                    Digit = true;
                }else if(Character.isLetterOrDigit(c)){
                    Specialchar = true;
                }
            }
            
            if(!(UpperCase && LowerCase)){
                System.out.println("Must have 1 small and 1 capital letter");
                return false;
            }else if (!Digit) {
                System.out.println("Must have a number");
                return false;
            }else if (!Specialchar){
                System.out.println("Must have a special character");
                return false;
            }
            return true;
        }
       
    
    
    
       public boolean duplicateVerify(String id , String email, String user, int index){
           for(int j = 0; j < index; j++){
               if(id.equals(ac[j].id)){
                   System.out.println("System won't accept duplicate ID");
                   return true;
               }else if(email.contains(ac[j].email)){
                   System.out.println("System won't accept duplicate Email");
                   return true;
               }else if(user.contains(ac[j].user)){
                   System.out.println("System won't accept duplicate Username");
                   return true;
               }
           }
           return false;
       }
       
       
       
       public void Add(){
                System.out.println("Input no. to register: ");
                num = sc.nextInt();
        
                    for(int j = 0; j < num; j++){
                        System.out.println("------------------------------");
                        System.out.println("Details of no." + (j+1) + ":");
                        
                        System.out.printf("ID: ");
                        String id = sc.next();
                        
                        System.out.printf("First Name: ");
                        String fname = sc.next();
                       
                        System.out.printf("Last Name: ");
                        String lname = sc.next();
                        
                        System.out.printf("Email: ");
                        String email = sc.next();
                        
                        System.out.printf("Username: ");
                        String user = sc.next();
            
            System.out.println("Password criteria:"
                    + "1. Must be 8 characters above\n"
                    + "2. Must contain 1 upper and 1 lower case\n"
                    + "3. Must contain at least 1 special chacracter\n"
                    + "4. Must be a number\n"
                    + "5. Must not have a common password names like 'admin', '  ' and '1234'");
            
            System.out.printf("Password: ");
            String pass = sc.next();
            
            while(!(passVerify(pass))){
                System.out.println("Input Password again: ");
                pass = sc.next();
            }
            
            if(duplicateVerify(id, email, user, j)){
                j--;
                continue;
            }
            ac[j] = new Accounts();
            ac[j].getAccounts(id, fname, lname, email, user, pass);
        }
       }
       
       
       public void View(){
           if(num == 0){
                        System.out.println("It's Empty! Add account first.");
                    }   else     {
                        System.out.printf("|  %-10s  |  %-10s  |  %-10s  |  %-10s  |  %-10s  |  %-10s  |\n", "ID", "First Name", "Last Name", "Email", "Username", "Password");
                   
                            for(int j = 0; j < num; j++){
                                ac[j].viewAccounts();
                            }
                     }
       }
       
       
       
     public void Edit(){
         if (num == 0) {
                            System.out.println("No account registration to edit.");
                }    else   {
                            System.out.print("Enter ID of the account to edit: ");
                            String idEdit = sc.next();

                            boolean found = false;

            for (Accounts ac1 : ac) {
                if (ac1 != null && ac1.id.equals(idEdit)) {
                    found = true;
                    
                    System.out.println("Editing account for ID: " + idEdit);
                    System.out.printf("Current First Name: %s\n", ac1.fname);
                    System.out.printf("Current Last Name: %s\n", ac1.lname);
                    System.out.printf("Current Email: %s\n", ac1.email);
                    System.out.printf("Current Username: %s\n", ac1.user);
                    System.out.print("New First Name: ");
                    String nFname = sc.next();
                    
                    if (!nFname.isEmpty()) {
                        ac1.fname = nFname;
                    }
                    
                    System.out.print("New Last Name: "); 
                    String nLname = sc.next();
                    
                    if (!nLname.isEmpty()) {
                        ac1.lname = nLname; 
                    }
                    
                    System.out.print("New Email: ");
                    String nEmail = sc.next();
                    
                    if (!nEmail.isEmpty()) {
                        ac1.email = nEmail; 
                    }
                    
                    System.out.print("New Username: ");
                    String nUser = sc.next();
                    
                    if (!nUser.isEmpty()) {
                        ac1.user = nUser; 
                    }
                    
                    System.out.println("Enter new password: ");
                    String nPass = sc.next();
                    
                    if (!nPass.isEmpty()) {
                        while (!passVerify(nPass)) {
                            System.out.println("Invalid password. Enter again: ");
                            nPass = sc.next();
                            
                        }       if (!nPass.isEmpty()) {
                            ac1.pass = nPass;
                        }
                    }
                    
                    System.out.println("Account UPDATED successfully!");
                    break; 
                }
            }

                if (!found) {
                     System.out.println("No account found with ID: " + idEdit);
             }
                }
     }
     
     
     
     public void Delete(){
         
                    if(num == 0){
                        System.out.println("It's Empty! Add account first.");
                    }   else     {
                        System.out.print("Enter ID of the account to delete: ");
                        String idDelete = sc.next();

                    boolean found = false;

                 for (int i = 0; i < ac.length; i++) {
                    if (ac[i] != null && ac[i].id.equals(idDelete)) { 
                     found = true;
                     ac[i] = null; 
                     
                    System.out.println("Account with ID " + idDelete + " has been deleted.");
            
            for (int j = i; j < ac.length - 1; j++) {
                ac[j] = ac[j + 1];
            }
            ac[ac.length - 1] = null; 
            break; 
             }
             }
                if (!found) {
                    System.out.println("No account found with ID: " + idDelete);
                    }
            }
     }
}

