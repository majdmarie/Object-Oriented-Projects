import java.util.Date;
// Defining the son class TeamLeader that inherits from the parent ProductionWorker class
public class TeamLeader extends ProductionWorker {
    // Defining the properties of the Team Leader Worker employee type
    protected double mBonus, requiredHours, attendedHours;
    // Building a non argument constructor to set default values for the properties
    public TeamLeader(){
        this.mBonus=10;
        this.requiredHours=40;
        this.attendedHours=50;
    }
    // Building a constructor with argument that receive the properties values from the user
    public TeamLeader(String name, String number, Date hire, Address address, int shift, double hourRate, double hoursNumber,double mBonus, double requiredHours, double attendedHours){
        // Receiving the employee basic information from the parent class(ProductionWorker)
        super(name,number,hire,address,shift,hourRate,hoursNumber);
        this.mBonus=mBonus;
        this.requiredHours=requiredHours;
        this.attendedHours=attendedHours;
    }
    // Overriding the method getTotalSalary that calculates the Production Worker employee salary

    // Defining Setters and Getters for the employee properties
    public double getmBonus() {
        return mBonus;
    }

    public void setmBonus(double mBonus) {
        this.mBonus = mBonus;
    }

    public double getRequiredHours() {
        return requiredHours;
    }

    public void setRequiredHours(double requiredHours) {
        this.requiredHours = requiredHours;
    }

    public double getAttendedHours() {
        return attendedHours;
    }

    public void setAttendedHours(double attendedHours) {
        this.attendedHours = attendedHours;
    }
    @Override
    public double getTotalSalary(){
        if(attendedHours>=requiredHours){
            return super.getTotalSalary()+(mBonus*(attendedHours/requiredHours));
        }
        return super.getTotalSalary();
    }
    // Defining a method to check if the employee is valid or not
    public boolean validTeamLeader(){
        if(this.mBonus<0 || this.requiredHours<0 || this.attendedHours<0|| !super.validProductionWorker()||!super.isEmpNumberValid() || !super.validEmployee())
            return false;
        return true;
    }

    // Overriding toString method from the one exists in the parent class Production Worker
    // the method toString prints out the employee information
    @Override
    public String toString() {
        // If the Employee Team Leader is valid prints it's information
        if(validTeamLeader()) {return  super.toString()+
                "\nBonus = " + getmBonus()+
                "\nRequired hours = " + getRequiredHours()+
                "\nAttended hours = " + getAttendedHours()+
                "\nEmployee Salary After bonus = " + getTotalSalary()+ "\n" +
                '}';}
        else
            return "This employee information is invalid \n";
    }
}
