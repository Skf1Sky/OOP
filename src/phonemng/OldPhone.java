package phonemng;

import java.util.Scanner;

public class OldPhone extends Phone {
    private int batteryHealth;
    private String description;

    public OldPhone() {
        super();
    }

    public OldPhone(String id, String name, double price, int warrantyMonths, String manufacturer, int batteryHealth, String description) {
        super(id, name, price, warrantyMonths, manufacturer);
        this.batteryHealth = batteryHealth;
        this.description = description;
    }

    @Override
    public void inputData(Scanner sc) {
        super.inputData(sc);
        System.out.print("Enter battery health (%): ");
        this.batteryHealth = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter description: ");
        this.description = sc.nextLine();
    }

    @Override
    public void displayData() {
        super.displayData();
        System.out.println("Battery Health: " + this.batteryHealth + "%");
        System.out.println("Description: " + this.description);
        System.out.println("--------------------------");
    }
}
