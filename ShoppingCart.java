package com.jk;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private List<CartItem> cartItems = new ArrayList<>();
	private int totalPrice;

	public void addItemToCart(CartItem item) {
		cartItems.add(item);
		System.out.println("Item added to cart");
	}

	public void removeItemFromCart(CartItem item) {
		cartItems.remove(item);
		System.out.println("Item removed from cart");
	}

	public void clearCart() {
		cartItems.clear();
	}

	public int calculateTotalPrice() {
		this.totalPrice = 0;
		cartItems.forEach(item -> this.totalPrice += item.getSubTotal());
		return this.totalPrice;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public CartItem getCartItemById(Product p) {
		// TODO Auto-generated method stub
		for (CartItem item : cartItems) {
			if (item.getProduct() == p)
				return item;
		}
		System.out.println("Item not found");
		return null;
	}

}
