import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

// Product Class
class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;

    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void display() {
        System.out.println(id + "\t" + name + "\t" + quantity + "\t\t" + price);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> productList = new ArrayList<>();

        // Load products from file
        try {
            File file = new File("products.txt");
            if (file.exists()) {
                Scanner fileReader = new Scanner(file);
                while (fileReader.hasNextLine()) {
                    String line = fileReader.nextLine();
                    String[] data = line.split(",");
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    int quantity = Integer.parseInt(data[2]);
                    double price = Double.parseDouble(data[3]);

                    Product p = new Product(id, name, quantity, price);
                    productList.add(p);
                }
                fileReader.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        int choice;
        do {
            System.out.println("\n===== Inventory Management System =====");
            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. Search Product by ID");
            System.out.println("4. Calculate Total Stock Value");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Product ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Product Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Quantity: ");
                        int quantity = sc.nextInt();

                        System.out.print("Enter Price: ");
                        double price = sc.nextDouble();

                        Product p = new Product(id, name, quantity, price);
                        productList.add(p);

                        FileWriter fw = new FileWriter("products.txt", true);
                        fw.write(id + "," + name + "," + quantity + "," + price + "\n");
                        fw.close();

                        System.out.println("Product added successfully!");
                    } catch (IOException e) {
                        System.out.println("Error saving to file.");
                    }
                    break;

                case 2:
                    if (productList.isEmpty()) {
                        System.out.println("No products available.");
                    } else {
                        System.out.println("\nID\tName\tQuantity\tPrice");
                        System.out.println("------------------------------------");
                        for (Product p : productList) {
                            p.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Product ID: ");
                    int searchId = sc.nextInt();
                    boolean found = false;

                    for (Product p : productList) {
                        if (p.getId() == searchId) {
                            System.out.println("Product Found:");
                            p.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Product not found.");
                    }
                    break;

                case 4:
                    double totalValue = 0;
                    if (productList.isEmpty()) {
                        System.out.println("No products available.");
                    } else {
                        for (Product p : productList) {
                            totalValue += p.getQuantity() * p.getPrice();
                        }
                        System.out.println("Total Stock Value = " + totalValue);
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
