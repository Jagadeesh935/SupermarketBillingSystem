package com.jk;

public class Customer {
	private static int idTracker = 1;
	private int customerId;
	private String customerName;
	private String phone;

	public Customer(String name, String phone) {
		this.customerId = idTracker++;
		this.customerName = name;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + "]";
	}

	public int getCustomerId() {
		return customerId;
	}


	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhone() {
		return phone;
	}



	public void displayCustomerDetails() {
		System.out.println("Customer Details:\n" + "-----------------\n" + "Customer ID   : " + this.customerId + "\n"
				+ "Customer Name : " + this.customerName + "\n" + "Phone         : " + this.phone);
	}

}
