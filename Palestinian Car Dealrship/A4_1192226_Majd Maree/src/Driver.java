// importing required libraries to use them in the code
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.PrintWriter;
import java.io.File;
// Creating the class Drive to test the code
public class Driver {
    // the main method
    public static void main(String[] args){
        // setting up try and catch to avoid getting errors ( instead we get exceptions )
        try {
            // creating a scanner variable to read from the user
            Scanner in = new Scanner(System.in);
            // showing the program instructions to the user so he can know what to choose
            System.out.println("Please enter the process number that you want to proceed: \n1. Read the data about objects from the file “inputdata.txt” and store them in Arraylist.\n" +
                    "2. Set prices of petroleum.\n" +
                    "3. Print sorted order Vehicles in an ascending order based on costFor100Km.\n" +
                    "4. Print sorted order Vehicles in an ascending order based on owner name .\n" +
                    "5. Print sorted order Vehicles in an descending order based on vehicle brand.\n" +
                    "6. Clone Vehicle without owner. (Ask user to choice one object for cloning from Arraylist, after Listing them to user )\n" +
                    "7. Turn air-condition on\n" +
                    "8. Write Output on the “output.txt” file after sort them.\n" +
                    "9. Calculate the average cost for 100km for all vehicles.\n"+
                    "10. Print saving vehicles (Vehicles which their fuel consumption is below the average).\n"+
                    "11. Print the percentage of family vans and their owners names.\n"+
                    "12. Listing renting that are available to be rented (their model numbers starts with 32). \n"+
                    "13. Exit from System");

            // creating our arraylist of vehicles
            ArrayList<Vehicles>ob = new ArrayList<>();
            // creating a flag called exist to check if we stored the data or not
            boolean exist = false;
            // creating the variable x to read the user choice
            int x = in.nextInt();
            // creating a loop so the user can keep choosing processes until he types 9 and exists the program
            while (x != 13) {
                // an if statement to check if the user chose any process before storing the vehicles data
                if(x>2 && x<13){
                    // checking if the data is already stored or not, if yes the program continues, if not the program tells the user to store the data first
                    if(!exist){
                        System.out.println("You have to store the input data before you make any progress (Enter 1 to do that ).");
                        x= in.nextInt();
                        continue;
                    }
                }
                // switch case for the menu
                // this switch case calls the method the user chooses
                switch (x) {
                    case 1: ob=store(ob);
                            exist=true;
                            break;
                    case 2: setPrices(); break;
                    case 3: sortCost(ob); break;
                    case 4: sortName(ob); break;
                    case 5: sortBrand(ob); break;
                    case 6: cloneO(ob); break;
                    case 7: setAir(ob); break;
                    case 8: fileWrite(ob); break;
                    case 9: System.out.println("The average cost is: "+ avgCost(ob)); break;
                    case 10: savingVehicles(ob);break;
                    case 11: famVan(ob); break;
                    case 12: rentedCars(ob); break;
                    // if the user chooses any number that is not from the menu an illegalEception shows.
                    default:
                        throw new IllegalStateException("Unexpected value: " + x);
                }
                // Repeating the menu process again
                System.out.println("Please enter the process number that you want to proceed: \n1. Read the data about objects from the file “inputdata.txt” and store them in Arraylist.\n" +
                        "2. Set prices of petroleum.\n" +
                        "3. Print sorted order Vehicles in an ascending order based on costFor100Km.\n" +
                        "4. Print sorted order Vehicles in an ascending order based on owner name .\n" +
                        "5. Print sorted order Vehicles in an descending order based on vehicle brand.\n" +
                        "6. Clone Vehicle without owner. (Ask user to choice one object for cloning from Arraylist, after Listing them to user )\n" +
                        "7. Turn air-condition on\n" +
                        "8. Write Output on the “output.txt” file after sort them.\n" +
                        "9. Calculate the average cost for 100km for all vehicles and then print it.\n"+
                        "10. Print saving vehicles (Vehicles which their fuel consumption is below the average).\n"+
                        "11. Print the percentage of family vans and their owners names.\n"+
                        "12. Listing renting that are available to be rented (their model numbers starts with 32) \n"+
                        "13. Exit from System");
                x = in.nextInt();
            }
            // end of while loop and giving thanks for the user
            System.out.println("Thank you for using my program, I hope you get BMW :3 ");
        }
        // catching any exception that may happen in the program
        catch(Exception ex){
            System.out.println(ex);
        }

    }
    // a personal method that prints the vehicles information
    public static void print(ArrayList<Vehicles> ob){
        for(int i=0; i<ob.size(); i++){
            System.out.println((i+1) + ". " + ob.get(i));
        }
    }
    // A method that stores the vehicles data
    // it has an IOException because we read data from a file so we need to be sure that there is no problem with the input file
    public static ArrayList<Vehicles> store(ArrayList<Vehicles> ob) throws IOException {
        // creating a temporary arraylist of vehicles so we can restore it
        ArrayList<Vehicles> a = new ArrayList<>();
        // creating a variable for our input file
        File input = new File("inputdata.txt");
        // creating a variable scanner so we can read from the file
        Scanner inFile = new Scanner(input);
        // creating a loop so we keep reading until we finish the whole lines
        while(inFile.hasNextLine()){
            // reading each line from the file and storing it in a created string variable called temp
            String temp=inFile.nextLine();
            // storing each word from the line in an array of strings called s
            String[] s = temp.split(",");
            //  if statements to check each vehicle type
            if(s[0].equalsIgnoreCase("car")){
                // creating a new vehicle from the type car to the temp arraylist of vehicles that we made
                // Using parse to convert the string values to integers or doubles or boolean.
                a.add(new Car(s[1], s[2], s[3], new Owner(s[4]), s[5], Double.parseDouble(s[6].trim()),Double.parseDouble(s[7].trim()), Integer.parseInt(s[8].trim())));
            }
            else if(s[0].equalsIgnoreCase("minivan")){
                // creating a boolean flag to check the airCondition status
                boolean flag=false;
                if(s[9].equalsIgnoreCase("true"))
                    flag=true;
                else if(s[9].equalsIgnoreCase("false"))
                    flag=false;
                // if the string was neither true nor false then the value is invalid and we show an exception for that
                else throw new IllegalArgumentException("Invalid value for the air condition status");
                // creating a new MiniVan object and adding it to our temp arraylist
                a.add(new MiniVan(s[1], s[2], s[3], new Owner(s[4]), s[5].trim(), Double.parseDouble(s[6].trim()),Double.parseDouble(s[7].trim()), Integer.parseInt(s[8].trim()), Boolean.parseBoolean(s[9].trim())));
            }
            else if(s[0].equalsIgnoreCase("truck")){
                // creating a new Truck object and adding it to our temp arraylist
                a.add(new Truck(s[1], s[2], s[3], new Owner(s[4]), s[5], Double.parseDouble(s[6].trim()),Double.parseDouble(s[7].trim()), Integer.parseInt(s[8].trim()), Integer.parseInt(s[9].trim())));
            }
            // if the string that should be the vehicle type was not any of the above types then it's invalid and we show an exception
            else throw new IllegalArgumentException("Invalid Vehicle Type \n");
        }
        // closing the file scanner after reading the data
        inFile.close();
        // returning the temp arraylist after adding all the objects to it
        return a;
    }
    // A method that sets the prices of Gasoline and Diesel as the user wants
    public static void setPrices() throws IllegalArgumentException{
        Scanner in = new Scanner(System.in);
        // Setting instructions to the user so he can know how to set them
        System.out.println("Type 1 to set Diesel price, 2 to set Gasoline price or 21 to set both of them:");
        int p=in.nextInt();
        double x;
        if(p==1){
            System.out.println("Please type your the Diesel price: ");
             x= in.nextDouble();
             // Changing the Diesel price using its setter method from the class PetroleumType
            PetroleumType.setDieselPrice(x);
        }
        else if(p==2){
            System.out.println("Please type your the Gasoline price: ");
             x= in.nextDouble();
            // Changing the Gasoline price using its setter method from the class PetroleumType
            PetroleumType.setGasolinePrice(x);
        }
        else if(p==21){
            // setting both Gasoline and Diesel prices
            System.out.println("Please type your the Diesel price then the Gasoline price separated by a space: ");
             x= in.nextDouble();
            PetroleumType.setDieselPrice(x);
             x= in.nextDouble();
            PetroleumType.setGasolinePrice(x);
        }
        // if the user entered another value than the ones I mentioned in the instructions an illegal argument exception shows up
        else throw new IllegalArgumentException("You typed invalid number");
    }
    // A method that sorts the vehicles in an ascending order based on the 100km cost and then printing them
    public static void sortCost(ArrayList<Vehicles> ob){
        Collections.sort(ob);
        // calling the method that prints the vehicles list
        print(ob);
    }
    // A method that sorts the vehicles in an ascending order based on the owner name ( a to z) and then printing them
    public static void sortName(ArrayList<Vehicles> ob) {
        // creating a nested loop so we can sort the objects using the bubble sort
        for (int i = 0; i < ob.size(); i++) {
            for (int j = 1; j < (ob.size() - i); j++) {
                if (ob.get(j - 1).getOwner().getName().compareTo(ob.get(j).getOwner().getName()) >= 1) {
                    // swapping the objects
                    Collections.swap(ob, j, j - 1);
                }
            }
        }
        // calling the method that prints the vehicles list
        print(ob);
    }
    // A method that sorts the vehicles in a descending order based on the brand name ( z to a ) and then printing them
    public static void sortBrand(ArrayList<Vehicles> ob) {
        // creating a nested loop so we can sort the objects using the bubble sort
        // Note: this sort is ascending until I reverse it
        for (int i = 0; i < ob.size(); i++) {
            for (int j = 1; j < (ob.size() - i); j++) {
                if (ob.get(j - 1).getBrand().compareTo(ob.get(j).getBrand()) > 1) {
                    Collections.swap(ob, j, j - 1);
                }
            }
        }
        // here I reverse the sort so it becomes descending as the user wants
        Collections.reverse(ob);
        // calling the method that prints the vehicles list
        print(ob);
    }
    // A method that clones a vehicle that the user chooses from the vehicles list
    // throwing a cloneNotSupported exception
    public static void cloneO(ArrayList<Vehicles> ob) throws CloneNotSupportedException {
        Scanner in = new Scanner(System.in);
        System.out.println("Please Choose one object from the list by entering it's number: ");
        // printing the whole vehicles list to the user so he can choose the object he want by typing its number
        print(ob);
        int x=in.nextInt();
        // Checking if the user inputs a number that no vehicle has so we show an exception
        if(x<1 || x>ob.size())
            throw new IllegalArgumentException("Please enter a valid number");
        // Cloning the vehicle he chose to a newVehicle and then printing its data
        Vehicles newVehicle = (Vehicles)ob.get(x-1).clone();
        System.out.println(newVehicle.toString());
    }
    // A method that sets the airCondition status to ON
    public static void setAir(ArrayList<Vehicles> ob){
        for(int i=0; i<ob.size(); i++){
            ob.get(i).setAirConditionON();
        }
    }
    // A method that sorts the vehicles in an ascending order based on the 100km and then printing the results in the file output.txt
    // throwing the exception FileNotFoundException so we make sure that the file exists
    public static void fileWrite(ArrayList<Vehicles> ob) throws FileNotFoundException {
        try {
            // sorting the vehicles list
            Collections.sort(ob);
            // creating the variable out for the file output.txt
            File out = new File("output.txt");
            // creating a PrintWriter variable called write so we can write in the file
            PrintWriter write = new PrintWriter(out);
            for(int i=0; i<ob.size(); i++){
                write.println((i+1) + ". " + ob.get(i));
            }
            write.close();
            // closing the PrintWriter after writing the data
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    // A unique method to calculate the average cost of 100km for all vehicles
    public static double avgCost(ArrayList<Vehicles> ob){
        double sum=0;
        for(int i=0; i<ob.size(); i++){
            sum+=ob.get(i).costFor100Km();
        }
        return sum/(double)ob.size();
    }
    // A unique method to print the information of the vehicles with fuel consumption below the average fuel consumptions of all vehicles
    public static void savingVehicles(ArrayList<Vehicles> ob){
        for(int i=0; i<ob.size(); i++){
            if(ob.get(i).fuelConsumption>Vehicles.avgFuel())
                System.out.println(ob.get(i));
        }
    }
    // A unique method to calculate the percentage of family vans and their owners names
    public static void famVan(ArrayList<Vehicles> ob){
        // printing the percentage
        System.out.println(MiniVan.FamVan()*100+"% are family vans");
        if(MiniVan.FamVan()!=0)
            System.out.println("Family Vans Owners are: ");
        for(int i=0; i<ob.size(); i++){
            // doing an instanceof to make sure that the vehicle is from type Mini Van
            if(ob.get(i)instanceof MiniVan){
                if(((MiniVan) ob.get(i)).getNumberOfSeats()>4)
                    System.out.println(ob.get(i).owner.getName());
            }
        }
    }
    // A unique method to print out some information of the rented cars. ( Renting cars model number starts with 32 )
    public static void rentedCars(ArrayList<Vehicles> ob){
        for(int i=0; i<ob.size(); i++){
            // doing an instanceof to make sure that the vehicle is from type Car
            if(ob.get(i)instanceof Car){
                // Creating a StringBuilder to save the model number in
                StringBuilder str = new StringBuilder(ob.get(i).getModelNO());
                // Comparing the first two digits of the model number with 32 using substring method
                if(str.substring(0,2).equals("32"))
                    System.out.println("Car Owner: "+ob.get(i).owner.getName()+"\nCar Brand: " + ob.get(i).getBrand()+"\nCar Model Number: " + ob.get(i).getModelNO());
            }
        }
    }

}
