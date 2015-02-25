package application.controler;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class unregisterFirstPageController {

	 // Reference to the main application.
    private Main main;
    
	public void setMainApp(Main mainApp) {
        this.main = mainApp;
    }
	
	@FXML
    private void handleLogin() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(Main.class.getResource("view/loginPage.fxml"));
    	AnchorPane loginPage = (AnchorPane) loader.load();
    	main.getRootLayout().setCenter(loginPage);
    	loginPageController controller1 = loader.getController(); 
    	controller1.setMainApp(main);
    	main=null; 
    }
    
    @FXML
    private void handleSearch() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(Main.class.getResource("view/searchPage.fxml"));
    	AnchorPane searchPage = (AnchorPane) loader.load();
    	main.getRootLayout().setCenter(searchPage);
    	searchPageController controller1 = loader.getController(); 
    	controller1.setMainApp(main);
    	main=null; 
    }
    
    @FXML
    private void handleAbout() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(Main.class.getResource("view/aboutProjectPage.fxml"));
    	AnchorPane aboutPage = (AnchorPane) loader.load();
    	main.getRootLayout().setCenter(aboutPage);
    	aboutProjectPageController controller1 = loader.getController(); 
    	controller1.setMainApp(main);
    	main=null; 
    }
    
    @FXML
    private void handleRegister() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(Main.class.getResource("view/registerPage.fxml"));
    	AnchorPane registerPage = (AnchorPane) loader.load();
    	main.getRootLayout().setCenter(registerPage);
    	registerPageController controller1 = loader.getController(); 
    	controller1.setMainApp(main);
    	controller1.fillCombo();
    	main=null; 
    }

}
