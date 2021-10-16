// creating the class Petroleum that is son of Vehicles class
public class PetroleumType {
    // creating the Petroleum properties
    public final static int GASOLINE = 2, DIESEL = 1;
    private static double gasolinePrice = 5.23, dieselPrice = 4.02;
    // creating setters and getters methods for the class Petrolium
    public static double getGasolinePrice() {
        return gasolinePrice;
    }

    public static void setGasolinePrice(double newPrice) {
        gasolinePrice = newPrice;
    }

    public static double getDieselPrice() {
        return dieselPrice;
    }

    public static void setDieselPrice(double newPrice) {
        dieselPrice = newPrice;
    }

}
