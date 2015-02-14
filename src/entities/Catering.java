package entities;

import java.util.ArrayList;
import java.util.List;

public class Catering extends User{
	private boolean delivery=false; 
	private List<String> menu=new ArrayList<String>();
	
	public boolean isDelivery() {
		return delivery;
	}
	public void setDelivery(boolean delivery) {
		this.delivery = delivery;
	}
	public List<String> getMenu() {
		return menu;
	}
	public void setMenu(List<String> menu) {
		this.menu = menu;
	} 
}
