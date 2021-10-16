// creating the class MiniVan that is son of Vehicles class
public class Truck extends Vehicles {

    // creating the Truck properties
    private int numberOfSeats, power;
    private boolean airConditionON;

    // creating an argument constructor that receives the common attributes from the class Vehicle and then MiniVan special properties
    public Truck(String modelName, String modelNO, String brand, Owner owner, String engineType, double tunkSize, double fuelConsumption, int numberOfSeats, int power) {
        super(modelName, modelNO, brand, "Diesel", tunkSize, fuelConsumption, owner);
        this.numberOfSeats = numberOfSeats;
        this.power = power;
    }
    // creating setters and getters methods for the class Truck
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isAirConditionON() {
        return airConditionON;
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
    public double costFor100Km() {
        double temp = fuelConsumption;
        if (airConditionON) {
            super.setFuelConsumption((fuelConsumption)-fuelConsumption * 0.2);
        }
        double cost = (100 / fuelConsumption) * PetroleumType.getDieselPrice();
        fuelConsumption=temp;
        return cost;
    }

    // Overriding the toString method from the parent Object so it shows or Truck data
    @Override
    public String toString() {
        String status = "OFF";
        if (airConditionON) {
            status = "ON";
        }
        return super.toString()
                + "\nNumber of seats: " + numberOfSeats
                + "\nAir condition status: " + status
                + "\nPower: " + power + "\n";
    }

}
