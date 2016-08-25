package dataaccess.storage;

import java.io.Serializable;

public class LibraryMemberDto implements Serializable {
	private static final long serialVersionUID = -8860640491534642878L;
	private CheckoutRecordDto checkoutRecordDto;
	String memberId;	
	String firstName;
	String lastName;
	AddressDto address;
	String phoneNo;
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
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

	public LibraryMemberDto(String memberId, String firstName, String lastName, AddressDto address, String phoneNo) {
		this.memberId = memberId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNo = phoneNo;
	}

	@Override
	public boolean equals(Object obj) {
		LibraryMemberDto member = (LibraryMemberDto)obj;
		String ida = this.memberId.toString();
		String idb = member.memberId.toString();
		if(ida.equals(idb))
			return true;
		else
			return false;
	}

	public CheckoutRecordDto getCheckoutRecordDto() {
		return checkoutRecordDto;
	}

	public void setCheckoutRecordDto(CheckoutRecordDto checkoutRecordDto) {
		this.checkoutRecordDto = checkoutRecordDto;
	}


	
	
}
