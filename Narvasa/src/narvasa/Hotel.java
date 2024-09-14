package narvasa;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Hotel {
    Scanner sc = new Scanner(System.in);
    Hotels[] hl= new Hotels[50];
    Set<String> nameSet = new HashSet<>();
           
        int num;
        String name;
    public void addHotel(){
             while(true){
                System.out.printf("Enter no. of Bookings: ");
                if (sc.hasNextInt()){
                     num = sc.nextInt();
                     break;
                }else if (num > 50){
                    System.out.println("You can only booked 50 rooms");
                }else{
                      System.out.println(" INVALID INPUT, Please try again");
                      sc.next();
                    }
             }
        
    for(int j = 0; j < num; j++){
        System.out.println("Details of booking no. " + (j + 1) + ":");
        
        String format = String.format("SCC-%03d", (j + 1));
        System.out.printf("ID: %s\n", format);
        
        while(true){
             System.out.printf("Name: ");
              name = sc.next();
                    if(isValidName(name)){
                        System.out.println("I don't think " + name + " is valid.");
                    }else if(nameSet.contains(name)){
                        System.out.println("This NAME already exist. Please enter a new name.");
                    }else{
                        nameSet.add(name);
                     break;
                }
             }
        
        String rtype;
        while (true) {
            System.out.println("Room Type (Single, Double, Suite): ");
            rtype = sc.next();
            if (isValidRType(rtype)) {
                break;
            } else {
                System.out.println("Invalid room type. Please enter 'Single', 'Double', or 'Suite'.");
            }
        }
        
         String cin;
        while (true) {
            System.out.println("Check-in-Date (YYYY-MM-DD): ");
            cin = sc.next();
            if (isValidDate(cin)) {
                break;
            } else {
                System.out.println("Invalid date format. Please enter again.");
            }
        }
        
        String cout;
        while (true) {
            System.out.println("Check-out-Date (YYYY-MM-DD): ");
            cout = sc.next();
            if (isValidDate(cout)) {
                break;
            } else {
                System.out.println("Invalid date format. Please enter again.");
            }
        }
        
         String pstats, status;
        while (true) {
            System.out.println("Payment Status (Paid/Not Paid): ");
            pstats = sc.next();
            if (pstats.equalsIgnoreCase("Paid")) {
                status = "Confirmed";
                break;
            } else if (pstats.equalsIgnoreCase("Not Paid")) {
                status = "Pending";
                break;
            } else {
                System.out.println("Invalid payment status. Please enter 'Paid' or 'Not Paid'.");
            }
        }
        
        
        hl[j] = new Hotels();
        hl[j].getHotels(name, rtype, pstats, status, format, cout, cin);
    }
        System.out.printf("|  %-10s  |  %-10s  |  %-10s  |  %-10s  |  %-10s  |  %-10s  |  %-10s  |", "Booking ID", "Name", "Room Type", "Check-in-Date", "Check-out-Date", "Payment Status", "Status");
        
        for(int j = 0; j < num; j++){
            hl[j].viewHotel();
        }
    }
    public boolean isValidName (String name){
         return name.isEmpty() || !name.matches("[a-zA-Z]+");
     }
    public boolean isValidRType(String rtype) {
    Set<String> validRTypes = new HashSet<>(Arrays.asList("Single", "Double", "Suite"));
    return validRTypes.contains(rtype);
    }
    public boolean isValidDate(String date) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    try {
        sdf.parse(date);
        return true;
    } catch (ParseException e) {
        return false;
    }
    }
}
