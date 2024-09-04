package product;

public class product01 {
    String name;
    int id,sold ,stock;
    double price;
   
public void AddProduct(String sname, int sid, int sstocks, int ssold, double spr){
    this.name = sname;
    this.id = sid;
    this.stock = sstocks;
    this.sold = ssold;
    this.price = spr;
}
public void ViewProduct(){
    System.out.println("Product Id:" + this.id);
    System.out.println("Product Name: " + this.name);
    System.out.println("Stocks: " + this.stock);
    System.out.println("Sold: " + this.sold);
    System.out.println("Price: " + this.price);
    System.out.println("------------------------------");
    
    double tprofit = this.price * this.sold;
    System.out.println("Total Profit: " + tprofit );
    
    if(this.stock == 0){
        System.out.println("Status: Out of Stock");
    }
    else{
        System.out.println("Status: Available");
    }
     
    double eprofit = this.price * this.stock;
    System.out.println("Total Expected Profit: " + eprofit);
    System.out.println("------------------------------");
}
public void EditProduct(String nName, int nid, int nstocks, int nsold, double nPrice){
    System.out.println("Edited Product");
     this.name = nName;
    this.id = nid;
    this.stock = nstocks;
    this.sold =nsold;
    this.price = nPrice;
    
}
public void RestockProduct(int rStock){
    System.out.println("You added " + rStock + " stock.");
    this.stock += rStock;
}
}
