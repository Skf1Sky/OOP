package phonemng;

import java.util.ArrayList;
import java.util.Scanner;

public class StoreManagement {
    static ArrayList<NewPhone> newPhones = new ArrayList<>();
    static ArrayList<OldPhone> oldPhones = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static {
        newPhones.add(new NewPhone("DTM001", "iPhone 15", 30000000, 12, "Apple", 10));
        newPhones.add(new NewPhone("DTM002", "Samsung S24", 25000000, 12, "Samsung", 5));

        oldPhones.add(new OldPhone("DTC001", "iPhone 11", 8000000, 3, "Apple", 85, "Scratched"));
        oldPhones.add(new OldPhone("DTC002", "Xiaomi Note 10", 3000000, 1, "Xiaomi", 90, "Like New"));
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n-- PHONE STORE MANAGEMENT PROGRAM --");
            System.out.println("1. View phone list");
            System.out.println("2. Add new phone");
            System.out.println("3. Update phone");
            System.out.println("4. Delete phone");
            System.out.println("5. Sort by price");
            System.out.println("6. Search");
            System.out.println("7. Calculate total");
            System.out.println("8. Discount for old phones");
            System.out.println("9. Exit");
            System.out.print("Choose a function: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    viewMenu();
                    break;
                case 2:
                    addMenu();
                    break;
                case 3:
                    updateFunction();
                    break;
                case 4:
                    deleteFunction();
                    break;
                case 9:
                    System.out.println("Program ended!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 9);
    }

    public static void viewMenu() {
        int choice;
        do {
            System.out.println("\n--- View List Menu ---");
            System.out.println("1. View all");
            System.out.println("2. View old phones");
            System.out.println("3. View new phones");
            System.out.println("4. Back to main menu");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("=== LIST OF NEW PHONES ===");
                    for (NewPhone p : newPhones) p.displayData();
                    System.out.println("=== LIST OF OLD PHONES ===");
                    for (OldPhone p : oldPhones) p.displayData();
                    break;
                case 2:
                    System.out.println("=== OLD PHONES ===");
                    for (OldPhone p : oldPhones) p.displayData();
                    break;
                case 3:
                    System.out.println("=== NEW PHONES ===");
                    for (NewPhone p : newPhones) p.displayData();
                    break;
                case 4:
                    break;
            }
        } while (choice != 4);
    }

    public static void addMenu() {
        int choice;
        do {
            System.out.println("\n--- Add Phone Menu ---");
            System.out.println("1. Add Old Phone");
            System.out.println("2. Add New Phone");
            System.out.println("3. Back to main menu");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    OldPhone oldP = new OldPhone();
                    String idOld = String.format("DTC%03d", oldPhones.size() + 1);
                    oldP.setId(idOld);
                    System.out.println("Enter details for ID: " + idOld);
                    oldP.inputData(sc);
                    oldPhones.add(oldP);
                    System.out.println("Added successfully!");
                    break;

                case 2:
                    NewPhone newP = new NewPhone();
                    String idNew = String.format("DTM%03d", newPhones.size() + 1);
                    newP.setId(idNew);
                    System.out.println("Enter details for ID: " + idNew);
                    newP.inputData(sc);
                    newPhones.add(newP);
                    System.out.println("Added successfully!");
                    break;
                case 3:
                    break;
            }
        } while (choice != 3);
    }

    public static void updateFunction() {
        System.out.print("Enter ID to update (e.g., DTM001, DTC001): ");
        String id = sc.nextLine();

        if (id.length() != 6 || (!id.startsWith("DTM") && !id.startsWith("DTC"))) {
            System.out.println("Error: ID must be 6 characters and start with DTM or DTC.");
            return;
        }

        boolean found = false;

        if (id.startsWith("DTM")) {
            for (NewPhone p : newPhones) {
                if (p.getId().equals(id)) {
                    System.out.println("Found! Enter new details:");
                    p.inputData(sc);
                    found = true;
                    System.out.println("Updated successfully!");
                    break;
                }
            }
        }
        else if (id.startsWith("DTC")) {
            for (OldPhone p : oldPhones) {
                if (p.getId().equals(id)) {
                    System.out.println("Found! Enter new details:");
                    p.inputData(sc);
                    found = true;
                    System.out.println("Updated successfully!");
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("ID not found: " + id);
        }
    }

    public static void deleteFunction() {
        System.out.print("Enter ID to delete: ");
        String id = sc.nextLine();

        if (id.length() != 6 || (!id.startsWith("DTM") && !id.startsWith("DTC"))) {
            System.out.println("Error: Invalid ID format.");
            return;
        }

        boolean found = false;

        if (id.startsWith("DTM")) {
            for (int i = 0; i < newPhones.size(); i++) {
                if (newPhones.get(i).getId().equals(id)) {
                    found = true;
                    System.out.print("Are you sure you want to delete (Yes/No)? ");
                    String confirm = sc.nextLine();
                    if (confirm.equalsIgnoreCase("Yes")) {
                        newPhones.remove(i);
                        System.out.println("Deleted successfully!");
                    } else {
                        System.out.println("Deletion cancelled.");
                    }
                    break;
                }
            }
        } else if (id.startsWith("DTC")) {
            for (int i = 0; i < oldPhones.size(); i++) {
                if (oldPhones.get(i).getId().equals(id)) {
                    found = true;
                    System.out.print("Are you sure you want to delete (Yes/No)? ");
                    String confirm = sc.nextLine();
                    if (confirm.equalsIgnoreCase("Yes")) {
                        oldPhones.remove(i);
                        System.out.println("Deleted successfully!");
                    } else {
                        System.out.println("Deletion cancelled.");
                    }
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("ID not found for deletion.");
        }
    }
}
