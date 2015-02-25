package application.controler;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class searchPageController {

	// Reference to the main application.
	private Main main;
	
	@FXML
	private ToggleGroup RadioButtons; 
	@FXML
	private TextField minCost; 
	@FXML
	private TextField maxCost; 
	@FXML
	private DatePicker minDate; 
	@FXML
	private DatePicker maxDate; 

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
		else if(main.getUser().getProfession().equals("Niezalogowany"))
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/unregisterFirstPage.fxml"));
			AnchorPane welcomePage = (AnchorPane) loader.load();
			main.getRootLayout().setCenter(welcomePage);
			unregisterFirstPageController controller = loader.getController(); 
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
	private void handleNext() throws IOException, SQLException
	{
		Toggle selectedToggle = RadioButtons.getSelectedToggle();
		int selectedToggleIndex = RadioButtons.getToggles().indexOf(selectedToggle);
		main.getDbmenager().getSimpleQuery().setMinCost(Integer.parseInt(minCost.getText()));
		main.getDbmenager().getSimpleQuery().setMaxCost(Integer.parseInt(maxCost.getText()));		
		String maxD, minD; 
		maxD=maxDate.getEditor().getText(); 
		minD=minDate.getEditor().getText(); 
		String[] partsMin = minD.split("\\.");
		String[] partsMax = maxD.split("\\.");
		main.getDbmenager().getSimpleQuery().setMinDay(Integer.parseInt(partsMin[0]));
		main.getDbmenager().getSimpleQuery().setMinMonth(Integer.parseInt(partsMin[1]));
		main.getDbmenager().getSimpleQuery().setMinYear(Integer.parseInt(partsMin[2]));
		main.getDbmenager().getSimpleQuery().setMaxDay(Integer.parseInt(partsMax[0]));
		main.getDbmenager().getSimpleQuery().setMaxMonth(Integer.parseInt(partsMax[1]));
		main.getDbmenager().getSimpleQuery().setMaxYear(Integer.parseInt(partsMax[2]));
		switch (selectedToggleIndex) {
		case 0:
			main.getDbmenager().getSimpleQuery().setProfession("Fotograf");
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/photographSearchPage.fxml"));
			AnchorPane searchPage = (AnchorPane) loader.load();
			main.getRootLayout().setCenter(searchPage);
			photographSearchPageController controller = loader.getController(); 
	    	controller.setMainApp(main);
	    	main=null ;
			break;
		case 1:
			main.getDbmenager().getSimpleQuery().setProfession("Restaurator");
			FXMLLoader loader1 = new FXMLLoader();
			loader1.setLocation(Main.class.getResource("view/restorerSearchPage.fxml"));
			AnchorPane searchPage1 = (AnchorPane) loader1.load();
			main.getRootLayout().setCenter(searchPage1);
			restorerSearchPageController controller1 = loader1.getController(); 
	    	controller1.setMainApp(main);
	    	main=null ;
			break; 
		case 2:
			main.getDbmenager().getSimpleQuery().setProfession("Catering");
			FXMLLoader loader11 = new FXMLLoader();
			loader11.setLocation(Main.class.getResource("view/cateringSearchPage.fxml"));
			AnchorPane searchPage11 = (AnchorPane) loader11.load();
			main.getRootLayout().setCenter(searchPage11);
			cateringSearchPageController controller11 = loader11.getController(); 
	    	controller11.setMainApp(main);
	    	main=null ;
			break; 
		case 3:
			main.getDbmenager().getSimpleQuery().setProfession("Zespol");
			FXMLLoader loader111 = new FXMLLoader();
			loader111.setLocation(Main.class.getResource("view/bandSearchPage.fxml"));
			AnchorPane searchPage111 = (AnchorPane) loader111.load();
			main.getRootLayout().setCenter(searchPage111);
			bandSearchPageController controller111 = loader111.getController(); 
	    	controller111.setMainApp(main);
	    	main=null ;
			break; 
		default:
			main.getDbmenager().getSimpleQuery().setProfession("Inne");
			FXMLLoader loader1111 = new FXMLLoader();
			loader1111.setLocation(Main.class.getResource("view/otherSearchPage.fxml"));
			AnchorPane searchPage1111 = (AnchorPane) loader1111.load();
			main.getRootLayout().setCenter(searchPage1111);
			otherSearchPageController controller1111 = loader1111.getController(); 
	    	controller1111.setMainApp(main);
	    	main=null ;
			break;
		}
	}
}
