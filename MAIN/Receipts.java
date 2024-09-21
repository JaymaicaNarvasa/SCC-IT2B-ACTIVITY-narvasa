package MAIN;

public class Receipts {
    String name,    prod;
    int quan, price, cash;
    
    public void addRecepits(String Name, String Prod, int Quan, int Price, int Cash){
        this.cash = Cash;
        this.name = Name;
        this.prod = Prod;
        this.price = Price;
        this.quan = Quan;
    }
    
    
    public void viewReceipts(){
          int tdue = quan * price;
          int change = tdue - cash;
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s | %-10s | %-10d | %-10d | %-10d | %-10d | %-10d\n", this.name,this.prod, this.quan, this.price, tdue, this.cash, change);  
    }
}
