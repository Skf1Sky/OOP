package phonemnm3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhoneManager manager = new PhoneManager();
        manager.generateDummyData(); // Load dummy data

        while (true) {
            System.out.println("\n========= PHONE MANAGEMENT SYSTEM =========");
            System.out.println("1. Add new phone");
            System.out.println("2. Display all phones");
            System.out.println("3. Search by ID");
            System.out.println("4. Delete by ID");
            System.out.println("5. Update info by ID");
            System.out.println("6. Search by Price Range");
            System.out.println("7. Sort by Price (Ascending)");
            System.out.println("8. Top 5 Highest Price");
            System.out.println("0. Exit");
            System.out.println("===========================================");
            System.out.print(">> Select function: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid number!");
                continue;
            }

            switch (choice) {
                case 1: manager.addPhone(); break;
                case 2: manager.displayList(); break;
                case 3: manager.searchById(); break;
                case 4: manager.deleteById(); break;
                case 5: manager.updateById(); break;
                case 6: manager.searchByPriceRange(); break;
                case 7:
                    manager.sortByPriceAsc();
                    manager.displayList();
                    break;
                case 8: manager.getTop5HighestPrice(); break;
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default: System.out.println("Invalid function! Please choose 0-8.");
            }
        }
    }
}
