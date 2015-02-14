package entities;

public class Room {
	private int size; 
	private Company owner;
	private String description; 
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Company getOwner() {
		return owner;
	}
	public void setOwner(Company owner) {
		this.owner = owner;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	} 
}
