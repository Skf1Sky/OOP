package phonemnm2;

import java.util.Scanner;

public class NewPhone extends Phone {
    private int quantity;

    public NewPhone() {
        super();
    }

    public NewPhone(String id, String name, double price, int warrantyMonths, String manufacturer, int quantity) {
        super(id, name, price, warrantyMonths, manufacturer);
        this.quantity = quantity;
    }

    @Override
    public void inputData(Scanner sc) {
        super.inputData(sc);
        System.out.print("Enter quantity: ");
        this.quantity = sc.nextInt();
        sc.nextLine();
    }

    @Override
    public void displayData() {
        super.displayData();
        System.out.println("Quantity: " + this.quantity);
        System.out.println("--------------------------");
    }
}
