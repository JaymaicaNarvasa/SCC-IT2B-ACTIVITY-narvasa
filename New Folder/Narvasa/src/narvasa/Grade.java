package narvasa;

import java.util.Scanner;

public class Grade {
    
    public void getGrades(){
        Scanner sc = new Scanner(System.in);
        
        Grades[]  gr = new Grades [100];
        
        System.out.printf("Enter no. of students: ");
        int num = sc.nextInt();
        
        for(int j = 0; j < num; j++){
            System.out.println("Enter details of student " + (j+1) + ":");
            System.out.printf("Enter ID:");
            int id = sc.nextInt();
            System.out.printf("Enter Name: ");
            String name = sc.next();
            System.out.printf("Enter Prelim: ");
            double pre = sc.nextDouble();
            System.out.printf("Enter Midterm: ");
            double mid = sc.nextDouble();
            System.out.printf("Enter PreFinal: ");
            double pf= sc.nextDouble();
            System.out.printf("Enter Final: ");
            double f= sc.nextDouble();
            
            gr[j] = new Grades();
            gr[j].addGrades(name, id, pre, mid, pf, f);
    }
        for(int j = 0; j < num; j++){
            gr[j].viewGrades();
        }
    }
}
