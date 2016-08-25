package dataaccess.storage;

import java.io.Serializable;
import java.util.List;

public class BookDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5767889313958934829L;
	private String title;
	private String isbn;
	private List<AuthorDto> authors;
	private List<BookCopyDto> bookCopies;
	private String number;
	private String copyNumber;
	private int daysAllowedForCheckout;

	public BookDto(List<AuthorDto> authors, String title, String ISBN, String copyNumber,int daysAllowedForCheckout){
		this.title = title;
		this.isbn = ISBN;
		this.authors = authors;
		this.copyNumber = copyNumber;
		this.daysAllowedForCheckout = daysAllowedForCheckout;
	}

	public BookDto(String title, String isbn, List<AuthorDto> authors, List<BookCopyDto> bookCopies){
		this.title = title;
		this.isbn = isbn;
		this.authors = authors;
		this.bookCopies = bookCopies;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<AuthorDto> getAuthors() {
		return authors;
	}

	public void setAuthors(List<AuthorDto> authors) {
		this.authors = authors;
	}

	public List<BookCopyDto> getBookCopies() {
		return bookCopies;
	}

	public void setBookCopies(List<BookCopyDto> bookCopies) {
		this.bookCopies = bookCopies;
	}

	public int getDaysAllowedForCheckout() {
		return daysAllowedForCheckout;
	}

	public void setDaysAllowedForCheckout(int daysAllowedForCheckout) {
		this.daysAllowedForCheckout = daysAllowedForCheckout;
	}
	
	public String getCopyNumber() {
		return copyNumber;
	}

	public void setCopyNumber(String copyNumber) {
		this.copyNumber = copyNumber;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}
