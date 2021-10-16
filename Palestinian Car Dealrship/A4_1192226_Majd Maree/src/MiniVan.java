// creating the class MiniVan that is son of Vehicles class
public class MiniVan extends Vehicles {
    // creating the miniVan properties
    private int numberOfSeats;
    private boolean airConditionON, hasAutoDoors;
    private static int counter=0,n=0;

    // creating an argument constructor that receives the common attributes from the class Vehicle and then MiniVan special properties
    public MiniVan(String modelName, String modelNO, String brand,Owner owner, String engineType, double tunkSize, double fuelConsumption,  int numberOfSeats, boolean hasAutoDoors) {
        // receiving the the common attributes from the class Vehicle
        super(modelName, modelNO, brand, engineType, tunkSize, fuelConsumption, owner);
        this.numberOfSeats = numberOfSeats;
        if(this.numberOfSeats>4)
            counter++;
        this.hasAutoDoors = hasAutoDoors;
        n++;
    }
    // creating setters and getters methods for the class miniVan
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean isAirConditionON() {
        return airConditionON;
    }

    public void setHasAutoDoors(boolean hasAutoDoors) {
        this.hasAutoDoors = hasAutoDoors;
    }

    public boolean isHasAutoDoors() {
        return hasAutoDoors;
    }

    // overriding the abstract methods setAirConditionOFF,setAirConditionON from the parent ( Vehicles Class ) and making calculations to change the fuel consumptions
    @Override
    public void setAirConditionON(){
        if(!airConditionON) {
            fuelConsumption -= 0.2 * fuelConsumption;
        }
        this.airConditionON = true;
    }
    @Override
    public void setAirConditionOFF(){
        if(airConditionON){
            fuelConsumption *= 1.25;
        }
        this.airConditionON = false;
    }

    // overriding the abstract method costFor100KM from the parent and doing it's calculations
    @Override
    public double costFor100Km() throws IllegalArgumentException{
        double cost = 0;
        double temp = fuelConsumption;
        if (airConditionON) {
            super.setFuelConsumption((fuelConsumption)-fuelConsumption * 0.2);
        }
        if (engineType.equalsIgnoreCase("Diesel")) {
            cost = (100 / fuelConsumption) * PetroleumType.getDieselPrice();
        } else if (engineType.equalsIgnoreCase("Gasoline")) {
            cost = (100 / fuelConsumption) * PetroleumType.getGasolinePrice();
        }
        // checking if the engine type has invalid engine type so the program shows an illegalargumentexception
        else
            throw new IllegalArgumentException("The engine type is invalid.");
        fuelConsumption=temp;
        return cost;
    }

    // Overriding the toString method from the parent Object so it shows or miniVan data
    @Override
    public String toString() {
        String conditionStatus = "OFF";
        if (airConditionON) {
            conditionStatus = "ON";
        }
        String doorsStatus = "Manual";
        if (hasAutoDoors) {
            doorsStatus = "Automatic";
        }
        return super.toString()
                + "\nNumber of seats: " + numberOfSeats
                + "\nAir condition status: " + conditionStatus
                + "\nDoors Type: " + doorsStatus + "\n";
    }
    // A unique method to return the percentage of family mini vans that we have
    public static double FamVan(){
        if(n!=0)
             return (double)counter/(double)n;
        return 0;
    }

}
