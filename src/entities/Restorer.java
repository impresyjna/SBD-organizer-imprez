package entities;

import java.util.ArrayList;
import java.util.List;

public class Restorer extends User{
	private int CountOfRooms; 
	private List<Room> rooms=new ArrayList<Room>(); 
	private List<Date> dates=new ArrayList<Date>(); 
	private String moreInfo;
	
	public int getCountOfRooms() {
		return CountOfRooms;
	}
	public void setCountOfRooms(int countOfRooms) {
		CountOfRooms = countOfRooms;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	public List<Date> getDates() {
		return dates;
	}
	public void setDates(List<Date> dates) {
		this.dates = dates;
	}
	public String getMoreInfo() {
		return moreInfo;
	}
	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	} 
}
