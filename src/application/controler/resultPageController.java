package application.controler;

import java.io.IOException;
import java.sql.SQLException;

import entities.ResultEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class resultPageController {
	// Reference to the main application.
	private Main main;

	@FXML
	private Button ReserveButton;
	@FXML
	private TableView<ResultEntity> Result;
	@FXML
	private TableColumn<ResultEntity, String> ProductId;
	@FXML
	private TableColumn<ResultEntity, String> Name;
	@FXML
	private TableColumn<ResultEntity, String> Price;
	@FXML
	private TableColumn<ResultEntity, String> Details;
	@FXML
	private TableColumn<ResultEntity, String> Day;
	@FXML
	private TableColumn<ResultEntity, String> Month;
	@FXML
	private TableColumn<ResultEntity, String> Year;
	@FXML
	private TableColumn<ResultEntity, String> CompanyName;
	@FXML
	private TableColumn<ResultEntity, String> Website;
	@FXML
	private TableColumn<ResultEntity, String> Phone;
	@FXML
	private TableColumn<ResultEntity, String> Mail;
	@FXML
	private ComboBox<String> PartyCombo; 
	@FXML
	private Label ProductIdLabel;
	@FXML
	private Label NameLabel;
	@FXML
	private Label PriceLabel;
	@FXML
	private Label DetailsLabel;
	@FXML
	private Label DayLabel;
	@FXML
	private Label MonthLabel;
	@FXML
	private Label YearLabel;
	@FXML
	private Label CompanyNameLabel;
	@FXML
	private Label WebsiteLabel;
	@FXML
	private Label PhoneLabel;
	@FXML
	private Label MailLabel;
	@FXML
	private Label PartyLabel; 

	private void fillTable() throws SQLException {
		final ObservableList<ResultEntity> data = FXCollections
				.observableArrayList();
		while (main.getDbmenager().getRs().next()) {
			data.add(new ResultEntity(main.getDbmenager().getRs().getInt(1),
					main.getDbmenager().getRs().getString(2), main
							.getDbmenager().getRs().getFloat(3), main
							.getDbmenager().getRs().getString(4), main
							.getDbmenager().getRs().getInt(5), main
							.getDbmenager().getRs().getInt(6), main
							.getDbmenager().getRs().getInt(7), main
							.getDbmenager().getRs().getString(8), main
							.getDbmenager().getRs().getString(9), main
							.getDbmenager().getRs().getString(10), main
							.getDbmenager().getRs().getString(11)));
		}
		Result.setItems(data);
		
	}

	public void setMainApp(Main mainApp) throws SQLException {
		this.main = mainApp;
		fillTable();
		if (!main.getUser().getProfession().equals("Organizator")) {
			ReserveButton.setVisible(false);
			PartyCombo.setVisible(false);
			PartyLabel.setVisible(false);
		}
		else
		{
			ObservableList<String> parties = FXCollections.observableArrayList();
			String query = "select id_imp, nazwa from imprezy where organizatorzy= " + main.getUser().getUserId();
			main.getDbmenager().selectQuery(query);
			while (main.getDbmenager().getRs().next()) {
				parties.add(main.getDbmenager().getRs().getInt(1) + "." + main.getDbmenager().getRs().getString(2));
			}
			PartyCombo.setItems(parties);
		}		
	}

	private void showPartyDetails(ResultEntity result) {
		if (result != null) {
			ProductIdLabel.setText(Integer.toString(result.getProductId()));
			NameLabel.setText(result.getName());
			PriceLabel.setText(Float.toString(result.getPrice()));
			DetailsLabel.setText(result.getDetails());
			DayLabel.setText(Integer.toString(result.getDay()));
			MonthLabel.setText(Integer.toString(result.getMonth()));
			YearLabel.setText(Integer.toString(result.getYear()));
			CompanyNameLabel.setText(result.getCompanyName());
			WebsiteLabel.setText(result.getWebsite());
			PhoneLabel.setText(result.getNumber());
			MailLabel.setText(result.getMail());
		} else {
			// Person is null, remove all the text.
			ProductIdLabel.setText("");
			NameLabel.setText("");
			PriceLabel.setText("");
			DetailsLabel.setText("");
			DayLabel.setText("");
			MonthLabel.setText("");
			YearLabel.setText("");
			CompanyNameLabel.setText("");
			WebsiteLabel.setText("");
			PhoneLabel.setText("");
			MailLabel.setText("");
		}
	}

	@FXML
	private void handleBack() throws IOException {
		System.out.println(main.getUser().getProfession());
		if (main.getUser().getProfession().equals("Organizator")) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("view/organiserFirstPage.fxml"));
			AnchorPane welcomePage = (AnchorPane) loader.load();
			main.getRootLayout().setCenter(welcomePage);
			organiserFirstPageController controller = loader.getController();
			controller.setMainApp(main);
			main = null;
		} else if (main.getUser().getProfession().equals("Niezalogowany")) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("view/unregisterFirstPage.fxml"));
			AnchorPane welcomePage = (AnchorPane) loader.load();
			main.getRootLayout().setCenter(welcomePage);
			unregisterFirstPageController controller = loader.getController();
			controller.setMainApp(main);
			main = null;
		} else {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("view/companyFirstPage.fxml"));
			AnchorPane welcomePage = (AnchorPane) loader.load();
			main.getRootLayout().setCenter(welcomePage);
			companyFirstPageController controller = loader.getController();
			controller.setMainApp(main);
			main = null;
		}
	}

	@FXML
	private void initialize() {
		ProductId.setCellValueFactory(new PropertyValueFactory<>("productId"));
		Name.setCellValueFactory(new PropertyValueFactory<>("name"));
		Price.setCellValueFactory(new PropertyValueFactory<>("price"));
		Details.setCellValueFactory(new PropertyValueFactory<>("details"));
		Day.setCellValueFactory(new PropertyValueFactory<>("day"));
		Month.setCellValueFactory(new PropertyValueFactory<>("month"));
		Year.setCellValueFactory(new PropertyValueFactory<>("year"));
		CompanyName.setCellValueFactory(new PropertyValueFactory<>(
				"companyName"));
		Website.setCellValueFactory(new PropertyValueFactory<>("website"));
		Phone.setCellValueFactory(new PropertyValueFactory<>("number"));
		Mail.setCellValueFactory(new PropertyValueFactory<>("mail"));

		showPartyDetails(null);

		// Listen for selection changes and show the person details when //
		Result.getSelectionModel()
				.selectedItemProperty()
				.addListener(
						(observable, oldValue, newValue) -> showPartyDetails(newValue));

	}

	@FXML
	public void handleReserve() throws SQLException {
		String pomQuery="select uzytkownicy from produkty where id_prod= " + ProductIdLabel.getText();
		System.out.println(pomQuery);
		main.getDbmenager().selectQuery(pomQuery);
		main.getDbmenager().getRs().next(); 
		int companyId=main.getDbmenager().getRs().getInt(1); 
		String party; 
		party=PartyCombo.getValue(); 
		String[] partyParts = party.split("\\."); 
		String query="Insert into rezerwacje values("; 
		query+=ProductIdLabel.getText() +",'"+ NameLabel.getText() + "'," + main.getUser().getUserId() + "," + companyId + ","; 
		query+=PriceLabel.getText() + "," + DayLabel.getText() + "," + MonthLabel.getText() + "," + YearLabel.getText() + ",'" + DetailsLabel.getText() + "',"; 
		query+=partyParts[0] + ",'" + partyParts[1] + "', 0 )"; 
		System.out.println(query);
		main.getDbmenager().updateQuery(query);
		System.out.println("Dodano now¹ rezerwacjê");
	}
	
}
