package MAIN;

public class Accounts {
    String id, fname, lname, email, user, pass;
        
    public void getAccounts(String Id, String Fname, String Lname, String Email, String User, String Pass){
        this.id = Id;
        this.lname = Lname;
        this.fname = Fname;
        this.email = Email;
        this.user = User;
        this.pass = Pass;
    }
    
    
    public void viewAccounts(){
        System.out.printf("-------------------------------------------------------------------------------");
        System.out.printf("|  %-10s  |  %-10s  |  %-10s  |  %-10s  |  %-10s  |  %-10s  |\n" + this.id, this.fname, this.lname, this.email, this.user, this.pass);
    }
    
    
    public void editAcc( ){
        
    }
}

