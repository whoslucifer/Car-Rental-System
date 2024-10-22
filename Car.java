public class Car {
    private String model;
    private String licensePlate;
    private boolean isAvailable;

    public Car(String model, String licensePlate) {
        this.model = model;
        this.licensePlate = licensePlate;
        this.isAvailable = true;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void markAsRented() {
        if (isAvailable) {
            this.isAvailable = false;
            System.out.println(model + " with license plate " + licensePlate + " is now rented.");
        } else {
            System.out.println("Car is already rented.");
        }
    }


    public String getModel() {
        return model;
    }


    public void markAsReturned() {
        this.isAvailable = true;
        System.out.println(model + " with license plate " + licensePlate + " is now available.");
    }
}
