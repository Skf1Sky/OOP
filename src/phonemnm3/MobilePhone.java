package phonemnm3;

public class MobilePhone extends Phone {
    private String brand;
    private int batteryCapacity;

    public MobilePhone() {
        super();
    }

    public MobilePhone(String id, String name, double price, String brand, int batteryCapacity) {
        super(id, name, price);
        this.brand = brand;
        this.batteryCapacity = batteryCapacity;
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public int getBatteryCapacity() { return batteryCapacity; }
    public void setBatteryCapacity(int batteryCapacity) { this.batteryCapacity = batteryCapacity; }

    @Override
    public void displayInfo() {
        // Formatting output table
        System.out.printf("ID: %-7s | Name: %-15s | Brand: %-10s | Battery: %-5d mAh | Price: $%,.2f\n",
                id, name, brand, batteryCapacity, price);
    }
}
