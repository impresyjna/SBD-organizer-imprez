package application.controler;

import java.io.IOException;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class otherSearchPageController {
	// Reference to the main application.
	private Main main;

	@FXML
	private ComboBox<String> Category;

	public void setMainApp(Main mainApp) throws SQLException {
		this.main = mainApp;
		ObservableList<String> categories = FXCollections.observableArrayList();
		String query = "select kategoria from inne";
		main.getDbmenager().selectQuery(query);
		while (main.getDbmenager().getRs().next()) {
			categories.add(main.getDbmenager().getRs().getString(1));
		}
		Category.setItems(categories);
	}

	@FXML
	private void handleBack() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/searchPage.fxml"));
		AnchorPane searchPage = (AnchorPane) loader.load();
		main.getRootLayout().setCenter(searchPage);
		searchPageController controller = loader.getController();
		controller.setMainApp(main);
		main = null;
	}

	@FXML
	private void handleSearchInDatabase() throws IOException, SQLException
	{
		String query = "select p.id_prod, p.nazwa, p.cena, p.szczegoly, t.dzien, t.miesiac, t.rok, ";
		query += "c.nazwa, c.strona, u.numer, u.mail from produkty p join terminarz t on p.id_prod=t.id_produktu join przedsiebiorcy c on t.id_uzytkownika=c.id join uzytkownicy u on c.id=u.id join ";
		query+=" inne i on i.id_uzytkownika=c.id where t.rezerwacja=0  and c.nazwa is not null and ";
				query+="(p.cena between "+ main.getDbmenager().getSimpleQuery().getMinCost() + " and " + main.getDbmenager().getSimpleQuery().getMaxCost() + ") and ";  
				query+="(t.dzien>=" + main.getDbmenager().getSimpleQuery().getMinDay() + " and t.dzien<= " + main.getDbmenager().getSimpleQuery().getMaxDay()+ ") and "; 
				query+="(t.miesiac>=" + main.getDbmenager().getSimpleQuery().getMinMonth() + " and t.miesiac<=" + main.getDbmenager().getSimpleQuery().getMaxMonth() + ") and ";  
				query+="(t.rok>=" + main.getDbmenager().getSimpleQuery().getMinYear() + " and t.rok<=" + main.getDbmenager().getSimpleQuery().getMaxYear() + ") and "; 
				query+="i.kategoria='" + Category.getValue() + "'";  
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
