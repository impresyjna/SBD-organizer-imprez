package entities;

import java.util.ArrayList;
import java.util.List;

public class Party {
	private Room where; 
	private Date when; 
	private List<Company> working=new ArrayList<Company>();
	
	public Room getWhere() {
		return where;
	}
	public void setWhere(Room where) {
		this.where = where;
	}
	public Date getWhen() {
		return when;
	}
	public void setWhen(Date when) {
		this.when = when;
	}
	public List<Company> getWorking() {
		return working;
	}
	public void setWorking(List<Company> working) {
		this.working = working;
	} 
}
