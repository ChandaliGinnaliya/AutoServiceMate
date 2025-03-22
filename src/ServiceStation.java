import java.util.ArrayList;

public class ServiceStation {
    private ArrayList<Employee> employees;
    private ArrayList<Vehicle> vehiclesServiced;
    private ArrayList<Appointment> appointments;
    private ArrayList<Customer> customers;

    public ServiceStation() { // Constructor for the ServiceStation class
        this.employees = new ArrayList<>();
        this.vehiclesServiced = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    } // Method to add an employee to the system

    public void viewScheduledAppointments() { // Method to view all scheduled appointments
        for (Appointment appointment : appointments) {
            System.out.println("Customer ID: " + appointment.getCustomerId());
            System.out.println("Vehicle ID: " + appointment.getVehicleId());
            System.out.println("Date and Time: " + appointment.getDateTime());
            System.out.println("Service Type: " + appointment.getServiceType());
            System.out.println();
        }
    }

    public void viewEmployees() { // Method to view all employees
        System.out.println("Employees at Auto Service Mate:");
        for (Employee employee : employees) {
            System.out.println("Employee ID: " + employee.getEmployeeId());
            System.out.println("Name: " + employee.getFirstName() + " " + employee.getLastName());
            System.out.println("Contact Number: " + employee.getContactNumber());
            System.out.println("Email Address: " + employee.getEmailAddress());
            System.out.println("Role: " + employee.getRole());
            System.out.println();
        }
    }

    public void viewVehicleDetails(String licensePlate) { // Method to view vehicle details
        for (Vehicle vehicle : vehiclesServiced) { // Loop through the vehicles serviced
            if (vehicle.getLicensePlate().equals(licensePlate)) {
                System.out.println("Vehicle Details:");
                System.out.println("Make: " + vehicle.getMake());
                System.out.println("Model: " + vehicle.getModel());
                System.out.println("Year: " + vehicle.getYear());
                System.out.println("License Plate: " + vehicle.getLicensePlate());
                System.out.println("Current mileage: " + vehicle.getCurrentMileage() + " km");
                return; // Stop searching once the vehicle is found
            }
        }
        System.out.println("Vehicle with license plate " + licensePlate + " not found.");
    }

    public double calculateTotalServiceCost(String vehicleId) { // Method to calculate the total service cost for a vehicle
        double totalCost = 0.0;
        for (Appointment appointment : appointments) {
            if (appointment.getVehicleId().equals(vehicleId)) {
                totalCost += calculateServiceCost(appointment.getServiceType());
            }
        }
        return totalCost;
    }

    public Appointment findAppointmentByVehicleId(String vehicleId) { // Method to find an appointment by vehicle ID
        for (Appointment appointment : appointments) {
            if (appointment.getVehicleId().equals(vehicleId)) {
                return appointment;
            }
        }
        return null; // Return null if no appointment found with the given vehicle ID
    }


    private double calculateServiceCost(String serviceType) {
        // Define the costs for different service types
        switch (serviceType) {
            case "Car wash and clean":
                return 5000.00;
            case "Full service":
                return 40000.00;
            case "Vehicle inspection":
                return 4000.00;
            default:
                return 0.0; // Default cost if service type is not recognized
        }
    }


    public void addAppointment(Appointment appointment) { // Method to add an appointment to the system
        appointments.add(appointment);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }// Method to add a customer to the system

    public void saveVehicleDetails(String make, String model, int year, String licensePlate, int currentMileage) { // Method to save vehicle details to the system
        Vehicle vehicle = new Vehicle(make, model, year, licensePlate);
        vehicle.setCurrentMileage(currentMileage);
        vehiclesServiced.add(vehicle);
    }
    public ArrayList<Appointment> findAppointmentsByVehicleId(String vehicleId) { // Method to find appointments by vehicle ID
        ArrayList<Appointment> appointmentsByVehicleId = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getVehicleId().equals(vehicleId)) {
                appointmentsByVehicleId.add(appointment);
            }
        }
        return appointmentsByVehicleId;
    }

}
