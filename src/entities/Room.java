package entities;

public class Room {
	private int productId;
	private String name;
	private float price;
	private String details; 
	private int size;
	
	public Room(int productId, String name, float price, String details,
			int size) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.details = details;
		this.size = size;
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

	public int getSize() {
		return size;
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

	public void setSize(int size) {
		this.size = size;
	}
}
