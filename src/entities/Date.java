package entities;

public class Date {
	private int productId; 
	private String name; 
	private int day; 
	private int month; 
	private int year; 
	
	public Date(int productId, String name, int day, int month, int year) {
		this.productId = productId;
		this.name = name;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public int getProductId() {
		return productId;
	}
	public String getName() {
		return name;
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
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setName(String name) {
		this.name = name;
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

}
