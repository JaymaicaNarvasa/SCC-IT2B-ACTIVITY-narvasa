package narvasa;

public class Account {
    String id, fname, lname, email, user, pass;

    Account(String id, String fname, String lname, String email, String user, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void Account(String Id, String Fname, String Lname, String Email, String User, String Pass){
        this.id = Id;
        this.lname = Lname;
        this.fname = Fname;
        this.email = Email;
        this.user = User;
        this.pass = Pass;
    }
    
    public String getID(){
        return id;
    }
    public String getFname(){
        return fname;
    }
    public String getLname(){
        return lname;
    }
    public String getEmail(){
        return email;
    }
    public String getUser(){
        return user;
    }
    public String getPass(){
        return pass;
    }
    
    public String getString(){
        return "ID: " + id + "First Name: " + fname + "Last Name: " + lname + "Email: " + email 
                + "Username: " + user;
    }
}
