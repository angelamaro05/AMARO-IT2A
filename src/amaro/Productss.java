package amaro;

import java.util.Scanner;

public class Productss {
    public void genProducts() {
        Scanner sc = new Scanner(System.in);
        Product[] products = new Product[100];
        
        System.out.print("Enter number of products: ");
        int numProducts = sc.nextInt();
        
        for (int i = 0; i < numProducts; i++) {
            System.out.println("Enter details of product " + (i + 1) + ": ");
            System.out.print("ID: ");
            int id = sc.nextInt();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            System.out.print("Stock: ");
            int stock = sc.nextInt();
            System.out.print("Sold: ");
            int sold = sc.nextInt();
            
            products[i] = new Product();
            products[i].addProduct(id, price, name, stock, sold);
        }
        
        System.out.println("Product details:");
        for (int i = 0; i < numProducts; i++) {
            products[i].viewProduct();
        }

        sc.close();
    }
}