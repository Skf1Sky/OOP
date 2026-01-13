package phonemng;

import java.util.Scanner;

public class Phone {
    protected String id;
    protected String name;
    protected double price;
    protected int warrantyMonths;
    protected String manufacturer;

    public Phone() {
    }

    public Phone(String id, String name, double price, int warrantyMonths, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.warrantyMonths = warrantyMonths;
        this.manufacturer = manufacturer;
    }

    public void inputData(Scanner sc) {
        System.out.print("Enter phone name: ");
        this.name = sc.nextLine();

        System.out.print("Enter price: ");
        this.price = sc.nextDouble();

        System.out.print("Enter warranty (months): ");
        this.warrantyMonths = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter manufacturer: ");
        this.manufacturer = sc.nextLine();
    }

    public void displayData() {
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Price: " + this.price);
        System.out.println("Warranty: " + this.warrantyMonths + " months");
        System.out.println("Manufacturer: " + this.manufacturer);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}