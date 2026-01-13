package phonemnm2;

import java.util.ArrayList;
import java.util.Scanner;

public class StoreManagement {
    // Use a single ArrayList for all phones (Polymorphism)
    static ArrayList<Phone> phones = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Initialize sample data
    static {
        phones.add(new NewPhone("DTM001", "iPhone 15", 30000000, 12, "Apple", 10));
        phones.add(new NewPhone("DTM002", "Samsung S24", 25000000, 12, "Samsung", 5));

        phones.add(new OldPhone("DTC001", "iPhone 11", 8000000, 3, "Apple", 85, "Scratched"));
        phones.add(new OldPhone("DTC002", "Xiaomi Note 10", 3000000, 1, "Xiaomi", 90, "Like New"));
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n-- PHONE STORE MANAGEMENT PROGRAM --");
            System.out.println("1. View phone list");
            System.out.println("2. Add new phone");
            System.out.println("3. Update phone");
            System.out.println("4. Delete phone");
            System.out.println("5. Sort by price"); // Task 5
            System.out.println("6. Search");        // Task 6
            System.out.println("7. Calculate total");
            System.out.println("8. Discount for old phones");
            System.out.println("9. Exit");
            System.out.print("Choose a function: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: viewMenu(); break;
                case 2: addMenu(); break;
                case 3: updateFunction(); break;
                case 4: deleteFunction(); break;
                case 5: sortMenu(); break;
                case 6: searchMenu(); break;
                case 9: System.out.println("Program ended!"); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 9);
    }

    // --- FUNCTION 1: VIEW ---
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
                    System.out.println("=== ALL PHONES ===");
                    for (Phone p : phones) p.displayData();
                    break;
                case 2:
                    System.out.println("=== OLD PHONES ===");
                    for (Phone p : phones) {
                        if (p instanceof OldPhone) p.displayData();
                    }
                    break;
                case 3:
                    System.out.println("=== NEW PHONES ===");
                    for (Phone p : phones) {
                        if (p instanceof NewPhone) p.displayData();
                    }
                    break;
                case 4: break;
            }
        } while (choice != 4);
    }

    // --- FUNCTION 2: ADD ---
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
                    addOldPhone();
                    break;
                case 2:
                    addNewPhone();
                    break;
                case 3: break;
            }
        } while (choice != 3);
    }

    private static void addOldPhone() {
        OldPhone oldP = new OldPhone();
        // Count specifically OldPhones to generate ID
        int count = 0;
        for(Phone p : phones) {
            if (p instanceof OldPhone) count++;
        }
        String id = String.format("DTC%03d", count + 1);
        oldP.setId(id);
        System.out.println("Enter details for ID: " + id);
        oldP.inputData(sc);
        phones.add(oldP);
        System.out.println("Added successfully!");
    }

    private static void addNewPhone() {
        NewPhone newP = new NewPhone();
        // Count specifically NewPhones to generate ID
        int count = 0;
        for(Phone p : phones) {
            if (p instanceof NewPhone) count++;
        }
        String id = String.format("DTM%03d", count + 1);
        newP.setId(id);
        System.out.println("Enter details for ID: " + id);
        newP.inputData(sc);
        phones.add(newP);
        System.out.println("Added successfully!");
    }

    // --- FUNCTION 3: UPDATE ---
    public static void updateFunction() {
        System.out.print("Enter ID to update: ");
        String id = sc.nextLine();
        boolean found = false;

        for (Phone p : phones) {
            if (p.getId().equals(id)) {
                System.out.println("Found! Enter new details:");
                p.inputData(sc);
                found = true;
                System.out.println("Updated successfully!");
                break;
            }
        }
        if (!found) System.out.println("ID not found: " + id);
    }

    // --- FUNCTION 4: DELETE ---
    public static void deleteFunction() {
        System.out.print("Enter ID to delete: ");
        String id = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < phones.size(); i++) {
            if (phones.get(i).getId().equals(id)) {
                found = true;
                System.out.print("Are you sure? (Yes/No): ");
                String confirm = sc.nextLine();
                if (confirm.equalsIgnoreCase("Yes")) {
                    phones.remove(i);
                    System.out.println("Deleted successfully!");
                }
                break;
            }
        }
        if (!found) System.out.println("ID not found.");
    }

    // --- FUNCTION 5: SORT BY PRICE ---
    public static void sortMenu() {
        int choice;
        System.out.println("\n--- Sort by Price ---");
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        System.out.print("Choose: ");
        choice = sc.nextInt();
        sc.nextLine();

        // Interchange Sort Algorithm
        for (int i = 0; i < phones.size() - 1; i++) {
            for (int j = i + 1; j < phones.size(); j++) {
                boolean swap = false;
                double priceI = phones.get(i).getPrice();
                double priceJ = phones.get(j).getPrice();

                if (choice == 1) { // Ascending
                    if (priceI > priceJ) swap = true;
                } else if (choice == 2) { // Descending
                    if (priceI < priceJ) swap = true;
                }

                if (swap) {
                    Phone temp = phones.get(i);
                    phones.set(i, phones.get(j));
                    phones.set(j, temp);
                }
            }
        }
        System.out.println("Sort complete! Please check 'View list'.");
    }

    // --- FUNCTION 6: SEARCH ---
    public static void searchMenu() {
        int choice;
        do {
            System.out.println("\n--- Search Menu ---");
            System.out.println("1. Search All Phones");
            System.out.println("2. Search Old Phones");
            System.out.println("3. Search New Phones");
            System.out.println("4. Back");
            System.out.print("Choose scope: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 4) break;
            if (choice < 1 || choice > 3) continue;

            System.out.println("   1. Search by Price range");
            System.out.println("   2. Search by Name");
            System.out.print("   Choose criteria: ");
            int subChoice = sc.nextInt();
            sc.nextLine();

            if (subChoice == 1) {
                System.out.print("Enter min price: ");
                double min = sc.nextDouble();
                System.out.print("Enter max price: ");
                double max = sc.nextDouble();
                sc.nextLine();

                System.out.println("--- Results ---");
                for (Phone p : phones) {
                    boolean typeMatch = checkType(p, choice);
                    if (typeMatch && p.getPrice() >= min && p.getPrice() <= max) {
                        p.displayData();
                    }
                }
            } else if (subChoice == 2) {
                System.out.print("Enter name to search: ");
                String keyword = sc.nextLine().toLowerCase();

                System.out.println("--- Results ---");
                for (Phone p : phones) {
                    boolean typeMatch = checkType(p, choice);
                    if (typeMatch && p.getName().toLowerCase().contains(keyword)) {
                        p.displayData();
                    }
                }
            }
        } while (choice != 4);
    }

    // Helper: Check if phone matches the selected scope (All/Old/New)
    private static boolean checkType(Phone p, int choice) {
        if (choice == 1) return true; // All
        if (choice == 2 && p instanceof OldPhone) return true;
        if (choice == 3 && p instanceof NewPhone) return true;
        return false;
    }
}
