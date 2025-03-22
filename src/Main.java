import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //creating the scanner variable to take input from the user
        ServiceStation serviceStation = new ServiceStation(); //creating the serviceStation object to access the methods of the ServiceStation class

        int choice; //declaring the choice variable to store the user's choice
        do {
            System.out.println("\n----------------------------------------------\n----------Welcome to AutoServiceMate----------\n----------------------------------------------");
            System.out.println("\t\t1. Make Appointment");
            System.out.println("\t\t2. View Scheduled Appointments");
            System.out.println("\t\t3. Add Employee");
            System.out.println("\t\t4. View Employees");
            System.out.println("\t\t5. View Vehicle Details");
            System.out.println("\t\t6. Print Bill");
            System.out.println("\t\t7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) { //switch case to perform the action based on the user's choice
                case 1:
                    makeAppointment(scanner, serviceStation);
                    addNewCustomer(scanner, serviceStation);
                    addNewVehicle(scanner, serviceStation);
                    break;
                case 2:
                    serviceStation.viewScheduledAppointments();
                    break;
                case 3:
                    addEmployee(scanner, serviceStation);
                    break;
                case 4:
                    serviceStation.viewEmployees();
                    break;
                case 5:
                    System.out.println("Enter the license plate of the vehicle:");
                    String licensePlate = scanner.nextLine();
                    serviceStation.viewVehicleDetails(licensePlate);
                    break;
                case 6:
                    printBill(scanner, serviceStation);
                    printBillToFile(scanner, serviceStation);
                    break;
                case 7:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again."); //default case to handle invalid choices
            }
        } while (choice !=7);

    }

    private static void makeAppointment(Scanner scanner, ServiceStation serviceStation) { //method to make an appointment
        System.out.println("Enter customer ID:");
        String customerId = scanner.nextLine();
        System.out.println("Enter vehicle ID:");
        String vehicleId = scanner.nextLine();
        System.out.println("Enter date and time (YYYY-MM-DD HH:MM):");
        String dateTime = scanner.nextLine();
        System.out.println("Enter service type [Car wash and clean // Full service // Vehicle inspection]");
        String serviceType = scanner.nextLine();

        Appointment appointment = new Appointment(customerId, vehicleId, dateTime, serviceType);
        serviceStation.addAppointment(appointment); //calling the addAppointment method from the ServiceStation class
        System.out.println("Appointment made successfully! Please enter customer details");
    }

    private static void addNewCustomer(Scanner scanner, ServiceStation serviceStation) { //method to add a new customer to the system(customer class)
        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter contact number:");
        int contactNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter email address:");
        String emailAddress = scanner.nextLine();

        Customer customer = new Customer(firstName,lastName, contactNumber, emailAddress); //creating the customer object to access the methods of the Customer class
        serviceStation.addCustomer(customer);
        System.out.println("Customer added successfully! Please enter vehicle details");
    }

    private static void addNewVehicle(Scanner scanner, ServiceStation serviceStation) { //method to add a new vehicle to the system(vehicle class)
        System.out.println("Enter vehicle make:");
        String make = scanner.nextLine();

        System.out.println("Enter vehicle model:");
        String model = scanner.nextLine();

        System.out.println("Enter vehicle year:");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter vehicle license plate:");
        String licensePlate = scanner.nextLine();

        System.out.println("Enter current mileage:");
        int currentMileage = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Vehicle added successfully!");

        serviceStation.saveVehicleDetails(make, model, year, licensePlate, currentMileage); // Save vehicle details

    }

    private static void addEmployee(Scanner scanner, ServiceStation serviceStation) {
        System.out.println("Enter employee ID:");
        String employeeId = scanner.nextLine();
        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter contact number:");
        String contactNumber = scanner.nextLine();
        System.out.println("Enter email address:");
        String emailAddress = scanner.nextLine();
        System.out.println("Enter role:");
        String role = scanner.nextLine();

        Employee employee = new Employee(employeeId, firstName, lastName, contactNumber, emailAddress, role); //creating the employee object to access the methods of the Employee class
        serviceStation.addEmployee(employee);
        System.out.println("Employee added successfully!");
    }
    private static void printBill(Scanner scanner, ServiceStation serviceStation) { //method to print the bill on the console
        System.out.println("Enter the vehicle ID:");
        String vehicleId = scanner.nextLine();

        Appointment appointment = serviceStation.findAppointmentByVehicleId(vehicleId);
        if (appointment != null) {
            // Print appointment details
            System.out.println("Appointment Details:");
            System.out.println("Customer ID: " + appointment.getCustomerId());
            System.out.println("Date and Time: " + appointment.getDateTime());
            System.out.println("Service Type: " + appointment.getServiceType());
            System.out.println("Total Cost: Rs. " + serviceStation.calculateTotalServiceCost(vehicleId));
        } else {
            System.out.println("No appointments found for Vehicle ID: " + vehicleId);
        }
    }

    private static void printBillToFile(Scanner scanner, ServiceStation serviceStation) { //method to print the bill to a text file
        System.out.println("Enter the vehicle ID:");
        String vehicleId = scanner.nextLine();

        Appointment appointment = serviceStation.findAppointmentByVehicleId(vehicleId); //calling the findAppointmentByVehicleId method from the ServiceStation class
        if (appointment != null) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(vehicleId + "_bill.txt"))) { //creating the writer object to write the bill to a text file and using the FileWriter class to write to the file
                // Write service details to the file
                writer.println("------------------Auto Service Mate------------------");
                writer.println("");
                writer.println("Service Invoice");
                writer.println("");
                writer.println("Vehicle ID: " + appointment.getVehicleId());
                writer.println("Service Type: " + appointment.getServiceType());
                writer.println("Total Cost: Rs. " + serviceStation.calculateTotalServiceCost(vehicleId));
                writer.println("");
                writer.println("-----------------------------------------------------");
                writer.println("Thank you for choosing Auto Service Mate! Come again!");
                System.out.println("Bill printed to " + vehicleId + "_bill.txt");
            } catch (IOException e) { //catch block to handle the exception(if any error occurs)
                System.err.println("Error writing to file: " + e.getMessage());
            }
        } else {
            System.out.println("No appointments found for Vehicle ID: " + vehicleId);
        }
    }
}

