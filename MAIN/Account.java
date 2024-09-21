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
                break;
                
            case 2:
                    if(num == 0){
                        System.out.println("It's Empty! Add account first.");
                    }   else     {
                        System.out.printf("|  %-10s  |  %-10s  |  %-10s  |  %-10s  |  %-10s  |  %-10s  |\n", "ID", "First Name", "Last Name", "Email", "Username", "Password");
                   
                            for(int j = 0; j < num; j++){
                                ac[j].viewAccounts();
                            }
                     }
                break;
                
            case 3:
                if (num == 0) {
                            System.out.println("No account registration to edit.");
                }    else   {
                            System.out.print("Enter ID of the account to edit: ");
                            String idToEdit = sc.next();

                            boolean found = false;

            for (Accounts ac1 : ac) {
                if (ac1 != null && ac1.id.equals(idToEdit)) {
                    found = true;
                    
                    System.out.println("Editing account for ID: " + idToEdit);
                    System.out.printf("Current First Name: %s\n", ac1.fname);
                    System.out.printf("Current Last Name: %s\n", ac1.lname);
                    System.out.printf("Current Email: %s\n", ac1.email);
                    System.out.printf("Current Username: %s\n", ac1.user);
                    System.out.print("New First Name (leave blank for no change): ");
                    String newFname = sc.nextLine();
                    
                    if (!newFname.isEmpty()) {
                        ac1.fname = newFname;
                    }
                    
                    System.out.print("New Last Name (leave blank for no change): "); 
                    String newLname = sc.nextLine();
                    if (!newLname.isEmpty()) {
                        ac1.lname = newLname; 
                    }
                    
                    System.out.print("New Email (leave blank for no change): ");
                    String newEmail = sc.nextLine();
                    if (!newEmail.isEmpty()) {
                        ac1.email = newEmail; 
                    }
                    
                    System.out.print("New Username (leave blank for no change): ");
                    String newUser = sc.nextLine();
                    if (!newUser.isEmpty()) {
                        ac1.user = newUser; 
                    }
                    
                    System.out.println("Enter new password (leave blank for no change): ");
                    String newPass = sc.nextLine();
                    
                    if (!newPass.isEmpty()) {
                        while (!passVerify(newPass)) {
                            System.out.println("Invalid password. Enter again (leave blank for no change): ");
                            newPass = sc.nextLine();
                        }       if (!newPass.isEmpty()) {
                            ac1.pass = newPass;
                        }
                    }
                    
                    System.out.println("Account updated successfully!");
                    break; 
                }
            }

                if (!found) {
                     System.out.println("No account found with ID: " + idToEdit);
             }
                }
                break;
                
            case 4:
                    if(num == 0){
                        System.out.println("It's Empty! Add account first.");
                    }   else     {
                        System.out.print("Enter ID of the account to delete: ");
                    String idToDelete = sc.next();

                    boolean found = false;

                 for (int i = 0; i < ac.length; i++) {
                    if (ac[i] != null && ac[i].id.equals(idToDelete)) { 
                     found = true;
                     ac[i] = null; 
                     
                    System.out.println("Account with ID " + idToDelete + " has been deleted.");
            
            for (int j = i; j < ac.length - 1; j++) {
                ac[j] = ac[j + 1];
            }
            ac[ac.length - 1] = null; 
            break; 
             }
             }
                if (!found) {
                    System.out.println("No account found with ID: " + idToDelete);
                    }
            }
                break;
                
            case 5:
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
}

