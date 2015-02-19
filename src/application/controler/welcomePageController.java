package application.controler;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class welcomePageController {
	
    // Reference to the main application.
    private Main main;
    
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
    private void handleUnregister() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(Main.class.getResource("view/unregisterFirstPage.fxml"));
    	AnchorPane unregisterPage = (AnchorPane) loader.load();
    	main.getRootLayout().setCenter(unregisterPage);
    	unregisterFirstPageController controller1 = loader.getController(); 
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
    	main=null; 
    }
	    
	public void setMainApp(Main mainApp) {
        this.main = mainApp;
    }

}
