package com.jk;

public class Product {
	private static int idTracker = 1;
	private int productId;
	private String productName;
	private int price;
	private int quantity;

	public Product(String name, int price, int quantity) {
		// TODO Auto-generated constructor stub
		this.productId = idTracker++;
		this.productName = name;
		this.price = price;
		this.quantity = quantity;
	}

	public void getProductDetails() {
		System.out.println("Product Details:\n" + "----------------\n" + "\n" + "Product ID         : " + this.productId
				+ "\n" + "Product Name       : " + this.productName + "\n" + "Price              : " + this.price + "\n"
				+ "Available quantity : " + this.quantity);
	}

	public int getProductId() {
		return productId;
	}

	

	public String getProductName() {
		return productName;
	}


	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
