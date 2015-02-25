package application.controler;

import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class bandFillAboutPageController {
	// Reference to the main application.
	private Main main;

	@FXML
	private CheckBox Banquet;
	@FXML
	private CheckBox Rock;
	@FXML
	private CheckBox Folk;
	@FXML
	private CheckBox Pop;
	@FXML
	private CheckBox Metal;
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
		boolean banquet, rock, folk, pop, metal;
		String name, website;
		banquet = Banquet.isSelected();
		rock = Rock.isSelected();
		folk = Folk.isSelected();
		pop = Pop.isSelected();
		metal = Metal.isSelected();
		name = Name.getText();
		website = Website.getText();
		int banquetInt = (banquet) ? 1 : 0;
		int rockInt = (rock) ? 1 : 0;
		int folkInt = (folk) ? 1 : 0;
		int popInt = (pop) ? 1 : 0;
		int metalInt = (metal) ? 1 : 0;

		// Dodaj do przedsiebiorcy
		String query1 = "Insert into przedsiebiorcy values(";
		query1 += main.getUser().getUserId() + ",'" + main.getUser().getLogin()
				+ "','" + name + "','" + website + "')";
		// Dodaj do odpowiedniej relacji
		String query = "Insert Into zespoly values(";
		query += main.getUser().getUserId() + "," + banquetInt + ","
				+ rockInt + "," + folkInt + "," + popInt + ","
				+ metalInt + ")";
		System.out.println(query1);
		System.out.println(query);
		main.getDbmenager().updateQuery(query);
		main.getDbmenager().updateQuery(query1);
		System.out.println("Dodano dodatkowe informacje");
	}
}
