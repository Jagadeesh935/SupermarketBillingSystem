package com.jk;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        // TODO Auto-generated constructor stub
        this.product = product;
        this.quantity = quantity;
    }

    public int getSubTotal() {
        return product.getPrice() * quantity;
    }


    public Product getProduct() {
        return product;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
