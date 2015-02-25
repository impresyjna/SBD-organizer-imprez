package application.controler;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class organiserFillAboutPageController {
	// Reference to the main application.
	private Main main;

	@FXML
	private TextField Name;
	@FXML
	private TextField Surname;

	public void setMainApp(Main mainApp) {
		this.main = mainApp;
	}

	@FXML
	private void handleBack() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class
				.getResource("view/organiserFirstPage.fxml"));
		AnchorPane fillPage = (AnchorPane) loader.load();
		main.getRootLayout().setCenter(fillPage);
		organiserFirstPageController controller1 = loader.getController();
		controller1.setMainApp(main);
		main = null;
	}

	@FXML
	private void handleAdd() throws SQLException {
		String name;
		String surname;
		name = Name.getText();
		surname = Surname.getText();
		String query = "Insert Into organizatorzy values(";
		query += main.getUser().getUserId() + ",'" + name + "','" + surname
				+ "')";
		System.out.println(query);
		main.getDbmenager().selectQuery(query);
		System.out.println("Dodano dodatkowe informacje");
	}
}
