package Progress_5_Java_Part_2;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String customerID;
	private String name;
	private String email;
	private List<Order> orders;

	public Customer(String customerID, String name, String email) {
		this.customerID = customerID;
		this.name = name;
		this.email = email;
		this.orders = new ArrayList<>();
	}

	public void purchaseProduct(Product product, int quantity) {
		Order order = new Order(java.util.UUID.randomUUID().toString(), this, product, quantity);
		orders.add(order);
	}

	public void viewOrders() {
		for (Order order : orders) {
			System.out.println("Order ID: " + order.getOrderID() + ", Product: " + order.getProduct().getName()
					+ ", Quantity: " + order.getQuantity() + ", Total Cost: $" + order.calculateTotalCost());
		}
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
