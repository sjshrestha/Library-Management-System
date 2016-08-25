package ui.controller;

import java.util.List;

import dataaccess.storage.AddressDto;
import dataaccess.storage.AuthorDto;
import dataaccess.storage.BookDto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AddAuthorInfoController {
	@FXML TextField firstname;
	@FXML TextField lastname;
	@FXML TextField phone;
	@FXML TextArea shortBio;
	@FXML TextField street;
	@FXML TextField city;
	@FXML TextField state;
	@FXML TextField zipcode;
	@FXML Button save;
	@FXML Button cancel;
	
	List<AuthorDto> authors;
	public AddAuthorInfoController(){
		
	}
	
	public void setAuthor(List<AuthorDto> authors){
		this.authors = authors;
	}
	
	public void addAuthor(){
		try{
		AddressDto address = new AddressDto(this.street.getText().trim(),
				this.city.getText().trim(),
				this.state.getText().trim(),
				this.zipcode.getText().trim());
		authors.add(new AuthorDto(firstname.getText(), lastname.getText(), shortBio.getText(), address, phone.getText()));
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("New Author info has been added successfully.");
		alert.showAndWait();
		}
		catch(Exception e){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error.");
			alert.setHeaderText(null);
			alert.setContentText("Author info is not Added\n please try again");

			alert.showAndWait();
		}
	}
	public void cancel(){
		Stage stage = (Stage) cancel.getScene().getWindow();
	    stage.close();
	}
	
}
