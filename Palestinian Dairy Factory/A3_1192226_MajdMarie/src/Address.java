// Defining the class Address
public class Address {
    private String Street, State, City;
    private int ZipCode;

    // Building a non argument constructor
    public Address(){
    }

    // Building a constructor with argument that receive the properties values from the user
    public Address(String street, String state, String city, int zipCode) {
        this.Street = street;
        this.State = state;
        this.City = city;
        this.ZipCode = zipCode;
    }

    // Defining Setters and Getters
    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        this.Street = street;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        this.State = state;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        this.City = city;
    }

    public int getZipCode() {
        return ZipCode;
    }

    public void setZipCode(int zipCode) {
        this.ZipCode = zipCode;
    }

    // Overriding the method toString from the class Object
    @Override
    public String toString() {
        return "Street:"+Street +",State:"+State +",City:"+City +",Zip code:"+ZipCode;
    }
}