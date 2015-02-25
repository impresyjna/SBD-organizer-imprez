package application.controler;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class companyFirstPageController {
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
	private void handleFillOffer() throws IOException {
		if (main.getUser().getProfession().equals("Restaurator")) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("view/restorerFillOfferPage.fxml"));
			AnchorPane fillPage = (AnchorPane) loader.load();
			main.getRootLayout().setCenter(fillPage);
			restorerFillOfferPageController controller1 = loader
					.getController();
			controller1.setMainApp(main);
			main = null;
		} else {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("view/fillOfferPage.fxml"));
			AnchorPane fillPage = (AnchorPane) loader.load();
			main.getRootLayout().setCenter(fillPage);
			fillOfferPageController controller1 = loader.getController();
			controller1.setMainApp(main);
			main = null;
		}
	}

	@FXML
	private void handleMyOffer() throws IOException, SQLException {
		if (main.getUser().getProfession().equals("Restaurator")) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/restorerMyOfferPage.fxml"));
			AnchorPane fillPage = (AnchorPane) loader.load();
			main.getRootLayout().setCenter(fillPage);
			restorerMyOfferPageController controller1 = loader.getController();
			controller1.setMainApp(main);
			main = null;
		}
		else
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/myOfferPage.fxml"));
			AnchorPane fillPage = (AnchorPane) loader.load();
			main.getRootLayout().setCenter(fillPage);
			myOfferPageController controller1 = loader.getController();
			controller1.setMainApp(main);
			main = null;
		}
	}

	@FXML
	private void handleFillDates() throws IOException, SQLException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/fillDatesPage.fxml"));
		AnchorPane fillPage = (AnchorPane) loader.load();
		main.getRootLayout().setCenter(fillPage);
		fillDatesPageController controller1 = loader.getController();
		controller1.setMainApp(main);
		controller1.fillCombo();
		main = null;
	}

	@FXML
	private void handleMyDates() throws IOException, SQLException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/myDatesPage.fxml"));
		AnchorPane fillPage = (AnchorPane) loader.load();
		main.getRootLayout().setCenter(fillPage);
		myDatesPageController controller1 = loader.getController();
		controller1.setMainApp(main);
		main = null;
	}

	@FXML
	private void handleContacts() throws IOException, SQLException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class
				.getResource("view/contactWithClientPage.fxml"));
		AnchorPane fillPage = (AnchorPane) loader.load();
		main.getRootLayout().setCenter(fillPage);
		contactWithClientPageController controller1 = loader.getController();
		controller1.setMainApp(main);
		main = null;
	}

	@FXML
	private void handleFillAboutMe() throws IOException {
		if (main.getUser().getProfession().equals("Fotograf")) {
			FXMLLoader loader1 = new FXMLLoader();
			loader1.setLocation(Main.class
					.getResource("view/photographFillAboutPage.fxml"));
			AnchorPane fillPage1 = (AnchorPane) loader1.load();
			main.getRootLayout().setCenter(fillPage1);
			photographFillAboutPageController controller = loader1
					.getController();
			controller.setMainApp(main);
			main = null;
		} else if (main.getUser().getProfession().equals("Restaurator")) {
			FXMLLoader loader1 = new FXMLLoader();
			loader1.setLocation(Main.class
					.getResource("view/restorerFillAboutPage.fxml"));
			AnchorPane fillPage1 = (AnchorPane) loader1.load();
			main.getRootLayout().setCenter(fillPage1);
			restorerFillAboutPageController controller = loader1
					.getController();
			controller.setMainApp(main);
			main = null;
		} else if (main.getUser().getProfession().equals("Catering")) {
			FXMLLoader loader1 = new FXMLLoader();
			loader1.setLocation(Main.class
					.getResource("view/cateringFillAboutPage.fxml"));
			AnchorPane fillPage1 = (AnchorPane) loader1.load();
			main.getRootLayout().setCenter(fillPage1);
			cateringFillAboutPageController controller = loader1
					.getController();
			controller.setMainApp(main);
			main = null;
		} else if (main.getUser().getProfession().equals("Zespol")) {
			FXMLLoader loader1 = new FXMLLoader();
			loader1.setLocation(Main.class
					.getResource("view/bandFillAboutPage.fxml"));
			AnchorPane fillPage1 = (AnchorPane) loader1.load();
			main.getRootLayout().setCenter(fillPage1);
			bandFillAboutPageController controller = loader1.getController();
			controller.setMainApp(main);
			main = null;
		} else {
			FXMLLoader loader1 = new FXMLLoader();
			loader1.setLocation(Main.class
					.getResource("view/otherFillAboutPage.fxml"));
			AnchorPane fillPage1 = (AnchorPane) loader1.load();
			main.getRootLayout().setCenter(fillPage1);
			otherFillAboutPageController controller = loader1.getController();
			controller.setMainApp(main);
			main = null;
		}
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
