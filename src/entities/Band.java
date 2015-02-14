package entities;

import java.util.ArrayList;
import java.util.List;

public class Band extends User{
	private List<String> playlist=new ArrayList<String>(); 
	private String genre;
	
	public List<String> getPlaylist() {
		return playlist;
	}
	public void setPlaylist(List<String> playlist) {
		this.playlist = playlist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	} 
}
