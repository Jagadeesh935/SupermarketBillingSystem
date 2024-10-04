package com.jk;

public class Billing {
    private static int idTracker = 1;
    private int billId;
    private Customer customer;
    private ShoppingCart cart;
    private int totalAmount;
    private double tax;
    private double finalAmount;
    private double discount;
    private boolean isPaymentDone = false;

    public Billing(ShoppingCart cart) {
        this.billId = idTracker++;
        this.cart = cart;
        this.totalAmount = this.cart.calculateTotalPrice();
        this.finalAmount = this.totalAmount;
    }

    public void generateBill() {
        System.out.println("Bill:\n" + "------");
        System.out.println("Customer Name:" + this.customer.getCustomerName());
        System.out.println("Bill Id: " + this.billId);
        System.out.println();
        System.out.println("  ID         Products        Price        Qty        total");
        cart.getCartItems().forEach(item -> {
            System.out.printf("\n%5d %-20s %10d %10d %10d", item.getProduct().getProductId(),
                    item.getProduct().getProductName(), item.getProduct().getPrice(), item.getQuantity(),
                    item.getSubTotal());
        });
        System.out.println("\n-----------------------------------------------------------");
        System.out.printf("%45s %13d", " ", this.totalAmount);
        System.out.printf("\n%45s %13d", "Tax added", (int) this.tax);
        System.out.printf("\n%45s %13d", "Discount deducted", (int) this.discount);
        System.out.printf("\n%45s %13d", "Total amount", (int) this.finalAmount);
    }

    public void applyDiscount(int rate) {
        this.discount = this.totalAmount * rate / 100;
        this.finalAmount -= this.discount;
    }

    public void calculateTax(int rate) {
        this.tax = this.totalAmount * rate / 100;
        this.finalAmount += this.tax;
    }

    public void completePayment() {
        this.isPaymentDone = true;
    }

    @Override
    public String toString() {
        return "Billing [billId=" + billId + ", finalAmount=" + finalAmount + ", isPaymentDone=" + isPaymentDone + "]";
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getFinalAmount() {
        return finalAmount;
    }
}