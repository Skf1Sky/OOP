package ss1_inther;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneManager {
    // 1. Initialize lists and ID counters
    static ArrayList<NewPhone> newPhoneList = new ArrayList<>();
    static ArrayList<OldPhone> oldPhoneList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    // Counters for auto-incrementing IDs
    static int newCount = 1;
    static int oldCount = 1;

    // Static block to add sample data
    static {
        newPhoneList.add(new NewPhone("NPH" + newCount++, "iPhone 15", 1200, 12, "Apple", 10));
        newPhoneList.add(new NewPhone("NPH" + newCount++, "Samsung S24", 1000, 12, "Samsung", 5));

        oldPhoneList.add(new OldPhone("OPH" + oldCount++, "iPhone 11", 400, 3, "Apple", 85, "Scratched screen"));
        oldPhoneList.add(new OldPhone("OPH" + oldCount++, "Note 10", 300, 1, "Samsung", 80, "No pen"));
    }

    public static void main(String[] args) {
        // Main Menu Loop
        while (true) {
            System.out.println("\n--- PHONE MANAGEMENT SYSTEM ---");
            System.out.println("1. View ss1_inther.Phone List");
            System.out.println("2. Add New ss1_inther.Phone");
            System.out.println("3. Update ss1_inther.Phone");
            System.out.println("4. Delete ss1_inther.Phone");
            System.out.println("5. Sort by Price");
            System.out.println("6. Search");
            System.out.println("7. Calculate Total (Not implemented)");
            System.out.println("8. Discount for Old Phones (Not implemented)");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1: menuViewList(); break;
                    case 2: menuAdd(); break;
                    case 3: updateFunction(); break;
                    case 4: deleteFunction(); break;
                    case 5: menuSort(); break;
                    case 6: menuSearch(); break;
                    case 9:
                        System.out.println("Exiting program. Goodbye!");
                        return;
                    default: System.out.println("Invalid option, please try again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
    }

    // --- SUB-MENUS AND FUNCTIONS ---

    // 1. View List Menu
    public static void menuViewList() {
        while (true) {
            System.out.println("\n--- VIEW LIST ---");
            System.out.println("1. View All");
            System.out.println("2. View Old Phones");
            System.out.println("3. View New Phones");
            System.out.println("4. Back to Main Menu");
            System.out.print("Select: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 4) break;

            switch (choice) {
                case 1:
                    System.out.println("--- NEW PHONES ---");
                    if(newPhoneList.isEmpty()) System.out.println("No data.");
                    for (NewPhone p : newPhoneList) System.out.println(p);

                    System.out.println("--- OLD PHONES ---");
                    if(oldPhoneList.isEmpty()) System.out.println("No data.");
                    for (OldPhone p : oldPhoneList) System.out.println(p);
                    break;
                case 2:
                    System.out.println("--- OLD PHONES ---");
                    for (OldPhone p : oldPhoneList) System.out.println(p);
                    break;
                case 3:
                    System.out.println("--- NEW PHONES ---");
                    for (NewPhone p : newPhoneList) System.out.println(p);
                    break;
            }
        }
    }

    // 2. Add New Menu
    public static void menuAdd() {
        while (true) {
            System.out.println("\n--- ADD NEW ---");
            System.out.println("1. Add Old ss1_inther.Phone");
            System.out.println("2. Add New ss1_inther.Phone");
            System.out.println("3. Back to Main Menu");
            System.out.print("Select: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 3) break;

            if (choice == 1 || choice == 2) {
                // Input common info
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Price: ");
                double price = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter Warranty (months): ");
                int warranty = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter Manufacturer: ");
                String manufact = scanner.nextLine();

                if (choice == 1) { // Add Old ss1_inther.Phone
                    System.out.print("Enter Battery Level (%): ");
                    int battery = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Description: ");
                    String desc = scanner.nextLine();

                    String newId = "OPH" + oldCount++; // Auto ID: OPH1, OPH2...
                    oldPhoneList.add(new OldPhone(newId, name, price, warranty, manufact, battery, desc));
                    System.out.println("Successfully added Old ss1_inther.Phone with ID: " + newId);

                } else { // Add New ss1_inther.Phone
                    System.out.print("Enter Quantity: ");
                    int qty = Integer.parseInt(scanner.nextLine());

                    String newId = "NPH" + newCount++; // Auto ID: NPH1, NPH2...
                    newPhoneList.add(new NewPhone(newId, name, price, warranty, manufact, qty));
                    System.out.println("Successfully added New ss1_inther.Phone with ID: " + newId);
                }
            }
        }
    }

    // 3. Update Function
    public static void updateFunction() {
        System.out.print("Enter ID to update (e.g., NPH1, OPH1): ");
        String id = scanner.nextLine();

        // Validation
        if (!id.startsWith("NPH") && !id.startsWith("OPH")) {
            System.out.println("Error: ID must start with 'NPH' or 'OPH'.");
            return;
        }

        boolean found = false;

        // Search in New ss1_inther.Phone List
        if (id.startsWith("NPH")) {
            for (NewPhone p : newPhoneList) {
                if (p.getId().equalsIgnoreCase(id)) {
                    found = true;
                    System.out.println("Updating " + p.getName());
                    System.out.print("New Name: "); p.setName(scanner.nextLine());
                    System.out.print("New Price: "); p.setPrice(Double.parseDouble(scanner.nextLine()));
                    System.out.print("New Quantity: "); p.setQuantity(Integer.parseInt(scanner.nextLine()));
                    System.out.println("Update successful!");
                    break;
                }
            }
        }
        // Search in Old ss1_inther.Phone List
        else if (id.startsWith("OPH")) {
            for (OldPhone p : oldPhoneList) {
                if (p.getId().equalsIgnoreCase(id)) {
                    found = true;
                    System.out.println("Updating " + p.getName());
                    System.out.print("New Name: "); p.setName(scanner.nextLine());
                    System.out.print("New Price: "); p.setPrice(Double.parseDouble(scanner.nextLine()));
                    System.out.print("New Battery Level: "); p.setBatteryLevel(Integer.parseInt(scanner.nextLine()));
                    System.out.println("Update successful!");
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("ID " + id + " not found.");
        }
    }

    // 4. Delete Function
    public static void deleteFunction() {
        System.out.print("Enter ID to delete: ");
        String id = scanner.nextLine();

        if (!id.startsWith("NPH") && !id.startsWith("OPH")) {
            System.out.println("Error: Invalid ID format.");
            return;
        }

        Phone phoneToDelete = null;
        boolean isNewPhone = false;

        // Find the object
        if (id.startsWith("NPH")) {
            for (NewPhone p : newPhoneList) {
                if (p.getId().equalsIgnoreCase(id)) {
                    phoneToDelete = p;
                    isNewPhone = true;
                    break;
                }
            }
        } else {
            for (OldPhone p : oldPhoneList) {
                if (p.getId().equalsIgnoreCase(id)) {
                    phoneToDelete = p;
                    break;
                }
            }
        }

        // Perform delete
        if (phoneToDelete != null) {
            System.out.println("Found: " + phoneToDelete.getName());
            System.out.print("Are you sure you want to delete? (Y/N): ");
            String confirm = scanner.nextLine();

            if (confirm.equalsIgnoreCase("Y")) {
                if (isNewPhone) newPhoneList.remove(phoneToDelete);
                else oldPhoneList.remove(phoneToDelete);
                System.out.println("Deleted successfully!");
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("ss1_inther.Phone with ID " + id + " not found.");
        }
    }

    // 5. Sort Menu (UI Only)
    public static void menuSort() {
        while (true) {
            System.out.println("\n--- SORT ---");
            System.out.println("1. Ascending (Low to High)");
            System.out.println("2. Descending (High to Low)");
            System.out.println("3. Back to Main Menu");
            System.out.print("Select: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 3) break;
            System.out.println("Feature under development...");
        }
    }

    // 6. Search Menu (Nested Menus)
    public static void menuSearch() {
        while (true) {
            System.out.println("\n--- SEARCH ---");
            System.out.println("1. Search All Phones");
            System.out.println("2. Search Old Phones");
            System.out.println("3. Search New Phones");
            System.out.println("4. Back to Main Menu");
            System.out.print("Select: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 4) break;

            if (choice >= 1 && choice <= 3) {
                menuSearchCriteria(); // Call Level 3 Menu
            }
        }
    }

    // Level 3 Menu for Search
    public static void menuSearchCriteria() {
        while (true) {
            System.out.println("\n   >> SEARCH CRITERIA <<");
            System.out.println("   1. Search by Price Range");
            System.out.println("   2. Search by Name");
            System.out.println("   3. Search by Manufacturer");
            System.out.println("   4. Back to Search Menu");
            System.out.print("   Select: ");
            int subChoice = Integer.parseInt(scanner.nextLine());

            if (subChoice == 4) break;
            System.out.println("   Feature under development...");
        }
    }
}