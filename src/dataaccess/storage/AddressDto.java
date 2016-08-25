package dataaccess.storage;

import java.io.Serializable;

public class AddressDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6725701805573848217L;
	String street;
	String city;
	String state;
	String zipCode;

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public AddressDto(String street, String city, String state, String zipCode){
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

}
