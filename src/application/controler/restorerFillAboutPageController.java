package application.controler;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class restorerFillAboutPageController {
	
	// Reference to the main application.
	private Main main;
	
	@FXML
	private TextField Name; 
	@FXML
	private TextField Website; 

	public void setMainApp(Main mainApp) {
		this.main = mainApp;
	}
	
	@FXML
	private void handleBack() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class
				.getResource("view/companyFirstPage.fxml"));
		AnchorPane fillPage = (AnchorPane) loader.load();
		main.getRootLayout().setCenter(fillPage);
		companyFirstPageController controller1 = loader.getController();
		controller1.setMainApp(main);
		main = null;
	}
	
	@FXML
	private void handleAdd() throws SQLException {
		String name,website;
		name = Name.getText();
		website = Website.getText();
		String query1 = "Insert into przedsiebiorcy values("; 
		query1 += main.getUser().getUserId() + ",'" + main.getUser().getLogin()
				+ "','" + name + "','" + website + "')";
		System.out.println(query1);
		main.getDbmenager().updateQuery(query1);
		System.out.println("Dodano dodatkowe informacje");
	}
}
