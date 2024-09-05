package narvasa;

public class Loans {
    String id , name  ;
    int income, loan, cscore , edebt;
    
    public void addLoans(int loans, int Income, String Id, String Name, int Cscore , int Edebt){
        this.loan = loans;
        this.income = Income;
        this.id = Id;
        this.name = Name;
        this.cscore = Cscore;
        this.edebt = Edebt;
    }
    public void viewLoans(){
        System.out.printf("----------------------------------------------------------------------------------------------");
        System.out.printf("%-10s  |  %-10s  |  %-15s  |  %-10s  |  %-10s  |  %-10s\n", "ID" , "Name" , "Loan" , "Credit Score" , "Annual Income" , "Existing Debt" );
        System.out.printf("----------------------------------------------------------------------------------------------");
        System.out.printf(" %-10s  |  %-10s  |  %-15d  |  %-10d  |  %-10d  |  %-10d", this.id, this.name, this.loan, this.cscore, this.income ,this.edebt);
        System.out.printf("----------------------------------------------------------------------------------------------");
    }
}
