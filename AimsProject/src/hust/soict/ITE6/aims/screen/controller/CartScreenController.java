package hust.soict.ITE6.aims.screen.controller;

import hust.soict.ITE6.aims.cart.CartLHY;
import hust.soict.ITE6.aims.media.Media;
import hust.soict.ITE6.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	private CartLHY cart;
    
	@FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;
    
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TextField tfFilter;
    
    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;
    
    @FXML
    private Label costLabel;

    @FXML
    private Button placeOrder;

	public CartScreenController(CartLHY cart) {
		super();
		this.cart = cart;
	}
	
	@FXML
	void placeOrderPressed(ActionEvent event) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION, cart.placeOrder());
		alert.setTitle("Order created");
		alert.setHeaderText(null);
		alert.showAndWait();
	}
	
	@FXML
	void btnPlayPressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		Alert alert = new Alert(Alert.AlertType.NONE, media.playGUI());
		alert.setTitle("Playing");
		alert.setHeaderText(null);
		alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
		alert.showAndWait();
	}
	
	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		costLabel.setText(cart.totalCost() + " $");
	}
	
	
	@FXML 
	private void initialize() {
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		tblMedia.setItems(this.cart.getItemsOrdered());
		
		costLabel.setText(cart.totalCost() + "$");
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {
					
					@Override
					public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
						if(newValue!=null) {
							updateButtonBar(newValue);
						}
					}
					
					private void updateButtonBar(Media media) {
						btnRemove.setVisible(true);
						if(media instanceof Playable) {
							btnPlay.setVisible(true);
						} else {
							btnPlay.setVisible(false);
						}
					}
				});
		
		tfFilter.textProperty().addListener(
	            new ChangeListener<String>() {

		            @Override
		            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		                showFilteredMedia(newValue);
		            }
	
		            private void showFilteredMedia(String searchText) {
		                FilteredList<Media> filteredMediaList = new FilteredList<>(cart.getItemsOrdered());

		                if (!searchText.isEmpty() && radioBtnFilterId.isSelected()) {
		                    filteredMediaList.setPredicate(media -> String.valueOf(media.getId()).equals(searchText));
		                } else if (!searchText.isEmpty() && radioBtnFilterTitle.isSelected()) {
		                    filteredMediaList.setPredicate(media -> media.getTitle().toLowerCase().contains(searchText.toLowerCase()));
		                } else {
		                    filteredMediaList.setPredicate(null);
		                }
		                
		                tblMedia.setItems(filteredMediaList);
		            }
		        });
	}
}
