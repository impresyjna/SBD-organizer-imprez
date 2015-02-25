package application.controler;

import java.io.IOException;
import java.sql.SQLException;

import entities.Product;
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

public class myOfferPageController {
	// Reference to the main application.
	private Main main;

	@FXML
	private TableView<Product> Offer;
	@FXML
	private TableColumn<Product, String> ProductID;
	@FXML
	private TableColumn<Product, String> Name;
	@FXML
	private TableColumn<Product, String> Price;
	@FXML
	private TableColumn<Product, String> Details;
	@FXML
	private Label ProductIdLabel; 
	@FXML
	private Label NameLabel; 
	@FXML
	private Label PriceLabel; 
	@FXML
	private Label DetailsLabel; 

	private void fillTable() throws SQLException
	{
		final ObservableList<Product> data = FXCollections
				.observableArrayList();
		String query="select * from produkty where uzytkownicy="+main.getUser().getUserId(); 
		main.getDbmenager().selectQuery(query);
		while (main.getDbmenager().getRs().next()) {
			data.add(new Product(main.getDbmenager().getRs().getInt(1), main
					.getDbmenager().getRs().getString(3), main.getDbmenager()
					.getRs().getFloat(4), main.getDbmenager().getRs()
					.getString(5)));
		}
		Offer.setItems(data);
	}
	
	public void setMainApp(Main mainApp) throws SQLException{
		this.main = mainApp;
		fillTable(); 
	}

	
	private void showOfferDetails(Product product) {
	    if (product != null) {
	        // Fill the labels with info from the person object.
	        ProductIdLabel.setText(Integer.toString(product.getProductId()));
	        NameLabel.setText(product.getName());
	        PriceLabel.setText(Float.toString(product.getPrice()));
	        DetailsLabel.setText(product.getDetails());

	    } else {
	        // Person is null, remove all the text.
	        ProductIdLabel.setText("");
	        NameLabel.setText("");
	        PriceLabel.setText("");
	        DetailsLabel.setText("");
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
		
		showOfferDetails(null);
		
		 // Listen for selection changes and show the person details when changed.
	    Offer.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> showOfferDetails(newValue));
	}
	
	@FXML
	private void handleDelete() throws SQLException
	{
		String query="DELETE FROM produkty WHERE id_prod="; 
		query+=ProductIdLabel.getText(); 
		System.out.println(query);
		main.getDbmenager().updateQuery(query);
		System.out.println("Usunieto");
		fillTable();
		
	}
}
