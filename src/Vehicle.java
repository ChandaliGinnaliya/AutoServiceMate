public class  Vehicle extends  Customer{ // Vehicle class is a subclass of Customer class
    private String make;
    private String model;
    private int year;
    private String licensePlate;
    private int currentMileage;

    public Vehicle (String make, String model, int year, String licensePlate) { // Constructor for Vehicle class
        this.make = make;
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
        this.currentMileage = 0;
    }

    // Getters and setters for fields
    public String getMake() { // Getter for make
        return make;
    }

    public String getModel() { // Getter for model
        return model;
    }

    public int getYear() { // Getter for year
        return year;
    }

    public String getLicensePlate() { // Getter for licensePlate
        return licensePlate;
    }

    public int getCurrentMileage() { // Getter for currentMileage
        return currentMileage;
    }

    public void setCurrentMileage(int currentMileage) { // Setter for currentMileage
        this.currentMileage = currentMileage;
    }
}
