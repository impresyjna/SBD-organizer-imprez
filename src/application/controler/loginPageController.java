package application.controler;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class loginPageController {
	
	 // Reference to the main application.
    private Main main;
    
    @FXML
    private TextField Login; 
    @FXML
    private PasswordField Password;
    
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
	private void handleLogin() throws IOException
	{
		try {
			main.getDbmenager().selectQuery("select * from uzytkownicy where login='" + Login.getText() + "' and haslo='" + Password.getText() + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(!main.getDbmenager().getRs().next())
			{
				System.out.println("B³êdny login lub has³o");
			}
			else
			{
				
				main.getUser().setUserId(main.getDbmenager().getRs().getInt(1));
				main.getUser().setLogin(main.getDbmenager().getRs().getString(2));
				main.getUser().setPassword(main.getDbmenager().getRs().getString(3));
				main.getUser().setMail(main.getDbmenager().getRs().getString(4));
				main.getUser().setTelephone(main.getDbmenager().getRs().getString(5));
				main.getUser().setProfession(main.getDbmenager().getRs().getString(6));
				
				if(main.getDbmenager().getRs().getString(6).equals("Organizator"))
				{
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(Main.class.getResource("view/organiserFirstPage.fxml"));
					AnchorPane organiserPage = (AnchorPane) loader.load();
					main.getRootLayout().setCenter(organiserPage);
					organiserFirstPageController controller = loader.getController(); 
			    	controller.setMainApp(main);
			    	main=null ;
				}
				else
				{
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(Main.class.getResource("view/companyFirstPage.fxml"));
					AnchorPane companyPage = (AnchorPane) loader.load();
					main.getRootLayout().setCenter(companyPage);
					companyFirstPageController controller = loader.getController(); 
			    	controller.setMainApp(main);
			    	main=null ;
				}
					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
