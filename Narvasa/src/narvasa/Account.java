package narvasa;

import java.util.Scanner;

public class Account {
    Scanner sc = new Scanner(System.in);
    Accounts [] ac = new Accounts[100];
    
    public void addAccount(){
        System.out.println("----------------Account Registration----------------");
        System.out.println("Input no. to register: ");
        int num = sc.nextInt();
        
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
        
        System.out.printf("|  %-10s  |  %-10s  |  %-10s  |  %-10s  |  %-10s  |  %-10s  |\n", "ID", "First Name", "Last Name", "Email", "Username", "Password");
        for(int j = 0; j < num; j++){
            ac[j].viewAccounts();
        }
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
               if(id == ac[j].id){
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
