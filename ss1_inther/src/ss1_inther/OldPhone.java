package ss1_inther;

public class OldPhone extends Phone {
    private int batteryLevel; // Percentage
    private String description;

    public OldPhone() {
    }

    public OldPhone(String id, String name, double price, int warrantyMonths, String manufacturer, int batteryLevel, String description) {
        super(id, name, price, warrantyMonths, manufacturer);
        this.batteryLevel = batteryLevel;
        this.description = description;
    }

    public int getBatteryLevel() { return batteryLevel; }
    public void setBatteryLevel(int batteryLevel) { this.batteryLevel = batteryLevel; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return String.format("| %-10s | %-15s | $%-10.0f | %-10s | %-10s | Bat: %-3d%% | %-15s |",
                id, name, price, manufacturer, warrantyMonths + " months", batteryLevel, description);
    }
}