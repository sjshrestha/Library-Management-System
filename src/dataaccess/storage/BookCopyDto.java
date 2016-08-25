package dataaccess.storage;

import java.io.Serializable;
import java.util.UUID;

public class BookCopyDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1506843096203118329L;
	private UUID copyNumber;
	private boolean isAvailable;
	private LibraryMemberDto checkedBy;
	private BookDto bookDto;

	public BookCopyDto(UUID  copyNumber, BookDto book) {
		this.copyNumber = copyNumber;
		this.isAvailable = true;
		this.bookDto = book;

	}

	public UUID getCopyNumber() {
		return copyNumber;
	}

	public void setCopyNumber(UUID copyNumber) {
		this.copyNumber = copyNumber;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public LibraryMemberDto getCheckedBy() {
		return checkedBy;
	}

	public void setCheckedBy(LibraryMemberDto checkedBy) {
		this.checkedBy = checkedBy;
	}

	public BookDto getBookDto() {
		return bookDto;
	}

	public void setBookDto(BookDto bookDto) {
		this.bookDto = bookDto;
	}




}
