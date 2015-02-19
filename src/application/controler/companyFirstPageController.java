package application.controler;

import java.io.IOException;

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
	private void handleSearch() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/searchPage.fxml"));
		AnchorPane searchPage = (AnchorPane) loader.load();
		main.getRootLayout().setCenter(searchPage);
		searchPageController controller1 = loader.getController();
		controller1.setMainApp(main);
		main = null;
	}
	
	@FXML
	private void handleFillOffer()
	{
		//TODO: Write this handler
	}
	
	@FXML
	private void handleMyOffer()
	{
		//TODO: Write this handler
	}
	
	@FXML
	private void handleFillDates()
	{
		//TODO: Write this handler
	}
	
	@FXML
	private void handleMyDates()
	{
		//TODO: Write this handler
	}
	
	@FXML
	private void handleContacts()
	{
		//TODO: Write this handler
	}
	
	@FXML
	private void handleFillAboutMe()
	{
		//TODO: Write this handler
	}
	
	@FXML
	private void handleLogOut() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/welcomePage.fxml"));
		AnchorPane partiesPage = (AnchorPane) loader.load();
		main.getRootLayout().setCenter(partiesPage);
		welcomePageController controller1 = loader.getController();
		controller1.setMainApp(main);
		main = null;
	}
}
