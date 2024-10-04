package com.jk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SuperMarket {
    Scanner sc = new Scanner(System.in);
    private List<Product> products = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();
    private List<Admin> admins = new ArrayList<>();
    private ShoppingCart currentShoppingCart;

    public SuperMarket() {
        admins.add(new Admin("admin", "admin"));
    }

    public boolean login(String username, String password) {
        for (Admin admin : admins) {
            if (admin.getUsername().equals(username)) {
                return admin.login(username, password);
            }
        }
        System.out.println("Username doesn't exist...");
        return false;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void addProduct(String name, int price, int quantity) {
        products.add(new Product(name, price, quantity));
        System.out.println("New Product created");
    }

    public Product getProduct(int id) {
        // TODO Auto-generated method stub
        for (Product p : products) {
            if (p.getProductId() == id)
                return p;
        }
        return null;
    }

    public Product getProduct(String name) {
        // TODO Auto-generated method stub
        for (Product p : products) {
            if (p.getProductName().equals(name))
                return p;
        }
        System.out.println("Product doesn't exist");
        return null;
    }

    public void updateProduct(int id, int price, int quantity) {
        // TODO Auto-generated method stub
        Product p = getProduct(id);
        if (p != null) {
            p.setPrice(price);
            p.setQuantity(quantity);
            System.out.println("Product Updated successfully");
        }
    }

    public void removeProduct(int id) {
        // TODO Auto-generated method stub
        Product p = getProduct(id);
        if (p != null)
            products.remove(p);
        System.out.println("Product removed");
    }

    public void viewProducts() {
        // TODO Auto-generated method stub
        System.out.println("  Id     Products              Price      Quantity ");
        products.forEach(item -> {
            System.out.printf("\n%5d  %-20s %10d %10s", item.getProductId(), item.getProductName(), item.getPrice(),
                    (item.getQuantity()==0)? "Unavailable" : String.valueOf(item.getQuantity()));
        });
        System.out.println();
    }

    public void viewProductDetails(int id) {
        // TODO Auto-generated method stub
        getProduct(id).getProductDetails();
    }

    public void viewProductDetails(String name) {
        getProduct(name).getProductDetails();
    }

    public void addProductTocart(int id, int quantity) {
        // TODO Auto-generated method stub
        if (this.currentShoppingCart == null)
            this.currentShoppingCart = new ShoppingCart();
        for (Product p : products){
            if (p.getProductId() == id){
                if (quantity <= p.getQuantity()){
                    p.setQuantity(p.getQuantity() - quantity);
                    this.currentShoppingCart.addItemToCart(new CartItem(getProduct(id), quantity));
                }else {
                    System.out.println("Product Quantity insufficient");
                }
            }
        }
    }

    public void viewCart() {
        // TODO Auto-generated method stub
        System.out.println("  Id     Products              Price        Quantity    ");
        this.currentShoppingCart.getCartItems().forEach(item -> {
            System.out.printf("\n%5d  %-20s %10d %10d", item.getProduct().getProductId(),
                    item.getProduct().getProductName(), item.getProduct().getPrice(), item.getQuantity());
        });
    }

    public void removeProductFromCart(int id) {
        Product p = getProduct(id);
        CartItem item = this.currentShoppingCart.getCartItemById(p);
        if (item != null)
            this.currentShoppingCart.removeItemFromCart(item);
    }

    public void updateProductQuantityInCart(int id, int quantity) {
        Product p = getProduct(id);
        CartItem item = null;
        if (p != null)
            item = this.currentShoppingCart.getCartItemById(p);
        if (item != null) {
            item.setQuantity(quantity);
            System.out.println("Quantity updated");
        }

    }

    public Customer getCustomer(String phone) {
        for (Customer c : customers) {
            if (c.getPhone().equals(phone))
                return c;
        }
        return null;
    }

    public void checkout(String name, String phone) {
        Billing bill = new Billing(this.currentShoppingCart);
        bill.applyDiscount(2);
        bill.calculateTax(5);
        Customer customer = getCustomer(phone);
        boolean isNewCustomer = false;
        if (customer == null) {
            customer = new Customer(name, phone);
            isNewCustomer = true;
        }
        bill.setCustomer(customer);
        System.out.println("Total amount: " + bill.getFinalAmount());
        System.out.println("\nDo you want to proceed with the payment or cancel? (p/c)");
        if (sc.next().equals("p")) {
            if (isNewCustomer) {
                customers.add(customer);
            }
            bill.completePayment();
            System.out.println("Payment done");
            bill.generateBill();
            System.out.println();
            Transaction t = new Transaction(customer, bill);
            transactions.add(t);

        } else {
            System.out.println("Transaction cancelled");
        }

        this.currentShoppingCart = null;

    }

    public Customer getCustomerById(int id) {
        for (Customer c : customers) {
            if (c.getCustomerId() == id) {
                return c;
            }
        }
        System.out.println("Customer not found");
        return null;
    }

    public void viewPurchaseHistory(int id) {
        Customer customer = getCustomerById(id);
        for (Transaction t : transactions) {
            if (t.getCustomer() == customer)
                t.displayTransactionDetails();
        }
    }

    public void displayCustomerInfo(String phone) {
        System.out.println(customers);
        for (Customer c : customers) {
            if (c.getPhone().equals(phone)) {
                c.displayCustomerDetails();
                break;
            }
        }
    }

    public void reprintTicket(int id) {
        System.out.println("Duplicate bill");
        for (Transaction t : transactions){
            if (t.getTransactionId() == id){
                t.getBill().generateBill();
            }
        }
    }
}