package application.controler;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class photographFillAboutPageController {

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
	private void handleBack() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class
				.getResource("view/companyFirstPage.fxml"));
		AnchorPane fillPage = (AnchorPane) loader.load();
		main.getRootLayout().setCenter(fillPage);
		companyFirstPageController controller1 = loader.getController();
		controller1.setMainApp(main);
		main = null;
	}
	
	@FXML
	private void handleAdd() throws SQLException {
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
		String name;
		String website;
		name = Name.getText();
		website = Website.getText();
		
		//Dodaj do przedsiebiorcy
		String query1 = "Insert into przedsiebiorcy values("; 
		query1+=main.getUser().getUserId()+",'"+main.getUser().getLogin()+"','"+name+"','"+website+"')"; 
		//Dodaj do odpowiedniej relacji 
		String query = "Insert Into fotografowie values(";
		query += main.getUser().getUserId() + "," + weddingInt + "," + documentInt + "," + sportInt + "," + fashionInt + "," + baptismInt + "," + communionInt + "," +  birthdayInt + "," +  promInt + ")";
		System.out.println(query1); 
		System.out.println(query);
		main.getDbmenager().updateQuery(query);
		main.getDbmenager().updateQuery(query1);
		System.out.println("Dodano dodatkowe informacje");
	}
}
