 public class Appointment {
    private String customerId;
    private String vehicleId;
    private String dateTime;
    private String serviceType;

    public Appointment(String customerId, String vehicleId, String dateTime, String serviceType) { // Constructor for Appointment class
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.dateTime = dateTime;
        this.serviceType = serviceType;
    }

    // Getters for fields
    public String getCustomerId() { // Getter for customerId
        return customerId;
    }

    public String getVehicleId() { // Getter for vehicleId
        return vehicleId;
    }

    public String getDateTime() { // Getter for dateTime
        return dateTime;
    }

    public String getServiceType() { // Getter for serviceType
        return serviceType;
    }
}