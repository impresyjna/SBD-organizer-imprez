package application.controler;

import java.io.IOException;
import java.sql.SQLException;

import entities.OneParty;
import entities.Party;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class myPartiesPageController {

	// Reference to the main application.
	private Main main;

	@FXML
	private TableView<Party> Party;
	@FXML
	private TableColumn<Party, String> PartyId;
	@FXML
	private TableColumn<Party, String> Name;
	@FXML
	private TableColumn<Party, String> Day;
	@FXML
	private TableColumn<Party, String> Month;
	@FXML
	private TableColumn<Party, String> Year;
	@FXML
	private TableColumn<Party, String> Place;
	@FXML
	private TableView<OneParty> SingleParty;
	@FXML
	private TableColumn<OneParty, String> SProductId;
	@FXML
	private TableColumn<OneParty, String> SProductName;
	@FXML
	private TableColumn<OneParty, String> SCompanyName;
	@FXML
	private TableColumn<OneParty, String> SPrice;
	@FXML
	private TableColumn<OneParty, String> SDay;
	@FXML
	private TableColumn<OneParty, String> SMonth;
	@FXML
	private TableColumn<OneParty, String> SYear;
	@FXML
	private TableColumn<OneParty, String> SWebsite;
	@FXML
	private TableColumn<OneParty, String> SNumber;
	@FXML
	private TableColumn<OneParty, String> SState;

	private void fillTable() throws SQLException {
		final ObservableList<Party> data = FXCollections.observableArrayList();
		String query = "select * from imprezy where organizatorzy="
				+ main.getUser().getUserId();
		main.getDbmenager().selectQuery(query);
		while (main.getDbmenager().getRs().next()) {
			data.add(new Party(main.getDbmenager().getRs().getInt(1), main
					.getDbmenager().getRs().getString(7), main.getDbmenager()
					.getRs().getInt(3), main.getDbmenager().getRs().getInt(4),
					main.getDbmenager().getRs().getInt(5), main.getDbmenager()
							.getRs().getString(6)));
		}
		Party.setItems(data);
	}

	public void setMainApp(Main mainApp) throws SQLException {
		this.main = mainApp;
		fillTable();
	}

	private void showPartyDetails(Party party) {
		if (party != null) {
			ObservableList<OneParty> partyDetails = FXCollections.observableArrayList();
			String query="select r.id_produktu, r.nazwa, p.nazwa, r.cena, r.dzien, r.miesiac, "
					+ "r.rok, p.strona, u.numer, r.stan from rezerwacje r join przedsiebiorcy p "
					+ "on r.id_przedsiebiorcy=p.id join uzytkownicy u on u.id=p.id where "
					+ "r.id_organizatora=" + main.getUser().getUserId() + "and id_imprezy=" + party.getPartyId() ; 
			System.out.println(query);
			try {
				main.getDbmenager().selectQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				while (main.getDbmenager().getRs().next())
				{
					int state=main.getDbmenager().getRs().getInt(10); 
					String stateName; 
					switch (state) {
					case 0:
						stateName="W realizacji";
						break;
					case 1:
						stateName="Zaakceptowana"; 
						break; 
					default:
						stateName="Odrzucona";
						break;
					}
					partyDetails.add(new OneParty(main.getDbmenager().getRs().getInt(1), main.getDbmenager().getRs().getString(2), 
							main.getDbmenager().getRs().getString(3), main.getDbmenager().getRs().getFloat(4), 
							main.getDbmenager().getRs().getInt(5), main.getDbmenager().getRs().getInt(6), 
							main.getDbmenager().getRs().getInt(7), main.getDbmenager().getRs().getString(8), 
							main.getDbmenager().getRs().getString(9), stateName)); 
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			SingleParty.setItems(partyDetails);
			
		} 
		else {
			ObservableList<OneParty> partyDetails = FXCollections.observableArrayList();
			partyDetails.add(null); 
			SingleParty.setItems(partyDetails);
		}
	}

	@FXML
	private void handleBack() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class
				.getResource("view/organiserFirstPage.fxml"));
		AnchorPane fillPage = (AnchorPane) loader.load();
		main.getRootLayout().setCenter(fillPage);
		organiserFirstPageController controller1 = loader.getController();
		controller1.setMainApp(main);
		main = null;
	}

	@FXML
	private void initialize(){
		PartyId.setCellValueFactory(new PropertyValueFactory<>("partyId"));
		Name.setCellValueFactory(new PropertyValueFactory<>("name"));
		Day.setCellValueFactory(new PropertyValueFactory<>("day"));
		Month.setCellValueFactory(new PropertyValueFactory<>("month"));
		Year.setCellValueFactory(new PropertyValueFactory<>("year"));
		Place.setCellValueFactory(new PropertyValueFactory<>("place"));
		
		SProductId.setCellValueFactory(new PropertyValueFactory<>("productId"));
		SProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
		SCompanyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
		SPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
		SDay.setCellValueFactory(new PropertyValueFactory<>("day"));
		SMonth.setCellValueFactory(new PropertyValueFactory<>("month"));
		SYear.setCellValueFactory(new PropertyValueFactory<>("year"));
		SWebsite.setCellValueFactory(new PropertyValueFactory<>("website"));
		SNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
		SState.setCellValueFactory(new PropertyValueFactory<>("state"));

		showPartyDetails(null);

		// Listen for selection changes and show the person details when
		// changed.

			Party.getSelectionModel()
					.selectedItemProperty()
					.addListener(
							(observable, oldValue, newValue) -> showPartyDetails(newValue));
	}
}
