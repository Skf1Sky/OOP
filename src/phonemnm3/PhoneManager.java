package phonemnm3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class PhoneManager {
    private ArrayList<MobilePhone> list = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // 1. Add new phones
    public void addPhone() {
        while (true) {
            System.out.print("Enter ID: "); String id = sc.nextLine();
            System.out.print("Enter Name: "); String name = sc.nextLine();
            System.out.print("Enter Brand: "); String brand = sc.nextLine();

            int battery = 0;
            double price = 0;

            try {
                System.out.print("Enter Battery (mAh): ");
                battery = Integer.parseInt(sc.nextLine());

                System.out.print("Enter Price: ");
                price = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format! Please try again.");
                continue;
            }

            list.add(new MobilePhone(id, name, price, brand, battery));

            System.out.print("Do you want to add another? (Y/N): ");
            if (sc.nextLine().equalsIgnoreCase("N")) break;
        }
    }

    // 2. Display all phones
    public void displayList() {
        if (list.isEmpty()) {
            System.out.println("The list is empty!");
            return;
        }
        System.out.println("--- PHONE LIST ---");
        for (MobilePhone p : list) {
            p.displayInfo();
        }
    }

    // 3. Search by ID
    public void searchById() {
        System.out.print("Enter ID to search: "); String searchId = sc.nextLine();
        boolean found = false;
        for (MobilePhone p : list) {
            if (p.getId().equalsIgnoreCase(searchId)) {
                p.displayInfo();
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Phone with ID " + searchId + " not found.");
    }

    // 4. Delete by ID
    public void deleteById() {
        System.out.print("Enter ID to delete: "); String deleteId = sc.nextLine();
        MobilePhone foundPhone = null;
        for (MobilePhone p : list) {
            if (p.getId().equalsIgnoreCase(deleteId)) {
                foundPhone = p;
                break;
            }
        }

        if (foundPhone != null) {
            list.remove(foundPhone);
            System.out.println("Deleted successfully!");
        } else {
            System.out.println("ID not found to delete.");
        }
    }

    // 5. Update by ID
    public void updateById() {
        System.out.print("Enter ID to update: "); String updateId = sc.nextLine();
        for (MobilePhone p : list) {
            if (p.getId().equalsIgnoreCase(updateId)) {
                System.out.print("Enter new Name: "); p.setName(sc.nextLine());
                System.out.print("Enter new Brand: "); p.setBrand(sc.nextLine());

                try {
                    System.out.print("Enter new Battery: ");
                    p.setBatteryCapacity(Integer.parseInt(sc.nextLine()));
                    System.out.print("Enter new Price: ");
                    p.setPrice(Double.parseDouble(sc.nextLine()));
                } catch (Exception e) {
                    System.out.println("Invalid input! Update failed.");
                    return;
                }

                System.out.println("Updated successfully!");
                return;
            }
        }
        System.out.println("ID not found.");
    }

    // 6. Search by Price Range
    public void searchByPriceRange() {
        try {
            System.out.print("Enter Min Price: "); double min = Double.parseDouble(sc.nextLine());
            System.out.print("Enter Max Price: "); double max = Double.parseDouble(sc.nextLine());
            boolean found = false;

            System.out.println("--- SEARCH RESULTS ---");
            for (MobilePhone p : list) {
                if (p.getPrice() >= min && p.getPrice() <= max) {
                    p.displayInfo();
                    found = true;
                }
            }
            if (!found) System.out.println("No phones found in this price range.");

        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }

    // 7. Sort by Price (Ascending)
    public void sortByPriceAsc() {
        Collections.sort(list, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        System.out.println("Sorted by price (ascending). Please select 'Display' to view.");
    }

    // 8. Top 5 Highest Price
    public void getTop5HighestPrice() {
        ArrayList<MobilePhone> tempList = new ArrayList<>(list);
        Collections.sort(tempList, (p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()));

        System.out.println("--- TOP 5 EXPENSIVE PHONES ---");
        int count = 0;
        for (MobilePhone p : tempList) {
            p.displayInfo();
            count++;
            if (count == 5) break;
        }
    }

    // Dummy Data for testing
    public void generateDummyData() {
        list.add(new MobilePhone("P001", "iPhone 13", 700, "Apple", 3200));
        list.add(new MobilePhone("P002", "Galaxy S21", 600, "Samsung", 4000));
        list.add(new MobilePhone("P003", "Pixel 6", 550, "Google", 4600));
        list.add(new MobilePhone("P004", "Xiaomi 12", 500, "Xiaomi", 4500));
        list.add(new MobilePhone("P005", "iPhone 15 Pro", 1200, "Apple", 3274));
        list.add(new MobilePhone("P006", "Galaxy S24", 1000, "Samsung", 5000));
    }
}
