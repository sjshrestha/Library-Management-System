package ui.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import application.JustDoIt.Person;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import business.LibraryMemberDao;
import dataaccess.FilePath;
import dataaccess.storage.AddressDto;
import dataaccess.storage.LibraryMemberDto;

@SuppressWarnings("unchecked")
public class DisplayLibraryMemberController {

	@FXML TableView<LibraryMemberDto> libraryMemberTable;
	@FXML TextField firstName;
	@FXML TextField lastName;
	@FXML TextField phoneNo;
	@FXML TextField stateName;
	@FXML TextField cityName;
	@FXML TextField zipCodeName;

	@FXML TableColumn state;
	@FXML TableColumn city;
	@FXML TableColumn street;
	@FXML TableColumn zipCode;
	@FXML TableColumn action;

	LibraryMemberDao libraryMember;
	ObservableList<LibraryMemberDto> list;

	@SuppressWarnings("unchecked")
	public DisplayLibraryMemberController() throws Exception{
		libraryMember = new LibraryMemberDao(FilePath.MEMBER_RECORD);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void SearchMembers() throws Exception{

		AddressDto address = new AddressDto("",
											this.cityName.getText().trim(),
											this.stateName.getText().trim(),
											this.zipCodeName.getText().trim());
		LibraryMemberDto filter = new LibraryMemberDto(null,
														this.firstName.getText().trim(),
														this.lastName.getText().trim(),
														address,
														this.phoneNo.getText().trim());

		List<LibraryMemberDto> members = null;
		members = libraryMember.getMemberList(filter);

		list = FXCollections.observableArrayList();
		for (LibraryMemberDto libraryMemberDto : members) {
			list.add(libraryMemberDto);
		}

		this.state.setCellValueFactory(new Callback<CellDataFeatures<LibraryMemberDto, String>,
                ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<LibraryMemberDto, String> data){
						StringProperty p = new SimpleStringProperty(data.getValue().getAddress().getState());
						return p;
					}
					});
		this.city.setCellValueFactory(new Callback<CellDataFeatures<LibraryMemberDto, String>,
                ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<LibraryMemberDto, String> data){
						StringProperty p = new SimpleStringProperty(data.getValue().getAddress().getCity());
						return p;
					}
					});
		this.street.setCellValueFactory(new Callback<CellDataFeatures<LibraryMemberDto, String>,
                ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<LibraryMemberDto, String> data){
						StringProperty p = new SimpleStringProperty(data.getValue().getAddress().getStreet());
						return p;
					}
					});
		this.zipCode.setCellValueFactory(new Callback<CellDataFeatures<LibraryMemberDto, String>,
                ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<LibraryMemberDto, String> data){
						StringProperty p = new SimpleStringProperty(data.getValue().getAddress().getZipCode());
						return p;
					}
					});

		Callback<TableColumn<LibraryMemberDto, String>, TableCell<LibraryMemberDto, String>> cellFactory = //
                new Callback<TableColumn<LibraryMemberDto, String>, TableCell<LibraryMemberDto, String>>()
                {
                    @Override
                    public TableCell call( final TableColumn<LibraryMemberDto, String> param )
                    {
                        final TableCell<LibraryMemberDto, String> cell = new TableCell<LibraryMemberDto, String>()
                        {

                            final Button btn = new Button( "Edit it" );

                            @Override
                            public void updateItem( String item, boolean empty )
                            {
                                super.updateItem( item, empty );
                                if ( empty )
                                {
                                    setGraphic( null );
                                    setText( null );
                                }
                                else
                                {
                                    btn.setOnAction( ( ActionEvent event ) ->
                                            {
                                                LibraryMemberDto member = getTableView().getItems().get( getIndex() );
                                                try {
													switchToEditMode(member);
												} catch (Exception e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
                                    } );
                                    setGraphic( btn );
                                    setText( null );
                                }
                            }
                        };
                        return cell;
                    }
                };
        this.action.setCellFactory( cellFactory );
		this.libraryMemberTable.setItems(list);
	}

	private void switchToEditMode(LibraryMemberDto member) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/AddLibrarymember.fxml"));

		Parent root1 = null;
		root1 = (Parent)fxmlLoader.load();

		LibraryMemberController addController = fxmlLoader.<LibraryMemberController>getController();
		addController.setEditMode(member, this);

        Stage stage = new Stage();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Edit Library Member");
        stage.setScene(new Scene(root1));
        stage.show();
	}

	public void clearResults(){
		this.firstName.clear();
		this.lastName.clear();
		this.phoneNo.clear();
		this.stateName.clear();
		this.cityName.clear();
		this.zipCodeName.clear();

		if(list != null)
			list.clear();
	}
}
