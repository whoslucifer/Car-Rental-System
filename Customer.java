public class Customer {
    private String name;
    private String dlNumber;

    public Customer(String name, String dlNumber) {
        this.name = name;
        this.dlNumber = dlNumber;
    }

    public String getName() {
        return name;
    }

    public String getDlNumber() {
        return dlNumber;
    }
}
