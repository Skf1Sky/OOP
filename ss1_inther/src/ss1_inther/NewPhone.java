package ss1_inther;

public class NewPhone extends Phone {
    private int quantity;

    public NewPhone() {
    }

    public NewPhone(String id, String name, double price, int warrantyMonths, String manufacturer, int quantity) {
        // Call the parent constructor
        super(id, name, price, warrantyMonths, manufacturer);
        this.quantity = quantity;
    }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return String.format("| %-10s | %-15s | $%-10.0f | %-10s | %-10s | Qty: %-5d |",
                id, name, price, manufacturer, warrantyMonths + " months", quantity);
    }
}