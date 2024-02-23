package Progress_5_Java_Part_2;

public class Order {
	private String orderID;
	@SuppressWarnings("unused")
	private Customer customer;
	private Product product;
	private int quantity;

	public Order(String orderID, Customer customer, Product product, int quantity) {
		this.orderID = orderID;
		this.customer = customer;
		this.product = product;
		this.quantity = quantity;
	}

	public double calculateTotalCost() {
		return product.getPrice() * quantity;
	}

	// Getters
	public String getOrderID() {
		return orderID;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}
}
