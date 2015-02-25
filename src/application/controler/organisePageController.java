package application.controler;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class organisePageController {

	// Reference to the main application.
	private Main main;
	private String name; 
	private String date; 
	private String place; 
	private String day; 
	private String month; 
	private String year; 
	
	@FXML
	private TextField Name; 
	@FXML
	private DatePicker When; 
	@FXML
	private TextField Place; 
	
	public void setMainApp(Main mainApp) {
		this.main = mainApp;
	}

	@FXML
	private void handleBack() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/organiserFirstPage.fxml"));
		AnchorPane fillPage = (AnchorPane) loader.load();
		main.getRootLayout().setCenter(fillPage);
		organiserFirstPageController controller1 = loader.getController();
		controller1.setMainApp(main);
		main = null;
	}
	
	@FXML
	private void handleOrganise() throws SQLException
	{
		name=Name.getText(); 
		date=When.getEditor().getText(); 
		place=Place.getText(); 
		String[] parts = date.split("\\.");
		day=parts[0]; 
		month=parts[1];
		year=parts[2]; 
		String query="INSERT INTO Imprezy VALUES(IMPREZY_SEQ1.NEXTVAL,"; 
		query+=main.getUser().getUserId()+","+day+","+month+","+year+",'"+place+"','"+name+ "')"; 
		System.out.println(query);
		main.getDbmenager().updateQuery(query);
		System.out.println("Dodano nowa impreze");
		Name.clear();
		When.getEditor().clear();
		Place.clear();
	}
}
