package com.jk;

public class Transaction {
    private static int idTracker = 1;
    private int transactionId;
    private Customer customer;
    private Billing bill;

    public Transaction(Customer customer, Billing bill) {
        this.transactionId = idTracker++;
        this.customer = customer;
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "Transaction [transactionId=" + transactionId + ", customer=" + customer + ", Bill=" + bill + "]";
    }

    public void displayTransactionDetails() {
        System.out.println(this);
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Customer getCustomer() {
        return customer;
    }



    public Billing getBill() {
        return bill;
    }



}








