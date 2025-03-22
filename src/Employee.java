public class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String emailAddress;
    private String role;

    public Employee(String employeeId, String firstName, String lastName, String contactNumber, String emailAddress, String role) { //constructor for employee class
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
        this.role = role;
    }

    // Getters and setters for fields
    public String getEmployeeId() { //getter for employeeId
        return employeeId;
    }

    public String getFirstName() { //getter for firstName
        return firstName;
    }

    public String getLastName() { //getter for lastName
        return lastName;
    }

    public String getContactNumber() { //getter for contactNumber
        return contactNumber;
    }

    public String getEmailAddress() { //getter for emailAddress
        return emailAddress;
    }

    public String getRole() { //getter for role
        return role;
    }

}