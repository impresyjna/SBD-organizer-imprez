package entities;

public class OneParty {
	private int productId; 
	private String productName; 
	private String companyName; 
	private float price; 
	private int day; 
	private int month; 
	private int year; 
	private String website; 
	private String number; 
	private String state; 
	
	public OneParty(int productId, String productName, String companyName,
			float price, int day, int month, int year, String website,
			String number, String state) {
		this.productId = productId;
		this.productName = productName;
		this.companyName = companyName;
		this.price = price;
		this.day = day;
		this.month = month;
		this.year = year;
		this.website = website;
		this.number = number;
		this.state = state;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public float getPrice() {
		return price;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public String getWebsite() {
		return website;
	}

	public String getNumber() {
		return number;
	}

	public String getState() {
		return state;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setState(String state) {
		this.state = state;
	}
}
