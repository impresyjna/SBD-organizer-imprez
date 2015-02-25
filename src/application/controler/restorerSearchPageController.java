package application.controler;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class restorerSearchPageController {
	// Reference to the main application.
	private Main main;

	@FXML
	private TextField minSize; 
	@FXML
	private TextField maxSize; 
	
	public void setMainApp(Main mainApp) {
		this.main = mainApp;
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
	private void handleSearchInDatabase() throws IOException, SQLException {
		String minS, maxS; 
		minS=minSize.getText(); 
		maxS=maxSize.getText(); 
		String query = "select distinct p.id_prod, p.nazwa, p.cena, p.szczegoly, t.dzien, t.miesiac, t.rok, ";
		query += "c.nazwa, c.strona, u.numer, u.mail from produkty p join terminarz t on p.id_prod=t.id_produktu join przedsiebiorcy c on t.id_uzytkownika=c.id join uzytkownicy u on c.id=u.id join ";
		query+=" sale s on s.id_produktu=p.id_prod where t.rezerwacja=0  and c.nazwa is not null and ";
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
		query += "(s.pojemnosc between " + minS + " and " + maxS + ")";
		System.out.println(query);
		main.getDbmenager().selectQuery(query);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/resultPage.fxml"));
		AnchorPane searchPage = (AnchorPane) loader.load();
		main.getRootLayout().setCenter(searchPage);
		resultPageController controller = loader.getController();
		controller.setMainApp(main);
		main = null;
	}
}
