import java.util.Date;
// Defining the son class ProductionWorker that inherits from the parent Employee class
public class ProductionWorker extends Employee {
    // Defining the properties of the Production Worker employee type
    protected int shift;
    protected double hourRate, hoursNumber;
    // Building a non argument constructor to set default values for the properties
    public ProductionWorker(){
        this.shift=1;
        this.hourRate=10;
        this.hoursNumber=30;
    }
    // Building a constructor with argument that receive the properties values from the user
    public ProductionWorker(String name, String number, Date hire, Address address, int shift, double hourRate, double hoursNumber){
        // Receiving the employee basic information from the parent class(employee)
        super(name,number,hire,address);
        this.shift=shift;
        this.hourRate=hourRate;
        this.hoursNumber=hoursNumber;
    }

    // Setting setters and getters for the class variables
    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public double getHourRate() {
        return hourRate;
    }

    public void setHourRate(double hourRate) {
        this.hourRate = hourRate;
    }

    public double getHoursNumber() {
        return hoursNumber;
    }

    public void setHoursNumber(double hoursNumber) {
        this.hoursNumber = hoursNumber;
    }


    // Defining the method getTotalSalary that calculates the Production Worker employee salary
    public double getTotalSalary(){
        if(shift==1)
            hoursNumber+=0.25*(hoursNumber-8);
        else if(shift==2)
            hoursNumber+=0.5*(hoursNumber-7);

        return 26*hourRate*hoursNumber;
    }

    // Defining a method to check if the employee is valid or not
    public boolean validProductionWorker(){
        if((shift!=1 && shift!=2 ) || hoursNumber<0 || hourRate<0 || (shift==1&&hoursNumber<8) || (shift==2&&hoursNumber<7)|| !super.isEmpNumberValid() || !super.validEmployee())
            return false;
        return true;
    }

    // Overriding toString method from the one exists in the parent class Employee
    // the method toString prints out the employee information
    @Override
    public String toString() {

        // If the Employee Production Worker is valid prints it's information
        if(validProductionWorker())return super.toString()+
                "shift=" + shift +
                ", hourRate=" + hourRate +
                ", hoursNumber=" + hoursNumber +
                '}';
        else
            return "This employee information is invalid \n";
    }
}
