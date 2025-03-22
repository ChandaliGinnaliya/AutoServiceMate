import java.util.ArrayList;

public class Customer {
    //private String customerId;
    private String firstName;
    private String lastName;
    private int contactNumber;
    private String emailAddress;

    public Customer(String firstName, String lastName, int contactNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
    }

    public Customer() {

    }
}
