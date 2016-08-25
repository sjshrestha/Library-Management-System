package ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

import business.LibraryMemberDao;
import dataaccess.FilePath;
import dataaccess.storage.AddressDto;
import dataaccess.storage.LibraryMemberDto;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LibraryMemberController implements Initializable {
	@FXML TextField memberId;
	@FXML TextField firstName;
	@FXML TextField lastName;
	@FXML TextField phoneNo;
	@FXML TextField state;
	@FXML TextField city;
	@FXML TextField street;
	@FXML TextField zipCode;
	@FXML Label title;

	LibraryMemberDao memberManager;
	List<LibraryMemberDto> members;

	boolean isBeingEdited = false;
	LibraryMemberDto memberToEdit = null;
	DisplayLibraryMemberController parent = null;

	public LibraryMemberController() throws Exception{
		memberManager = new LibraryMemberDao(FilePath.MEMBER_RECORD);

		Object data = memberManager.getMemberList();
		if(data == null){
			members = new ArrayList<LibraryMemberDto>();
		}
		else{
			members = memberManager.getMemberList();
		}
		//LibraryMemberDto object = (LibraryMemberDto)libraryMember.getMemberList();
	}

	public void setEditMode(LibraryMemberDto member, DisplayLibraryMemberController parent){
		isBeingEdited = true;
		this.parent = parent;
		this.memberId.setDisable(true);
		this.title.setText("Edit Library Member");

		this.memberToEdit = member;
		this.memberId.setText(member.getMemberId());
		this.firstName.setText(member.getFirstName());
		this.lastName.setText(member.getLastName());
		this.phoneNo.setText(member.getPhoneNo());
		this.state.setText(member.getAddress().getState());
		this.city.setText(member.getAddress().getCity());
		this.street.setText(member.getAddress().getStreet());
		this.zipCode.setText(member.getAddress().getZipCode());
	}

	public void addLibraryMember(){
		try{
			if(!isBeingEdited){
				add();
			}
			else{
				edit();
			}
		}
		catch(Exception ex){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error occurred.");
			alert.setHeaderText(null);
			alert.setContentText(ex.getMessage());

			alert.showAndWait();
		}
	}

	public void add() throws Exception{
		if(memberManager.doesMemberExist(this.memberId.getText().trim())){
			showMessage("Member Id [" + this.memberId.getText().trim() + "] already exists.\n\nPlease check." );
			return;
		}
		AddressDto address = new AddressDto(this.street.getText().trim(),
				this.city.getText().trim(),
				this.state.getText().trim(),
				this.zipCode.getText().trim());

		LibraryMemberDto member = new LibraryMemberDto(this.memberId.getText().trim(),
									this.firstName.getText().trim(),
									this.lastName.getText().trim(),
									address,
									this.phoneNo.getText().trim());

		members.add(member);
		memberManager.addMember(members);

		showMessage("New library member has been added successfully.");
		this.clear();
	}
	
	void showMessage(String message){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText(message);

		alert.showAndWait();
	}

	public void edit() throws Exception{
		for (LibraryMemberDto libraryMemberDto : this.members) {
			//System.out.println(libraryMemberDto.getMemberId().toString() + " : " + memberToEdit.getMemberId().toString());
			if(libraryMemberDto.equals(memberToEdit)){

				libraryMemberDto.setFirstName(this.firstName.getText());
				libraryMemberDto.setLastName(this.lastName.getText());
				libraryMemberDto.setPhoneNo(this.phoneNo.getText());
				libraryMemberDto.getAddress().setState(this.state.getText());
				libraryMemberDto.getAddress().setCity(this.city.getText());
				libraryMemberDto.getAddress().setStreet(this.street.getText());
				libraryMemberDto.getAddress().setZipCode(this.zipCode.getText());

				memberManager.addMember(members);
				parent.SearchMembers();

				Stage stage = (Stage)this.firstName.getScene().getWindow();
			    stage.close();

				break;
			}
		}
	}
	
	void clear(){
		this.memberId.clear();
		this.firstName.clear();
		this.lastName.clear();
		this.phoneNo.clear();
		this.state.clear();
		this.street.clear();
		this.city.clear();
		this.zipCode.clear();
		
		this.isBeingEdited = false;
		this.memberToEdit = null;
	}
	
	public void cancel(){
		Stage stage = (Stage)this.firstName.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
	    Platform.runLater(new Runnable() {
	        @Override
	        public void run() {
	            memberId.requestFocus();
	        }
	    });
	}
}
