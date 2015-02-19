package application.controler;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class registerPageController {

	 // Reference to the main application.
    private Main main;
    
	public void setMainApp(Main mainApp) {
        this.main = mainApp;
    }
	
	@FXML
	private void handleBack() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/welcomePage.fxml"));
		AnchorPane welcomePage = (AnchorPane) loader.load();
		main.getRootLayout().setCenter(welcomePage);
		welcomePageController controller = loader.getController(); 
    	controller.setMainApp(main);
    	main=null ;
	} 
	
	@FXML
	private void handleRegister()
	{
		//TODO: Write this handler
	}
	

}
