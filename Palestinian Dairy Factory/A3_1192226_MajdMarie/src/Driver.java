// Importing required libraries

import java.util.ArrayList;
import java.util.Date;
// A test class called Driver
public class Driver {

    public static void main(String[] args) {
        // Defining a list of employees with different types so each type has an employee once with default values and other with values from the user
        ArrayList<Employee> a = new ArrayList<Employee>();
        Employee mm;
        mm=new ProductionWorker();
        // adding each employee to the employee list we created above
        a.add(mm);
        mm=new ProductionWorker("Mohammad", "243-B", new Date(102,11,6), new Address("1","1","1", 123), 2, 10, 260);
        mm.setHire(new Date(110,5,6));
        a.add(mm);
        mm=new ShiftSupervisor();
        a.add(mm);
        mm=new ShiftSupervisor("Abd-Elfattah", "111-C", new Date(101,11,6), new Address("1","1","1", 123),3000000, 300, 80, 20);
        a.add(mm);
        mm=new TeamLeader();
        a.add(mm);
        mm=new TeamLeader("Oday", "012-D", new Date(-2,11,6), new Address("1","1","1", 123),2, 30000, 1000, 550, 30, 40);
        a.add(mm);
        // Calling the method ListGreaterThanAverage that prints out the information of each employee has a salary above the average salary of all employees
        ListGreaterThanAverage(a);

    }
    // Defining the method ListGreaterThanAverage that prints out the information of each employee has a salary above the average salary of all employees
    public static void ListGreaterThanAverage(ArrayList<Employee> a){
        // Defining a variable n to calculate the number of valid working employees
        int n=a.size();
        // Defining a variable sum to find the summation of employees salaries
        double sum=0;
        // for loop to pass the employees list and find each salary of them and then add it to the sum
        for(int i=0; i<n; i++){
            // doing an instanceof to make sure that we get the exact employee salary with the right calculations
            if(a.get(i) instanceof ProductionWorker){
                // Checking if the employee's information valid ot not
                if(((ProductionWorker) a.get(i)).validProductionWorker())
                    // if it's valid we add it to sum
                    sum += ((ProductionWorker) a.get(i)).getTotalSalary();
            }

            else if(a.get(i) instanceof ShiftSupervisor){
                if(((ShiftSupervisor) a.get(i)).validShiftSupervisor())
                     sum += ((ShiftSupervisor) a.get(i)).getTotalSalary();
            }
            else if(a.get(i) instanceof TeamLeader){
                if(((TeamLeader) a.get(i)).validTeamLeader())
                    sum += ((TeamLeader) a.get(i)).getTotalSalary();
            }
        }
        // defining a variable named average to calculate the average salary of all employees
        double average= sum/n;
        // for loop to print out all the valid employees that has a salary above the average salary of all valid employess
        for(int i=0; i<n; i++){
            if(a.get(i) instanceof ProductionWorker && !(a.get(i) instanceof TeamLeader)) {
                if (((ProductionWorker) a.get(i)).getTotalSalary() >= average)
                    System.out.println("Production Worker Employee: {\n" + ((ProductionWorker) a.get(i)).toString());
            }
            else if(a.get(i) instanceof ShiftSupervisor) {
                    if (((ShiftSupervisor) a.get(i)).getTotalSalary() >= average)
                        System.out.println("Shift Supervisor Employee : {\n" + ((ShiftSupervisor) a.get(i)).toString());
                }
            else if(a.get(i) instanceof TeamLeader){
                    if(( (TeamLeader)a.get(i)).getTotalSalary()>=average)
                        System.out.println("Team Leader Employee {\n"+ ( (TeamLeader)a.get(i)).toString());
                }

        }
    }
}
