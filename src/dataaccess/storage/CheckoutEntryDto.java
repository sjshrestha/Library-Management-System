package dataaccess.storage;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckoutEntryDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4967017097435683077L;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private LocalDate returnedDate;
	private BookCopyDto checkedBookCopy;
	
	public CheckoutEntryDto(BookCopyDto checkedBookCopy){
		this.checkedBookCopy = checkedBookCopy;
		this.checkoutDate = LocalDate.now();
		
		this.dueDate = this.checkoutDate.plusDays(checkedBookCopy.getBookDto().getDaysAllowedForCheckout());
		
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(LocalDate returnedDate) {
		this.returnedDate = returnedDate;
	}

	public BookCopyDto getCheckedBookCopy() {
		return checkedBookCopy;
	}

	public void setCheckedBookCopy(BookCopyDto checkedBookCopy) {
		this.checkedBookCopy = checkedBookCopy;
	}
	
	
	
	
}
