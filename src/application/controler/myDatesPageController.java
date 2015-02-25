package application.controler;

import java.io.IOException;
import java.sql.SQLException;

import entities.Date;
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

public class myDatesPageController {

	// Reference to the main application.
	private Main main;

	@FXML
	private TableView<Date> Dates;
	@FXML
	private TableColumn<Date, String> ProductId;
	@FXML
	private TableColumn<Date, String> Name;
	@FXML
	private TableColumn<Date, String> Day;
	@FXML
	private TableColumn<Date, String> Month;
	@FXML
	private TableColumn<Date, String> Year;
	@FXML
	private Label ProductIdLabel;
	@FXML
	private Label NameLabel;
	@FXML
	private Label DayLabel;
	@FXML
	private Label MonthLabel;
	@FXML
	private Label YearLabel;

	private void fillTable() throws SQLException {
		final ObservableList<Date> data = FXCollections.observableArrayList();
		String query = "select id_produktu,nazwa, dzien, miesiac, rok, rezerwacja from terminarz join produkty on id_prod=id_produktu where uzytkownicy="
				+ main.getUser().getUserId();
		main.getDbmenager().selectQuery(query);
		while (main.getDbmenager().getRs().next()) {
			data.add(new Date(main.getDbmenager().getRs().getInt(1), main
					.getDbmenager().getRs().getString(2), main.getDbmenager()
					.getRs().getInt(3), main.getDbmenager().getRs().getInt(4),
					main.getDbmenager().getRs().getInt(5)));
		}
		Dates.setItems(data);
	}

	public void setMainApp(Main mainApp) throws SQLException {
		this.main = mainApp;
		fillTable();
	}

	private void showDateDetails(Date date) {
		if (date != null) {
			ProductIdLabel.setText(Integer.toString(date.getProductId()));
			NameLabel.setText(date.getName());
			DayLabel.setText(Integer.toString(date.getDay()));
			MonthLabel.setText(Integer.toString(date.getMonth()));
			YearLabel.setText(Integer.toString(date.getYear()));
		} else {
			// Person is null, remove all the text.
			ProductIdLabel.setText("");
			NameLabel.setText("");
			DayLabel.setText("");
			MonthLabel.setText("");
			YearLabel.setText("");
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
		Day.setCellValueFactory(new PropertyValueFactory<>("day"));
		Month.setCellValueFactory(new PropertyValueFactory<>("month"));
		Year.setCellValueFactory(new PropertyValueFactory<>("year"));

		showDateDetails(null);

		// Listen for selection changes and show the person details when
		// changed.
		Dates.getSelectionModel()
				.selectedItemProperty()
				.addListener(
						(observable, oldValue, newValue) -> showDateDetails(newValue));
	}

}
