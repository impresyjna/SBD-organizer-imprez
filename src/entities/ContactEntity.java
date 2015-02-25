package entities;

public class ContactEntity {
	private int productId; 
	private String name; 
	private String customerName; 
	private String customerSurname; 
	private String mail; 
	private String number; 
	private int day; 
	private int month; 
	private int year; 
	private String partyName; 
	private String place; 
	private String state; 
	
	public ContactEntity(int productId, String name, String customerName,
			String customerSurname, String mail, String number, int day,
			int month, int year, String partyName, String place, String state) {
		this.productId = productId;
		this.name = name;
		this.customerName = customerName;
		this.customerSurname = customerSurname;
		this.mail = mail;
		this.number = number;
		this.day = day;
		this.month = month;
		this.year = year;
		this.partyName = partyName;
		this.place = place;
		this.state = state;
	}

	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerSurname() {
		return customerSurname;
	}

	public String getMail() {
		return mail;
	}

	public String getNumber() {
		return number;
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

	public String getPartyName() {
		return partyName;
	}

	public String getPlace() {
		return place;
	}

	public String getState() {
		return state;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setNumber(String number) {
		this.number = number;
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

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
