package application.controler;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class searchPageController {

	// Reference to the main application.
	private Main main;

	public void setMainApp(Main mainApp) {
		this.main = mainApp;
	}

	@FXML
	private void handleBack() throws IOException {
		System.out.println(main.getUser().getProfession());
		if(main.getUser().getProfession().equals("Organizator"))
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/organiserFirstPage.fxml"));
			AnchorPane welcomePage = (AnchorPane) loader.load();
			main.getRootLayout().setCenter(welcomePage);
			organiserFirstPageController controller = loader.getController(); 
	    	controller.setMainApp(main);
	    	main=null ;
		}
		else
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/companyFirstPage.fxml"));
			AnchorPane welcomePage = (AnchorPane) loader.load();
			main.getRootLayout().setCenter(welcomePage);
			companyFirstPageController controller = loader.getController(); 
	    	controller.setMainApp(main);
	    	main=null ;
		}
	}
	
	@FXML
	private void handleNext()
	{
		//TODO: Write this handle
	}
}
