package entities;

public class ResultEntity {
	private int productId; 
	private String name; 
	private float price; 
	private String details; 
	private int day; 
	private int month;
	private int year; 
	private String companyName; 
	private String website; 
	private String number; 
	private String mail; 
	
	public ResultEntity(int productId, String name, float price,
			String details, int day, int month, int year, String companyName,
			String website, String number, String mail) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.details = details;
		this.day = day;
		this.month = month;
		this.year = year;
		this.companyName = companyName;
		this.website = website;
		this.number = number;
		this.mail = mail;
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

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getWebsite() {
		return website;
	}

	public String getNumber() {
		return number;
	}

	public String getMail() {
		return mail;
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

	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}
