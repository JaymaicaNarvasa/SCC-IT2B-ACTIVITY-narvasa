package narvasa;

import java.util.Scanner;

public class Reciept {
    public void getReciept(){
        Scanner input = new Scanner(System.in);
        String fname,product;
        int quan, price, cash;
       
        System.out.print("Customer Name:");
        fname = input.nextLine();
        System.out.print("Product Name: ");
        product = input.nextLine();
        System.out.print("Quantity: ");
        quan = input.nextInt();
        System.out.print("Price: ");
        price = input.nextInt();
        System.out.print("Cash: ");
        cash = input.nextInt();
        
        System.out.println("-------------------------------");
        System.out.println("    RECIEPT        ");
        System.out.println("-------------------------------");
        System.out.println("Name: "+fname);
        System.out.println("Item: "+product);
        System.out.println("quantity: "+quan);
        System.out.println("-------------------------------");
        System.out.println("Total Due: "+(quan*price)); 
        System.out.println("Cash:"+cash);
        System.out.println("-------------------------------");
        System.out.println("Change: "+((quan*price)-cash));
        
        
    }
}
