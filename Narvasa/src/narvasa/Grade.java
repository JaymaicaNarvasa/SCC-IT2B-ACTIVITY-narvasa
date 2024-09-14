package narvasa;

import java.util.*;

public class Grade {
    Scanner sc = new Scanner(System.in);
    Grades[] gr = new Grades[100];
    Set<String>  nameSet = new HashSet<>();
    
         int num, pass = 0, fail = 0; String id, name; double ave = 0;
     public void addGrade(){
          while(true){
                System.out.printf("Enter no. of Students: ");
                if (sc.hasNextInt()){
                     num = sc.nextInt();
                     
                     if (num > 100){
                    System.out.println("You can only enter 100 students");
                  
                     }else {
                         break;
                     }
                }else{
                      System.out.println(" INVALID INPUT, Please try Again");;
                      sc.next();
                    }
             }
         
         for(int j = 0; j < num; j++){
             System.out.println("-------------------------------------");
             System.out.println("Student Details of number " +(j+1)+ ":");
             
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
                        double pre = getGrade("Prelim");
                        double mid = getGrade("Midterm");
                        double prefi = getGrade("PreFinal");
                        double fi = getGrade("Final");  
                        
             gr[j] = new Grades();
             gr[j].getGrades(name, format, pre, mid , prefi, fi);
             ave += gr[j].ave;
                            if(gr[j].ave > 3.0){
                                pass++;
                            }else{
                                fail++;
                            }
         }
         System.out.printf("|  %-10s  |  %-10s  |  %-10s  |  %-10s  |  %-10s  |  %-10s  |  %-10s  |  %-10s  |\n", "   ID", "  Name", "Prelim", "Midterm", "Prefinal", "Final", "Average", "Status");
        
                  for(int j = 0; j < num; j++){
                      gr[j].viewGrades();
                  }
            System.out.println("No. of Students: " + num);
            System.out.println("Class Average: " + ave);
            System.out.println("No. of Failed: "+ fail);
            System.out.println("No. of Passed: "+ pass);
     }
     public boolean isValidName (String name){
         return name.isEmpty() || !name.matches("[a-zA-Z]+");
     }
       private double getGrade(String grType) {
        double grade;
        while (true) {
            System.out.printf("%s: ", grType);
            if (sc.hasNextDouble()) {
                grade = sc.nextDouble();
                break;
            } else {
                System.out.println("INVALID, Please input a number.");
                sc.next(); 
            }
        }   
        return grade;
    }
}
