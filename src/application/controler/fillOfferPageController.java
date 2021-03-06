package application.controler;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class fillOfferPageController {

	// Reference to the main application.
	private Main main;
	private String name; 
	private String price; 
	private String details; 

	@FXML
	private TextField Name; 
	@FXML
	private TextField Price; 
	@FXML
	private TextField Details; 
	
	public void setMainApp(Main mainApp) {
		this.main = mainApp;
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
	private void handleAdd() throws SQLException {
		name=Name.getText(); 
		price=Price.getText(); 
		details=Details.getText(); 
		String query="INSERT INTO Produkty VALUES(PRODUKTY_SEQ.NEXTVAL,"; 
		query+=main.getUser().getUserId()+",'"+name+"',"+price+",'"+details+"')"; 
		System.out.println(query);
		main.getDbmenager().updateQuery(query);
		System.out.println("Dodano nowy produkt");
		Name.clear();
		Price.clear();
		Details.clear();
	}

}
