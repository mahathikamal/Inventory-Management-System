import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> productList = new ArrayList<>();
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
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    productList.add(p);
                    System.out.printIn("Product added sucessfully!");
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
