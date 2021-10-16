import java.util.Date;
// Defining the son class ShiftSupervisor that inherits from the parent Employee class
public class ShiftSupervisor extends Employee {
    // Defining the properties of the Shift Supervisor Worker employee type
    protected double mSalary, mBonusSalary;
    protected int produced, mustBeProduced;
    // Building a non argument constructor to set default values for the properties
    public ShiftSupervisor(){
        this.mSalary=100;
        this.mBonusSalary=10;
        this.produced=50;
        this.mustBeProduced=40;
    }
    // Building a constructor with argument that receive the properties values from the user
    public ShiftSupervisor(String name, String number, Date hire, Address address, double mSalary, double mBonusSalary, int produced, int mustBeProduced){
        // Receiving the employee basic information from the parent class(employee)
        super(name,number,hire,address);
        this.mSalary=mSalary;
        this.mBonusSalary=mBonusSalary;
        this.produced=produced;
        this.mustBeProduced=mustBeProduced;
    }
    // Defining Setters and Getters methods for the employee properties
    public double getmSalary() {
        return mSalary;
    }

    public void setmSalary(double mSalary) {
        this.mSalary = mSalary;
    }

    public double getmBonusSalary() {
        return mBonusSalary;
    }

    public void setmBonusSalary(double mBonusSalary) {
        this.mBonusSalary = mBonusSalary;
    }

    public int getProduced() {
        return produced;
    }

    public void setProduced(int produced) {
        this.produced = produced;
    }

    public int getMustBeProduced() {
        return mustBeProduced;
    }

    public void setMustBeProduced(int mustBeProduced) {
        this.mustBeProduced = mustBeProduced;
    }
    // Defining the method getTotalSalary that calculates the Production Shift Supervisor employee salary
    public double getTotalSalary(){
        if(produced>=mustBeProduced){
            mSalary+=mBonusSalary;
        }
        return mSalary;
    }
    // Defining a method to check if the employee is valid or not
    public boolean validShiftSupervisor(){
        if(this.mSalary<0 || this.mBonusSalary<0 || this.produced<0 || this.mustBeProduced<0|| !super.isEmpNumberValid() || !super.validEmployee())
            return false;
        return true;
    }

    // Defining a method that checks if the supervisor is excellent or not ( if the produced hours are more than 2*thehours must be produced then he is an exellent supervisor
    public boolean excellentSupervisor(){
        if(this.produced>=2*mustBeProduced)
            return true;
        else
            return false;
    }

    // Overriding toString method from the one exists in the parent class Employee
    // the method toString prints out the employee information
    @Override
    public String toString() {

        // If the Employee Shift Supervisor is valid prints it's information
        if(validShiftSupervisor()) {
            if(excellentSupervisor())
                System.out.println("Excellent Supervisor !! \n");
            return super.toString()+
                    "mSalary=" + mSalary +
                    ", mBonusSalary=" + mBonusSalary +
                    ", produced=" + produced +
                    ", mustBeProduced=" + mustBeProduced +
                    '}';
        }
        else
            return"This employee information is invalid \n";
    }
}
