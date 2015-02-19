package application.controler;

import java.io.IOException;

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
	private void handleMyParties() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/myPartiesPage.fxml"));
		AnchorPane partiesPage = (AnchorPane) loader.load();
		main.getRootLayout().setCenter(partiesPage);
		//TODO: Remember about this controller
		//searchPageController controller1 = loader.getController();
		//controller1.setMainApp(main);
		main = null;
	}

	@FXML
	private void handleOrganise() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/organisePage.fxml"));
		AnchorPane partiesPage = (AnchorPane) loader.load();
		main.getRootLayout().setCenter(partiesPage);
		//TODO: Remember about this controller
		//searchPageController controller1 = loader.getController();
		//controller1.setMainApp(main);
		main = null;
	}

	@FXML
	private void handleFillAboutMe() {
		//TODO: Write this shit and do it in Scene Builder
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
