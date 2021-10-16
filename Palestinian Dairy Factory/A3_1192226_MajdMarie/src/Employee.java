import java.util.Date;

// Defining the parent class Employee
public class Employee {
    // Defining common properties among all the employees
    protected String name, number;
    protected Date hire;
    protected Address address;



    // Building a non argument constructor to set default values for the properties
    public Employee(){
        this.name="Majd";
        this.number="111-A";
        hire=new Date(119, 11, 19);
        address=new Address("Jenin", "yabad", "West Bank",1111);
    }
    // Building a constructor with argument that receive the properties values from the user
    public Employee(String name, String number, Date hire, Address address){
        super();
        this.name=name;
        this.number=number;
        this.hire=hire;
        this.address=address;
    }

    // Setting setters and getters for the class variables
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getHire() {
        return hire;
    }

    public void setHire(Date hire) {
        this.hire = hire;
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // A boolean method that checks the employee number if it's valid or not
    public boolean isEmpNumberValid(){
        for(int i=0; i<3; i++) {
            if (number.charAt(i) < '0' || number.charAt(i) > '9')
                return false;
        }
        if(number.charAt(3)!='-' || number.charAt(4)<'A' || number.charAt(4)>'M')
            return false;
        return true;
    }
    // Check if the hire date is valid or not.
    public boolean validEmployee(){
        if((hire.getYear()<0 || hire.getYear()>new Date().getYear()) || hire.getMonth()<0  || hire.getMonth()>11 || hire.getDay() <0 || hire.getDay()>31)
            return false;
        return true;
    }

    // Overriding toString method from the one exists in the parent class Object
    // the method toString prints out the employee information
    @Override
    public String toString(){
        // Check if the Employee number is valid so it can print out his information
        if(isEmpNumberValid() && validEmployee()){
            return
                    "\nEmployee Name : " + getName()+
                            "\nEmployee Number: " + getNumber()+
                            "\nEmployee Hire Date: " + getHire() +
                            "\nEmployee Address: " + getAddress()+ "\n"
                    ;
        }
        // if the employee number is not valid then it prints this error message.
        return "Please enter a valid employee number. \n";
    }
}
