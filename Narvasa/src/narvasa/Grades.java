package narvasa;

public class Grades {
    String name, id, rem;
    double p, m, pf, f, ave;
    
    public void getGrades(String sname, String sid, double sp, double sm, double spf, double sf){
        this.name = sname;
        this.id = sid;
        this.f = sf;
        this.pf = spf;
        this.m = sm;
        this.p = sp;
            double total = this.p + this.m + this.pf + this.f;
            ave = total / 4;
    }
    
    public void viewGrades(){
        rem = (ave > 3.0) ? "Failed": "Passed";
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|  %-10s  |  %-10s  |  %-10.2f  |  %-10.2f  |  %-10.2f  |  %-10.2f  |  %-10.2f  |  %-10s  |\n", this.id, this.name, this.p, this.m, this.pf, this.f, ave, rem);
    }
}
