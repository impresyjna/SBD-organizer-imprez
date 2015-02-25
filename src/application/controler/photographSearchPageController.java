package application.controler;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class photographSearchPageController {
	// Reference to the main application.
	private Main main;

	@FXML
	private TextField Name; 
	@FXML
	private TextField Website; 
	@FXML
	private CheckBox Communion; 
	@FXML
	private CheckBox Baptism; 
	@FXML
	private CheckBox Birthday; 
	@FXML
	private CheckBox Sport; 
	@FXML
	private CheckBox Fashion; 
	@FXML
	private CheckBox Document; 
	@FXML
	private CheckBox Prom; 
	@FXML
	private CheckBox Wedding;
	
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
		boolean communion,baptism,birthday,sport,fashion,document,prom,wedding; 
		communion=Communion.isSelected(); 
		baptism=Baptism.isSelected(); 
		birthday=Birthday.isSelected(); 
		sport=Sport.isSelected(); 
		fashion=Fashion.isSelected(); 
		document=Document.isSelected(); 
		prom=Prom.isSelected(); 
		wedding=Wedding.isSelected(); 
		int communionInt = (communion) ? 1 : 0;
		int baptismInt = (baptism) ? 1 : 0;
		int birthdayInt = (birthday) ? 1 : 0;
		int sportInt = (sport) ? 1 : 0;
		int fashionInt = (fashion) ? 1 : 0;
		int documentInt = (document) ? 1 : 0;
		int promInt = (prom) ? 1 : 0;
		int weddingInt = (wedding) ? 1 : 0;
		String query = "select distinct p.id_prod, p.nazwa, p.cena, p.szczegoly, t.dzien, t.miesiac, t.rok, ";
		query += "c.nazwa, c.strona, u.numer, u.mail from produkty p join terminarz t on p.id_prod=t.id_produktu join przedsiebiorcy c on t.id_uzytkownika=c.id join uzytkownicy u on c.id=u.id join ";
		query+=" fotografowie f on f.id_uzytkownika=c.id where t.rezerwacja=0  and c.nazwa is not null and ";
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
		query += "(f.slubna= " + weddingInt + "or f.dokumentalna= " + documentInt + " or f.sportowa= " + sportInt; 
		query+= " or f.fashion= " + fashionInt + " or f.chrzciny= "  + baptismInt + " or f.komunie= "  + communionInt + " or f.osiemnastki= "  +  birthdayInt + " or f.studniowki= " + promInt + ")";
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
