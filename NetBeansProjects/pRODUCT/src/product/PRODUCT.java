package product;

public class PRODUCT {

    public static void main(String[] args) {
        product01 pr = new product01();
        pr. AddProduct("Lipstick", 1001, 30, 20, 10 );
        pr.ViewProduct();
        
        pr.RestockProduct(20);
        pr.ViewProduct();
        
        pr.EditProduct("Eyeliner", 1002, 20, 5, 5);
        pr.ViewProduct();
        
        pr.RestockProduct(10);
        pr.ViewProduct();
    }
    
}
