package entities;

public class Party {
	private int partyId; 
	private String name; 
	private int day; 
	private int month; 
	private int year; 
	private String place;
	
	public Party(int partyId, String name, int day, int month, int year,
			String place) {
		this.partyId = partyId;
		this.name = name;
		this.day = day;
		this.month = month;
		this.year = year;
		this.place = place;
	}
	
	public int getPartyId() {
		return partyId;
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
	public String getPlace() {
		return place;
	}
	public void setPartyId(int partyId) {
		this.partyId = partyId;
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
	public void setPlace(String place) {
		this.place = place;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
	
	
}
