package application.controler;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class organiserFirstPageController {

	// Reference to the main application.
	private Main main;

	public void setMainApp(Main mainApp) {
		this.main = mainApp;
	}

	@FXML
	private void handleSearch() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/searchPage.fxml"));
		AnchorPane searchPage = (AnchorPane) loader.load();
		main.getRootLayout().setCenter(searchPage);
		searchPageController controller1 = loader.getController();
		controller1.setMainApp(main);
		main = null;

	}

	@FXML
	private void handleMyParties() throws IOException, SQLException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/myPartiesPage.fxml"));
		AnchorPane partiesPage = (AnchorPane) loader.load();
		main.getRootLayout().setCenter(partiesPage);
		myPartiesPageController controller1 = loader.getController();
		controller1.setMainApp(main);
		main = null;
	}

	@FXML
	private void handleOrganise() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/organisePage.fxml"));
		AnchorPane partiesPage = (AnchorPane) loader.load();
		main.getRootLayout().setCenter(partiesPage);
		organisePageController controller1 = loader.getController();
		controller1.setMainApp(main);
		main = null;
	}

	@FXML
	private void handleFillAboutMe() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/organiserFillAboutPage.fxml"));
		AnchorPane partiesPage = (AnchorPane) loader.load();
		main.getRootLayout().setCenter(partiesPage);
		organiserFillAboutPageController controller1 = loader.getController();
		controller1.setMainApp(main);
		main = null;
	}

	@FXML
	private void handleLogOut() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/welcomePage.fxml"));
		AnchorPane partiesPage = (AnchorPane) loader.load();
		main.getRootLayout().setCenter(partiesPage);
		welcomePageController controller1 = loader.getController();
		controller1.setMainApp(main);
		main = null;
	}
}
