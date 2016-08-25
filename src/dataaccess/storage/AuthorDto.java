package dataaccess.storage;

import java.io.Serializable;

public class AuthorDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1338168203016142582L;
	private String firstName;
	private String lastName;
	private String shortBio;
	private AddressDto address;
	private String phoneNumber;

	public AuthorDto(String firstName,
	 String lastName,
	 String shortBio,
	 AddressDto address,
	 String phoneNumber) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.shortBio = shortBio;
		this.address = address;
		this.phoneNumber = phoneNumber;

	}

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

	public String getShortBio() {
		return shortBio;
	}

	public void setShortBio(String shortBio) {
		this.shortBio = shortBio;
	}

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
