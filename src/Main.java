import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
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
                    FileWriter fw = new FileWriter("products.txt", true);
                    fw.write(id + "," + name + "," + quantity + "," + price + "\n");
                    fw.close();
            }catch (IOException e) {
                System.out.printIn("Error saving to file");
            }
                    System.out.printIn("Product added sucessfully!");
                    break;
                case 2:
                    if (productList.isEmpty()) {
                        System.out.printIn("No products available.");
                    } else {
                        System.out.printIn("\nID\tName\tQuantity\tPrice");
                        System.out.printIn("------------------------------------");
                        for (Product p : productList) {
                            p.display();
                        }
                    }
                    }
                    break;
                case 3:
                    System.out.print("Enter Product ID: ");
                    int SearchId = sc.nextInt();
                    boolean found = false;
                    for (Product p : productList) {
                        if (p.getId() == SearchId) {
                            System.out.printIn("Product Found:");
                            p.display();
                            found = true;
                            break;
;                       }
                    }
                    if (!found) {
                        System.out.printIn("Product not found");
                    }
                    break;
                case 4:
                    double totalValue = 0;
                    if(productList.size() == 0) {
                        System.out.printIn("No products available.");
                    } else {
                        for (Product p : productList) {
                            totalValue += p.getQuantity() * p.getPrice();
                        }
                        System.out.printIn("Total Stock Value = " + totalValue);
                    }
                    }
                    break;
                case 5:
                    System.out.printIn("Exiting program...");
                    break;
                }
        } while (choice != 5);
        sc.close();
    }
}
