package application.controler;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class cateringSearchPageController {
	// Reference to the main application.
	private Main main;

	@FXML
	private CheckBox Dinner; 
	@FXML
	private CheckBox Cold; 
	@FXML
	private CheckBox Desser; 
	@FXML
	private CheckBox Breakfast; 
	@FXML
	private CheckBox Supper; 
	@FXML
	private CheckBox Seafood; 
	
	public void setMainApp(Main mainApp) {
		this.main = mainApp;
	}
	
	@FXML
	private void handleBack() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/searchPage.fxml"));
		AnchorPane searchPage = (AnchorPane) loader.load();
		main.getRootLayout().setCenter(searchPage);
		searchPageController controller = loader.getController(); 
    	controller.setMainApp(main);
    	main=null ;
	}
	
	@FXML
	private void handleSearchInDatabase() throws IOException, SQLException
	{
		boolean dinner, cold, desser, breakfast, supper, seafood;
		dinner = Dinner.isSelected();
		cold = Cold.isSelected();
		desser = Desser.isSelected();
		breakfast = Breakfast.isSelected();
		supper = Supper.isSelected();
		seafood = Seafood.isSelected(); 
		int dinnerInt = (dinner) ? 1 : 0;
		int coldInt = (cold) ? 1 : 0;
		int desserInt = (desser) ? 1 : 0;
		int breakfastInt = (breakfast) ? 1 : 0;
		int supperInt = (supper) ? 1 : 0;
		int seafoodInt = (seafood) ? 1 : 0;
		String query = "select distinct p.id_prod, p.nazwa, p.cena, p.szczegoly, t.dzien, t.miesiac, t.rok, ";
		query += "c.nazwa, c.strona, u.numer, u.mail from produkty p join terminarz t on p.id_prod=t.id_produktu join przedsiebiorcy c on t.id_uzytkownika=c.id join uzytkownicy u on c.id=u.id join ";
		query+=" catering k on k.id_uzytkownika=c.id where t.rezerwacja=0  and c.nazwa is not null and ";
		query += "(p.cena between "
				+ main.getDbmenager().getSimpleQuery().getMinCost() + " and "
				+ main.getDbmenager().getSimpleQuery().getMaxCost() + ") and ";
		query += "(t.dzien>="
				+ main.getDbmenager().getSimpleQuery().getMinDay()
				+ " and t.dzien<= "
				+ main.getDbmenager().getSimpleQuery().getMaxDay() + ") and ";
		query += "(t.miesiac>="
				+ main.getDbmenager().getSimpleQuery().getMinMonth()
				+ " and t.miesiac<="
				+ main.getDbmenager().getSimpleQuery().getMaxMonth() + ") and ";
		query += "(t.rok>=" + main.getDbmenager().getSimpleQuery().getMinYear()
				+ " and t.rok<="
				+ main.getDbmenager().getSimpleQuery().getMaxYear() + ") and ";
		query += "(k.obiad= " + dinnerInt + "or k.zimno= " + coldInt + " or k.deser= " + desserInt + " or k.sniadanie= " + breakfastInt + " or k.kolacja= "  + supperInt + " or k.morze= " + seafoodInt + ")";
		System.out.println(query);
		main.getDbmenager().selectQuery(query);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/resultPage.fxml"));
		AnchorPane searchPage = (AnchorPane) loader.load();
		main.getRootLayout().setCenter(searchPage);
		resultPageController controller = loader.getController(); 
    	controller.setMainApp(main);
    	main=null ;
	}
}
