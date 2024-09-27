import java.util.Scanner;

public class RentalAgencyTest {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();
        Scanner scanner = new Scanner(System.in);

        // Test adding cars
        System.out.println("\n Testing Add Car Functionality ");
        agency.addCar("Ford Mustang", "KDH 782J");
        agency.addCar("Audi A6", "KCR 582N");
        agency.addCar("Land Rover Discovery", "KDE 692P");
        agency.showAvailableCars();

        // Test renting a car
        System.out.println("\n Testing Rent Car Functionality ");
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter customer DL number: ");
        String dlNumber = scanner.nextLine();
        Customer customer = new Customer(customerName, dlNumber);
        agency.rentCar(customer);
        agency.showRentedCars();

        // Test returning a car
        System.out.println("\n Testing Return Car Functionality ");
        agency.returnCar();
        agency.showAvailableCars();

        // Test showing all available cars
        System.out.println("\n Testing Show Available Cars Functionality");
        agency.showAvailableCars();

        // Test showing rented cars
        System.out.println("\n Testing Show Rented Cars Functionality ");
        agency.showRentedCars();

        // End of tests
        scanner.close();
        System.out.println("All tests completed.");
    }
}
