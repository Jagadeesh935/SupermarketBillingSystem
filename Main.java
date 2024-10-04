package com.jk;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    private static SuperMarket market = new SuperMarket();

    public static void main(String[] args) {

        market.addProduct("Soap", 30, 80);
        market.addProduct("Shampoo", 2, 900);
        market.addProduct("Clip", 10, 500);
        market.addProduct("Face Wash", 70, 30);
        market.addProduct("Hair Wax", 120, 40);

        boolean run = true;
        while (run) {
            display();
            System.out.println();
            switch (sc.nextInt()) {
                case 1:
                    runAdminOptions(); // done
                    break;
                case 2:
                    runCustomerOperations();
                    break;
                case 3:
                    run = false;
                    break;
            }
        }

        System.out.println("Thank you for Shopping...");

    }

    private static void runCustomerOperations() {
        // TODO Auto-generated method stub
        boolean run = true;
        while (run) {
            displayCustomerMenu();
            System.out.println();
            switch (sc.nextInt()) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    searchProductByIdOrName();
                    break;
                case 3:
                    addProductToCart();
                    break;
                case 4:
                    viewCart();
                    break;
                case 5:
                    removeProductFromCart();
                    break;
                case 6:
                    updateProductQuantityInCart();
                    break;
                case 7:
                    checkout();
                    break;
                case 8:
                    viewPurchaseHistory();
                    break;
                case 9:
                    displayCustomerInfo();
                    break;
                case 10:
                    run = false;
                    break;
            }
        }
    }

    private static void displayCustomerInfo() {
        System.out.println("Enter Customer phone number:");
        market.displayCustomerInfo(sc.next());
    }

    private static void viewPurchaseHistory() {
        // TODO Auto-generated method stub
        System.out.println("Enter Customer Id");
        market.viewPurchaseHistory(sc.nextInt());
    }

    private static void checkout() {
        System.out.println("Entre Customer name");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Enter phone number:");
        market.checkout(name, sc.next());

    }

    private static void updateProductQuantityInCart() {
        // TODO Auto-generated method stub
        System.out.println("Enter product id:");
        int id = sc.nextInt();
        System.out.println("Enter quantity:");
        market.updateProductQuantityInCart(id, sc.nextInt());
    }

    private static void removeProductFromCart() {
        // TODO Auto-generated method stub
        System.out.println("Enter product id:");
        market.removeProductFromCart(sc.nextInt());
    }

    private static void viewCart() {
        // TODO Auto-generated method stub
        market.viewCart();
    }

    private static void addProductToCart() {
        // TODO Auto-generated method stub
        System.out.println("Enter product id:");
        int id = sc.nextInt();
        System.out.println("Enter quantity:");
        market.addProductTocart(id, sc.nextInt());
    }

    private static void runAdminOptions() {

        System.out.println("Enter the username: ");
        String user = sc.next();
        System.out.println("Enter the password: ");
        String pass = sc.next();

        if (market.login(user, pass)) {

            boolean run = true;
            while (run) {
                displayAdminMenu();
                System.out.println();
                switch (sc.nextInt()) {
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        updateProduct();
                        break;
                    case 3:
                        removeProduct();
                        break;
                    case 4:
                        viewProducts();
                        break;
                    case 5:
                        searchProductByIdOrName();
                        break;
                    case 6:
                        reprintTicket();
                        break;
                    case 7:
                        run = false;
                        break;
                }
            }
        }
    }

    private static void reprintTicket() {
        System.out.println("Enter Transaction id:");
        market.reprintTicket(sc.nextInt());
    }

    private static void searchProductByIdOrName() {
        // TODO Auto-generated method stub
        System.out.println("Enter product id or name:");
        try {
            int id = sc.nextInt();
            market.viewProductDetails(id);
        } catch (InputMismatchException e) {
            String name = sc.next();
            market.viewProductDetails(name);
        }
    }

    private static void viewProducts() {
        // TODO Auto-generated method stub
        market.viewProducts();
    }

    private static void removeProduct() {
        // TODO Auto-generated method stub
        System.out.println("Enter Product Id:");
        int id = sc.nextInt();
        System.out.println("Are you sure you want to remove this product (y/n)");
        if (sc.next().equals("y"))
            market.removeProduct(id);
    }

    private static void updateProduct() {
        // TODO Auto-generated method stub
        System.out.println("Enter the product Id:");
        int id = sc.nextInt();
        System.out.println("Enter the price");
        int price = sc.nextInt();
        System.out.println("Enter the quantity");
        int quantity = sc.nextInt();
        market.updateProduct(id, price, quantity);
    }

    private static void addProduct() {
        // TODO Auto-generated method stub
        System.out.println("Enter product name: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Enter price per unit:");
        int price = sc.nextInt();
        System.out.println("Enter the quantity:");
        int quantity = sc.nextInt();
        market.addProduct(name, price, quantity);
    }

    private static void display() {
        System.out.println();
        System.out.println("""
                Choose one from below:
                    1 => Admin Login
                    2 => Customer Operations
                    3 => Exit
                """);
    }

    private static void displayAdminMenu() {
        System.out.println();
        System.out.println("""
                Choose one from below:
                    1 => Add Products
                    2 => Update Products
                    3 => Remove Products
                    4 => View Products
                    5 => Search Product by ID or Name
                    6 => Reprint ticket
                    7 => Logout
                """);
    }

    private static void displayCustomerMenu() {
        System.out.println();
        System.out.println("""
                Choose one from below:
                    1  => View Products
                    2  => Search Products by ID or Name
                    3  => Add Product to Cart
                    4  => View Cart
                    5  => Remove Products form Cart
                    6  => Update Product quantity in cart
                    7  => Checkout
                    8  => View Purchase History
                    9  => Display Cusotmer Info
                    10 => Exit
                """);
    }


}
