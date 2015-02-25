package entities;

public class Product {
	private int productId;
	private String name;
	private float price;
	private String details;

	public Product(int productId, String name, float price, String details) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.details = details;
	}

	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public String getDetails() {
		return details;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
