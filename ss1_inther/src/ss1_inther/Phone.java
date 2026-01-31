package ss1_inther;

public abstract class Phone {
    // Protected attributes (accessible by child classes)
    protected String id;
    protected String name;
    protected double price;
    protected int warrantyMonths;
    protected String manufacturer;

    // Default Constructor
    public Phone() {
    }

    // Full Parameter Constructor
    public Phone(String id, String name, double price, int warrantyMonths, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.warrantyMonths = warrantyMonths;
        this.manufacturer = manufacturer;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getWarrantyMonths() { return warrantyMonths; }
    public void setWarrantyMonths(int warrantyMonths) { this.warrantyMonths = warrantyMonths; }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    // Abstract method to force child classes to define how they print info
    public abstract String toString();
}