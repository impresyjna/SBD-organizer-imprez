package application.controler;

import java.io.IOException;
import java.sql.SQLException;

import entities.ContactEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class contactWithClientPageController {
	// Reference to the main application.
		private Main main;

		@FXML
		private TableView<ContactEntity> Dates;
		@FXML
		private TableColumn<ContactEntity, String> ProductId; 
		@FXML
		private TableColumn<ContactEntity, String> Name; 
		@FXML
		private TableColumn<ContactEntity, String> CustomerName; 
		@FXML
		private TableColumn<ContactEntity, String> CustomerSurname; 
		@FXML
		private TableColumn<ContactEntity, String> Mail; 
		@FXML
		private TableColumn<ContactEntity, String> Number; 
		@FXML
		private TableColumn<ContactEntity, String> Day; 
		@FXML
		private TableColumn<ContactEntity, String> Month; 
		@FXML
		private TableColumn<ContactEntity, String> Year; 
		@FXML
		private TableColumn<ContactEntity, String> PartyName; 
		@FXML
		private TableColumn<ContactEntity, String> Place; 
		@FXML
		private TableColumn<ContactEntity, String> State; 
		@FXML
		private Label DayLabel; 
		@FXML
		private Label MonthLabel; 
		@FXML
		private Label YearLabel; 
		@FXML
		private Label ProductIdLabel; 
		@FXML
		private Label NameLabel; 
		@FXML
		private Label MailLabel; 
		@FXML
		private Label PartyNameLabel; 
		@FXML
		private Label CustomerNameLabel; 
		@FXML
		private Label SurnameLabel; 
		@FXML
		private Label NumberLabel; 
		@FXML
		private Label PlaceLabel; 
		@FXML
		private Label StateLabel; 

		private void fillTable() throws SQLException {
			final ObservableList<ContactEntity> data = FXCollections.observableArrayList();
			String query="select r.id_produktu, r.nazwa, o.imie, o.nazwisko, u.mail, "
					+ "u.numer, r.dzien, r.miesiac, r.rok, r.nazwa_imp, i.miejsce, "
					+ "r.stan from rezerwacje r join uzytkownicy u on u.id=r.id_organizatora "
					+ "join organizatorzy o on r.id_organizatora=o.id_uzytkownika join imprezy "
					+ "i on r.id_imprezy = i.id_imp where r.stan<2 and r.id_przedsiebiorcy="+main.getUser().getUserId(); 
			System.out.println(query);
			main.getDbmenager().selectQuery(query);
			while (main.getDbmenager().getRs().next())
			{
				int state=main.getDbmenager().getRs().getInt(12); 
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
				data.add(new ContactEntity(main.getDbmenager().getRs().getInt(1), main.getDbmenager().getRs().getString(2), 
						main.getDbmenager().getRs().getString(3), main.getDbmenager().getRs().getString(4), 
						main.getDbmenager().getRs().getString(5), main.getDbmenager().getRs().getString(6), 
						main.getDbmenager().getRs().getInt(7), main.getDbmenager().getRs().getInt(8), 
						main.getDbmenager().getRs().getInt(9), main.getDbmenager().getRs().getString(10), 
						main.getDbmenager().getRs().getString(11), stateName)); 
			}
			Dates.setItems(data);
		}

		public void setMainApp(Main mainApp) throws SQLException {
			this.main = mainApp;
			fillTable();
		}

		private void showDateDetails(ContactEntity contact) {
			if (contact != null) {
				DayLabel.setText(Integer.toString(contact.getDay()));
				MonthLabel.setText(Integer.toString(contact.getMonth()));
				YearLabel.setText(Integer.toString(contact.getYear()));
				ProductIdLabel.setText(Integer.toString(contact.getProductId()));
				NameLabel.setText(contact.getName());
				MailLabel.setText(contact.getMail());
				PartyNameLabel.setText(contact.getPartyName());
				CustomerNameLabel.setText(contact.getCustomerName());
				SurnameLabel.setText(contact.getCustomerSurname());
				NumberLabel.setText(contact.getNumber());
				PlaceLabel.setText(contact.getPlace());
				StateLabel.setText(contact.getState());
			} else {
				// Person is null, remove all the text.
				DayLabel.setText("");
				MonthLabel.setText("");
				YearLabel.setText("");
				ProductIdLabel.setText("");
				NameLabel.setText("");
				MailLabel.setText("");
				PartyNameLabel.setText("");
				CustomerNameLabel.setText("");
				SurnameLabel.setText("");
				NumberLabel.setText("");
				PlaceLabel.setText("");
				StateLabel.setText("");
				
			}
		}

		@FXML
		private void handleBack() throws IOException {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/companyFirstPage.fxml"));
			AnchorPane fillPage = (AnchorPane) loader.load();
			main.getRootLayout().setCenter(fillPage);
			companyFirstPageController controller1 = loader.getController();
			controller1.setMainApp(main);
			main = null;
		}

		@FXML
		private void initialize() {
			ProductId.setCellValueFactory(new PropertyValueFactory<>("productId"));
			Name.setCellValueFactory(new PropertyValueFactory<>("name"));
			CustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
			CustomerSurname.setCellValueFactory(new PropertyValueFactory<>("customerSurname"));
			Mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
			Number.setCellValueFactory(new PropertyValueFactory<>("number"));
			Day.setCellValueFactory(new PropertyValueFactory<>("day"));
			Month.setCellValueFactory(new PropertyValueFactory<>("month"));
			Year.setCellValueFactory(new PropertyValueFactory<>("year"));
			PartyName.setCellValueFactory(new PropertyValueFactory<>("partyName"));
			Place.setCellValueFactory(new PropertyValueFactory<>("place"));
			State.setCellValueFactory(new PropertyValueFactory<>("state"));
	
			showDateDetails(null);

			// Listen for selection changes and show the person details when
			// changed.
			Dates.getSelectionModel()
					.selectedItemProperty()
					.addListener(
							(observable, oldValue, newValue) -> showDateDetails(newValue)); 
		}
		
		@FXML
		private void handleAccept() throws SQLException
		{
			String query="update rezerwacje set stan=1 where id_produktu="
					+ ProductIdLabel.getText() + " and id_organizatora=(select id from uzytkownicy where mail='"+ MailLabel.getText() + "')";  
			System.out.println(query);
			main.getDbmenager().updateQuery(query);
			String query1="update terminarz set rezerwacja=1 where id_produktu= " + ProductIdLabel.getText() + " and id_uzytkownika= " + main.getUser().getUserId(); 
			System.out.println(query1);
			main.getDbmenager().updateQuery(query1);
			System.out.println("Zaktualizowano");
			fillTable();
		}
		
		@FXML
		private void handleReject() throws SQLException
		{
			String query="update rezerwacje set stan=2 where id_produktu="
					+ ProductIdLabel.getText() + " and id_organizatora=(select id from uzytkownicy where mail='"+ MailLabel.getText() + "')";  
			System.out.println(query);
			main.getDbmenager().updateQuery(query);
			System.out.println("Zaktualizowano");
			fillTable();
			
		}
		//TODO: Write this in a good way
		

}
