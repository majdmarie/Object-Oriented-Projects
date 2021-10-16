// Creating the abstract Vehicles class that is parent of all the vehicles types
// This class implements from Cloneable and Comparable interfaces so we can clone the objects or compare them
public abstract class Vehicles implements Comparable<Vehicles>, Cloneable {
    // creating common attributes that exist in all the son classes ( all the vehicles )
    protected String modelName, modelNO, brand, engineType;
    protected double tunkSize, fuelConsumption;
    private static double sum=0;
    private static int cnt=0;
    public Owner owner;

    // Creating an argument constructor that receives the attributes
    public Vehicles(String modelName, String modelNO, String brand, String engineType, double tunkSize, double fuelConsumption, Owner owner) {
        this.modelName = modelName;
        this.modelNO = modelNO;
        this.brand = brand;
        this.engineType = engineType;
        this.tunkSize = tunkSize;
        this.fuelConsumption = fuelConsumption;
        this.owner = owner;
        sum+=this.fuelConsumption;
        cnt++;
    }
    // creating the abstract methods costFor100km, setAirConditionON, setAirConditionOFF ( these methods are common between all the vehicles )
    public abstract double costFor100Km();

    public abstract void setAirConditionON();

    public abstract void setAirConditionOFF();

    // creating the method movableDistance
    public double movableDistance() {
        return fuelConsumption * tunkSize;
    }

    // overriding the compareTo method from the interface Comparable so we can compare based on the costFor100Km
    @Override
    public int compareTo(Vehicles v) {
        if (this.costFor100Km() > v.costFor100Km()) {
            return 1;
        } else if (this.costFor100Km() < v.costFor100Km()) {
            return -1;
        }
        return 0;
    }

    // overriding the toString method from the parent Object so we can print the main Vehicle attributes
    @Override
    public String toString() {
        // Creating a null string so we don't print Owner information if there is no owner information ( for example after creating a new vehicle by cloning it from another)
        String ownerInfo = null;
        if(owner != null)
            ownerInfo = owner.toString();
        return "- Owner Info:\n" + ownerInfo
                + "\n- Vehicle Info:"
                + "\nModelName: " + modelName
                + "\nModelNO: " + modelNO
                + "\nBrand: " + brand
                + "\nEngineType: " + engineType
                + "\nTunkSize: " + tunkSize
                + "\nFuelConsumption: " + fuelConsumption
                + "\nCost for 100 Km: " + costFor100Km() + " NIS"
                + "\nMovable Distance: " + movableDistance();
    }
    // overriding the clone method from the interface Cloneable
    @Override
    public Object clone() throws CloneNotSupportedException {
        Vehicles newVehicle = (Vehicles) super.clone();
        // Cloning the vehicle with out its owner
        newVehicle.owner = null;
        return newVehicle;
    }
    // A unique method from Majd personally to calculate the average of fuel consumption
    public static double avgFuel(){
        return sum/cnt;
    }
    // Setting setters and getters method for the common attributes
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelNO() {
        return modelNO;
    }

    public void setModelNO(String modelNO) {
        this.modelNO = modelNO;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getEngineType() { return engineType; }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public double getTunkSize() {
        return tunkSize;
    }

    public void setTunkSize(double tunkSize) {
        this.tunkSize = tunkSize;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public Owner getOwner() { return owner; }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

}
