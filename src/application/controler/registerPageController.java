package application.controler;

import java.io.IOException;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class registerPageController {

	// Reference to the main application.
	private Main main;

	@FXML
	private TextField Login;
	@FXML
	private TextField Password;
	@FXML
	private TextField RepeatPassword;
	@FXML
	private TextField Mail;
	@FXML
	private TextField Number;
	@FXML
	private ComboBox<String> Profession;

	public ObservableList<String> Professions = FXCollections
			.observableArrayList("Fotograf", "Restaurator", "Catering",
					"Zespó³", "Inne");

	public void setMainApp(Main mainApp) {
		this.main = mainApp;
	}

	public void fillCombo() {
		Profession.setItems(Professions);
	}

	@FXML
	private void handleBack() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/welcomePage.fxml"));
		AnchorPane welcomePage = (AnchorPane) loader.load();
		main.getRootLayout().setCenter(welcomePage);
		welcomePageController controller = loader.getController();
		controller.setMainApp(main);
		main = null;
	}

	@FXML
	private void handleRegister() throws SQLException, IOException {
		String login;
		String password;
		String repeatPassword;
		String mail;
		String number;
		String profession;
		login = Login.getText();
		password = Password.getText();
		repeatPassword = RepeatPassword.getText();
		mail = Mail.getText();
		number = Number.getText();
		profession = Profession.getValue();
		if (password.equals(repeatPassword)) {
			String query = "INSERT INTO Uzytkownicy VALUES(UZYTKOWNICY_SEQ.NEXTVAL,'";
			query += login + "','" + password + "','" + mail + "','" + number
					+ "','" + profession + "')";
			System.out.println(query);
			main.getDbmenager().updateQuery(query);
			String query1 = "Select * from uzytkownicy where login='" + login
					+ "'";
			System.out.println(query1);
			main.getDbmenager().selectQuery(query1);
			System.out.println("Zarejestrowano");
			main.getDbmenager().getRs().next(); 
			main.getUser().setUserId(main.getDbmenager().getRs().getInt(1));
			main.getUser().setLogin(main.getDbmenager().getRs().getString(2));
			main.getUser()
					.setPassword(main.getDbmenager().getRs().getString(3));
			main.getUser().setMail(main.getDbmenager().getRs().getString(4));
			main.getUser().setTelephone(
					main.getDbmenager().getRs().getString(5));
			main.getUser().setProfession(
					main.getDbmenager().getRs().getString(6));

			if (main.getDbmenager().getRs().getString(6).equals("Organizator")) {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Main.class
						.getResource("view/organiserFirstPage.fxml"));
				AnchorPane organiserPage = (AnchorPane) loader.load();
				main.getRootLayout().setCenter(organiserPage);
				organiserFirstPageController controller = loader
						.getController();
				controller.setMainApp(main);
				main = null;
			} else {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Main.class
						.getResource("view/companyFirstPage.fxml"));
				AnchorPane companyPage = (AnchorPane) loader.load();
				main.getRootLayout().setCenter(companyPage);
				companyFirstPageController controller = loader.getController();
				controller.setMainApp(main);
				main = null;
			}
		}
		else
		{
			Password.clear();
			RepeatPassword.clear();
			System.out.println("Has³a siê nie zgadzaj¹");
		}
	}

}
