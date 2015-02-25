package application.controler;

import java.io.IOException;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class fillDatesPageController {
	// Reference to the main application.
	private Main main;

	@FXML
	private ComboBox<String> Product; 
	@FXML
	private DatePicker Date; 
	
	public void setMainApp(Main mainApp) {
		this.main = mainApp;
	}

	public void fillCombo() throws SQLException
	{
		ObservableList<String> Products = FXCollections.observableArrayList(); 
		String query="select * from produkty where uzytkownicy="+main.getUser().getUserId();
		main.getDbmenager().selectQuery(query);
		while (main.getDbmenager().getRs().next())
		{
			Products.add(main.getDbmenager().getRs().getInt(1)+"."+main.getDbmenager().getRs().getString(3)); 
		}
		Product.setItems(Products); 
		System.out.println(query);
	}
	
	@FXML
	private void handleBack() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/companyFirstPage.fxml"));
		AnchorPane fillPage = (AnchorPane) loader.load();
		main.getRootLayout().setCenter(fillPage);
		companyFirstPageController controller1 = loader.getController();
		controller1.setMainApp(main);
		main = null;
	}
	
	@FXML
	private void handleAdd() throws SQLException
	{
		String date; 
		String name; 
		date=Date.getEditor().getText(); 
		name=Product.getValue(); 
		String[] parts = date.split("\\.");
		String[] parts2 = name.split("\\."); 
		String query="Insert into Terminarz values("; 
		query+=parts2[0]+","+main.getUser().getUserId()+","+parts[0]+","+parts[1]+","+parts[2]+",0)"; 
		System.out.println(query);
		main.getDbmenager().updateQuery(query);
		System.out.println("Dodano nowy termin");
		Date.getEditor().clear();
	}

}
