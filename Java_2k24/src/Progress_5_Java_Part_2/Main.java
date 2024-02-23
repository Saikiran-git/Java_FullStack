package Progress_5_Java_Part_2;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Collecting customer details
        System.out.println("Enter customer ID:");
        String customerID = scanner.nextLine();
        
        System.out.println("Enter customer name:");
        String name = scanner.nextLine();
        
        System.out.println("Enter customer email:");
        String email = scanner.nextLine();
        
        Customer customer = new Customer(customerID, name, email);
        
        // Predefined products
        Map<Integer, Product> products = new HashMap<>();
        products.put(1, new ElectronicsProduct("E001", "Laptop", 1200.00, "High-performance gaming laptop"));
        products.put(2, new ElectronicsProduct("E002", "Smartphone", 800.00, "Latest model smartphone"));
        products.put(3, new ElectronicsProduct("E003", "Smartwatch", 250.00, "Water-resistant smartwatch"));
        products.put(4, new ElectronicsProduct("E004", "Tablet", 600.00, "10-inch screen tablet"));
        products.put(5, new ElectronicsProduct("E005", "E-reader", 150.00, "E-reader with backlight"));
        products.put(6, new ClothingProduct("CL001", "T-Shirt", 20.00, "Cotton graphic tee"));
        products.put(7, new ClothingProduct("CL002", "Jeans", 50.00, "Slim fit jeans"));
        products.put(8, new ClothingProduct("CL003", "Sweater", 40.00, "Wool blend sweater"));
        products.put(9, new ClothingProduct("CL004", "Jacket", 120.00, "Waterproof outdoor jacket"));
        products.put(10, new ClothingProduct("CL005", "Sneakers", 90.00, "High-performance athletic sneakers"));
        
        // Displaying available products
        System.out.println("Available products:");
        for(Map.Entry<Integer, Product> entry : products.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getName() + " - " + entry.getValue().getPrice() + " - " + entry.getValue().getDescription());
        }
        
        // User selects product to purchase
        System.out.println("Enter the serial number of the product to purchase:");
        int productChoice = scanner.nextInt();
        
        System.out.println("Enter quantity:");
        int quantity = scanner.nextInt();
        
        Product selectedProduct = products.get(productChoice);
        if(selectedProduct != null) {
            customer.purchaseProduct(selectedProduct, quantity);
        } else {
            System.out.println("Invalid product selection.");
        }
        
        // Displaying orders
        System.out.println("Orders for customer " + customer.getName() + ":");
        customer.viewOrders();
        
        scanner.close();
    }
}
