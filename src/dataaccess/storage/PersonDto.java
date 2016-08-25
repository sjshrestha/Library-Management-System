package dataaccess.storage;

import java.io.Serializable;

public class PersonDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5319045658801705059L;
	String firstName;
	String lastName;
	AddressDto address;
	String phoneNo;

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	PersonDto(String firstName, String lastName, AddressDto address, String phoneNo){
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNo = phoneNo;
	}
}
