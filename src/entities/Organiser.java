package entities;

import java.util.ArrayList;
import java.util.List;

public class Organiser extends User{
	private List<Party> parties=new ArrayList<Party>();

	public List<Party> getParties() {
		return parties;
	}

	public void setParties(List<Party> parties) {
		this.parties = parties;
	} 
}
