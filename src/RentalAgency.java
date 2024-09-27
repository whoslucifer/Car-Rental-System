import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RentalAgency {
    private List<Car> cars;
    private Map<Car, Customer> rentals; // Store rented cars and the customer who rented them

    public RentalAgency() {
        this.cars = new ArrayList<>();
        this.rentals = new HashMap<>();
    }

    // Add a new car
    public void addCar(String model, String licensePlate) {
        cars.add(new Car(model, licensePlate));
        System.out.println("Car added: " + model + " with plate " + licensePlate);
    }

    // Rent a car - shows available cars before renting
    public void rentCar(Customer customer) {
        System.out.println("Available cars for rent:");
        List<Car> availableCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.isAvailable()) {
                availableCars.add(car);
            }
        }

        if (availableCars.isEmpty()) {
            System.out.println("No cars available for rent.");
            return;
        }

        for (int i = 0; i < availableCars.size(); i++) {
            Car car = availableCars.get(i);
            System.out.println((i + 1) + ". Model: " + car.getModel() + " | License Plate: " + car.getLicensePlate());
        }

        // Ask user to choose the car to rent
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the car to rent: ");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > availableCars.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        Car chosenCar = availableCars.get(choice - 1);
        chosenCar.markAsRented();
        rentals.put(chosenCar, customer); // Record the rental with customer
        System.out.println("Rental confirmed for " + customer.getName());
    }

    // Return a car - updated to display rented cars before selecting
    public void returnCar() {
        System.out.println("Rented cars:");
        List<Car> rentedCars = new ArrayList<>();
        for (Car car : cars) {
            if (!car.isAvailable()) {
                rentedCars.add(car);
            }
        }

        if (rentedCars.isEmpty()) {
            System.out.println("No cars are currently rented out.");
            return;
        }

        for (int i = 0; i < rentedCars.size(); i++) {
            Car car = rentedCars.get(i);
            System.out.println((i + 1) + ". Model: " + car.getModel() + " | License Plate: " + car.getLicensePlate());
        }

        // Ask user to choose the car to return
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the car to return: ");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > rentedCars.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        Car chosenCar = rentedCars.get(choice - 1);
        chosenCar.markAsReturned();
        rentals.remove(chosenCar);
        System.out.println("Car with license plate " + chosenCar.getLicensePlate() + " has been returned and is now available.");
    }

    // Show all available cars
    public void showAvailableCars() {
        System.out.println("Available Cars:");
        for (Car car : cars) {
            if (car.isAvailable()) {
                System.out.println("Model: " + car.getModel() + " | License Plate: " + car.getLicensePlate());
            }
        }
    }

    // Show all rented cars and their customers
    public void showRentedCars() {
        if (rentals.isEmpty()) {
            System.out.println("No cars are currently rented out.");
            return;
        }

        System.out.println("Rented Cars and their Customers:");
        int count = 1;
        for (Map.Entry<Car, Customer> entry : rentals.entrySet()) {
            Car car = entry.getKey();
            Customer customer = entry.getValue();
            System.out.println(count++ + ". Model: " + car.getModel() + " | License Plate: " + car.getLicensePlate() +
                    " | Rented by: " + customer.getName() + " (DL: " + customer.getDlNumber() + ")");
        }
    }
}
