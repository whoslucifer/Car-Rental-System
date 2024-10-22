import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n Car Rental System ");
            System.out.println("1. Add Car");
            System.out.println("2. Rent Car");
            System.out.println("3. Return Car");
            System.out.println("4. Show Available Cars");
            System.out.println("5. Show Rented Cars and Customers");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter car model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter license plate: ");
                    String licensePlate = scanner.nextLine();
                    agency.addCar(model, licensePlate);
                    break;

                case 2:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter customer DL number: ");
                    String dlNumber = scanner.nextLine();
                    Customer customer = new Customer(name, dlNumber);
                    agency.rentCar(customer);
                    break;

                case 3:
                    agency.returnCar();
                    break;

                case 4:
                    agency.showAvailableCars();
                    break;

                case 5:
                    agency.showRentedCars();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
}
