package dataaccess.storage;

import java.io.Serializable;
import java.time.LocalDate;

public class FineDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6965731774760341189L;
	private CheckoutEntryDto checkoutEntryDto;
	private double fineAmount;
	private LocalDate datePaid;
	
	public CheckoutEntryDto getCheckoutEntryDto() {
		return checkoutEntryDto;
	}
	public void setCheckoutEntryDto(CheckoutEntryDto checkoutEntryDto) {
		this.checkoutEntryDto = checkoutEntryDto;
	}
	public double getFineAmount() {
		return fineAmount;
	}
	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}
	public LocalDate getDatePaid() {
		return datePaid;
	}
	public void setDatePaid(LocalDate datePaid) {
		this.datePaid = datePaid;
	}
	
	
}
