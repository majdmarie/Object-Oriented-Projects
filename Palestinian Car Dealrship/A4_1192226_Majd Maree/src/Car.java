// Creating the class Car which is a son of the Parent Vehicles class
public class Car extends Vehicles {
    // creating the car properties
    private int numberOfSeats;
    private boolean airConditionON;

    // creating an argument constructor that receives the common attributes from the class Vehicle and then Car special properties
    public Car(String modelName, String modelNO, String brand, Owner owner, String engineType, double tunkSize, double fuelConsumption, int numberOfSeats) throws IllegalArgumentException{
        super(modelName, modelNO, brand, engineType, tunkSize, fuelConsumption, owner);
        if(engineType.equalsIgnoreCase("Gasoline") || engineType.equalsIgnoreCase("Hybrid"));
        else{
            throw new IllegalArgumentException("Car can only have either Gasoline or Hyprid engine type. \n");
        }
        this.numberOfSeats = numberOfSeats;
        this.airConditionON = false;
    }
    // creating setters and getters methods for the class Car
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean isAirConditionON() {
        return airConditionON;
    }

    // overriding the abstract methods setAirConditionOFF,setAirConditionON from the parent ( Vehicles Class ) and making calculations to change the fuel consumptions
    @Override
    public void setAirConditionON(){
        if(!airConditionON) {
            fuelConsumption -= 0.1 * fuelConsumption;
        }
        this.airConditionON = true;
    }
    @Override
    public void setAirConditionOFF(){
        if(airConditionON){
            fuelConsumption *= 1.111111111111111111111111111111;
        }
        this.airConditionON = false;
    }
    // overriding the abstract method costFor100KM from the parent and doing it's calculations
    @Override
    public double costFor100Km() {
        double cost = (100 / fuelConsumption) * PetroleumType.getGasolinePrice();
        return cost;
    }
    // Overriding the toString method from the parent Object so it shows or Car data
    @Override
    public String toString() {
        String status = "OFF";
        if (airConditionON) {
            status = "ON";
        }
        return super.toString()
                + "\nNumber of seats: " + numberOfSeats
                + "\nAir condition status: " + status + "\n";
    }

}
