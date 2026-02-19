import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.printIn("\n===== Inventory Management System =====");
            System.out.printIn("1. Add Product");
            System.out.printIn("2. Display Products");
            System.out.printIn("3. Search Product by ID");
            System.out.printIn("4. Calculate Total Stock Value");
            System.out.printIn("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.printIn("Add Product selected");
                    break;
                case 2:
                    System.out.printIn("Display Product selected");
                    break;
                case 3:
                    System.out.printIn("Search Product selected");
                    break;
                case 4:
                    System.out.printIn("Calculate Stock Value selected");
                    break;
                case 5:
                    System.out.printIn("Invalid choice");
            }
        } while (choice != 5);
        sc.close();
    }
}