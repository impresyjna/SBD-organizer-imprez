package application.controler;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class cateringFillAboutPageController {
	
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
	@FXML
	private TextField Name; 
	@FXML
	private TextField Website; 
	
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
		boolean dinner, cold, desser, breakfast, supper, seafood;
		String name, website;
		dinner = Dinner.isSelected();
		cold = Cold.isSelected();
		desser = Desser.isSelected();
		breakfast = Breakfast.isSelected();
		supper = Supper.isSelected();
		seafood = Seafood.isSelected(); 
		name = Name.getText();
		website = Website.getText();
		int dinnerInt = (dinner) ? 1 : 0;
		int coldInt = (cold) ? 1 : 0;
		int desserInt = (desser) ? 1 : 0;
		int breakfastInt = (breakfast) ? 1 : 0;
		int supperInt = (supper) ? 1 : 0;
		int seafoodInt = (seafood) ? 1 : 0;

		// Dodaj do przedsiebiorcy
		String query1 = "Insert into przedsiebiorcy values(";
		query1 += main.getUser().getUserId() + ",'" + main.getUser().getLogin()
				+ "','" + name + "','" + website + "')";
		// Dodaj do odpowiedniej relacji
		String query = "Insert Into catering values(";
		query += main.getUser().getUserId() + "," + dinnerInt + ","
				+ coldInt + "," + desserInt + "," + breakfastInt + ","
				+ supperInt + "," + seafoodInt +")";
		System.out.println(query1);
		System.out.println(query);
		main.getDbmenager().updateQuery(query);
		main.getDbmenager().updateQuery(query1);
		System.out.println("Dodano dodatkowe informacje");
	}
}
