package application.controler;

import java.io.IOException;
import java.sql.SQLException;

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
import entities.Room;

public class restorerMyOfferPageController {
	// Reference to the main application.
	private Main main;

	@FXML
	private TableView<Room> Offer;
	@FXML
	private TableColumn<Room, String> ProductID;
	@FXML
	private TableColumn<Room, String> Name;
	@FXML
	private TableColumn<Room, String> Price;
	@FXML
	private TableColumn<Room, String> Details;
	@FXML
	private TableColumn<Room, String> Size;
	@FXML
	private Label ProductIdLabel;
	@FXML
	private Label NameLabel;
	@FXML
	private Label PriceLabel;
	@FXML
	private Label DetailsLabel;
	@FXML
	private Label SizeLabel;

	private void fillTable() throws SQLException {
		final ObservableList<Room> data = FXCollections.observableArrayList();
		String query = "select id_prod, nazwa, cena, szczegoly, pojemnosc from produkty join sale on id_prod=id_produktu where uzytkownicy="
				+ main.getUser().getUserId();
		main.getDbmenager().selectQuery(query);
		while (main.getDbmenager().getRs().next()) {
			data.add(new Room(main.getDbmenager().getRs().getInt(1), main
					.getDbmenager().getRs().getString(2), main.getDbmenager()
					.getRs().getFloat(3), main.getDbmenager().getRs()
					.getString(4), main.getDbmenager().getRs().getInt(5)));
		}
		Offer.setItems(data);
	}

	public void setMainApp(Main mainApp) throws SQLException {
		this.main = mainApp;
		fillTable();
	}

	private void showOfferDetails(Room room) {
		if (room != null) {
			// Fill the labels with info from the person object.
			ProductIdLabel.setText(Integer.toString(room.getProductId()));
			NameLabel.setText(room.getName());
			PriceLabel.setText(Float.toString(room.getPrice()));
			DetailsLabel.setText(room.getDetails());
			SizeLabel.setText(Integer.toString(room.getSize()));

		} else {
			// Person is null, remove all the text.
			ProductIdLabel.setText("");
			NameLabel.setText("");
			PriceLabel.setText("");
			DetailsLabel.setText("");
			SizeLabel.setText("");
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
		ProductID.setCellValueFactory(new PropertyValueFactory<>("productId"));
		Name.setCellValueFactory(new PropertyValueFactory<>("name"));
		Price.setCellValueFactory(new PropertyValueFactory<>("price"));
		Details.setCellValueFactory(new PropertyValueFactory<>("details"));
		Size.setCellValueFactory(new PropertyValueFactory<>("size"));
		showOfferDetails(null);
		Offer.getSelectionModel()
				.selectedItemProperty()
				.addListener(
						(observable, oldValue, newValue) -> showOfferDetails(newValue));
	}

	@FXML
	private void handleDelete() throws SQLException {
		String query = "DELETE FROM produkty WHERE id_prod=";
		query += ProductIdLabel.getText();
		String query1 = "Delete from sale where id_produktu="; 
		query1+=ProductIdLabel.getText();
		System.out.println(query);
		System.out.println(query1);
		main.getDbmenager().updateQuery(query);
		System.out.println("Usunieto");
		fillTable();

	}
}
