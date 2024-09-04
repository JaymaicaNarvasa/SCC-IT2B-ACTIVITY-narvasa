package narvasa;

import java.util.Scanner;
import java.util.ArrayList;

public class Accounts {
    ArrayList<Account> aclist = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    
    public void addAccount(){
    
    }
       public Account createAcc(){
            System.out.print("ID: ");
            String id = sc.nextLine();
            
            System.out.print("First Name: ");
            String fname = sc.next();
            
            System.out.print("Last Name: ");
            String lname = sc.next();
            
            System.out.print("Email: ");
            String email = sc.next();
            
            System.out.print("Username: ");
            String user = sc.next();
            
            String pass;
            while(true){
                System.out.println("Enter Password (must be at least 8 characters): ");
                pass = sc.next();
                if(pass.length() >= 8){
                    break;
                }else{
                    System.out.println("Invalid Password! Must be at least 8 characters.");
                }
            }
            return new Account (id , fname , lname , email , user , pass);
        }
}
