package Progress_5_Java_Part_2;

public class ElectronicsProduct implements Product {
	private String productID;
	private String name;
	private double price;
	private String description;

	public ElectronicsProduct(String productID, String name, double price, String description) {
		this.productID = productID;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	// Implement Product interface methods
	@Override
	public String getProductID() {
		return productID;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String getDescription() {
		return description;
	}
}
