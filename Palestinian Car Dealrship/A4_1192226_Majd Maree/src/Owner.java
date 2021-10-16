// importing the calendar library ( GregorianCalendar )
import java.util.GregorianCalendar;
// Creating the class Owner
public class Owner {
    // creating the owner properties
    private String name, registrationNO="101", address="Jenin Al-Somood", Tel="+970-4444444";
    private GregorianCalendar dateOfRegistration=new GregorianCalendar();
    // Creating a one argument constructor for the name
    public Owner(String name) {
        this.name=name;
    }

    // Creating a full argument constructor for the name
    public Owner(String name, String registrationNO, String address, String Tel, GregorianCalendar date) {
        this.name = name;
        this.registrationNO = registrationNO;
        this.address = address;
        this.Tel = Tel;
    }
    // creating setters and getters methods for the class Owner
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationNO() {
        return registrationNO;
    }

    public void setRegistrationNO(String registrationNO) {
        this.registrationNO = registrationNO;
    }

    public String getAddres() {
        return address;
    }

    public void setAddres(String addres) {
        this.address = addres;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public GregorianCalendar getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(GregorianCalendar dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }
    // Overriding the toString method from the parent Object so it shows or Owner information
    @Override
    public String toString() {
        return "Owner Name: " + name
                + "\nRegistration NO. " + registrationNO
                + "\nDate Of Registration: " + dateOfRegistration.getTime()
                + "\nAddress: " + address 
                + "\nTel: " + Tel;
    }   
    
}
