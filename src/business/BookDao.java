package business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import dataaccess.DataReader;
import dataaccess.storage.BookCopyDto;
import dataaccess.storage.BookDto;

public class BookDao {

	private DataReader reader;

	public BookDao(String path) {
		this.reader = new DataReader(path);
	}

	//check if book with given isbn is in library
	public boolean isBookAvailableInLibrary(String bookIsbn){
		List<BookDto> bookList;
		try {
			bookList = (List<BookDto>)reader.read();
			if(bookList == null){
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		Iterator<BookDto> itr = bookList.iterator();
		boolean caseHit = false;;
		
		while(itr.hasNext()){
			BookDto book = itr.next();
			if(book.getIsbn().equals(bookIsbn)){
				caseHit = true;
				break;
			}
			
		}
		return caseHit;
	}

	public BookDto getBook(String bookIsbn){
		List<BookDto> bookList;
		try {
			bookList = (List<BookDto>)reader.read();
			if(bookList == null){
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		Iterator<BookDto> itr = bookList.iterator();
		BookDto caseHit = null;
		
		while(itr.hasNext()){
			BookDto book = itr.next();
			if(book.getIsbn().equals(bookIsbn)){
				caseHit = book;;
				break;
			}
			
		}
		return caseHit;
	}
	
	public List<BookCopyDto> getListOfCopiesAvailable(String bookIsbn) throws Exception{
		List<BookDto> bookList = (List<BookDto>)reader.read();
		Iterator<BookDto> itr = bookList.iterator();
		BookDto bookRequested = null;
		
		while(itr.hasNext()){
			BookDto book = itr.next();
			if(book.getIsbn().equals(bookIsbn)){
				bookRequested = book;
				break;
			}
			
		}
		
		if(bookRequested!=null){
			Iterator<BookCopyDto> itrBookCopy = bookRequested.getBookCopies().iterator();
			List<BookCopyDto> bookCopyList = new ArrayList<>();
			
			while (itrBookCopy.hasNext()) {
				BookCopyDto bookCopyDto = (BookCopyDto) itrBookCopy.next();
				
				if(bookCopyDto.isAvailable()){
					bookCopyList.add(bookCopyDto);
//					System.out.println("copy available::"+bookCopyDto.getCopyNumber());
				}
				
			}
			
			return bookCopyList;
			
		}else{
			return new ArrayList<BookCopyDto>();
		}
		
	}
	
	//in book records. log that following bookcopy is unavailable
	public void logCheckoutOfCopy(String bookIsbn, UUID copyNumber){
		try {
			List<BookDto> bookList = getBookList();
			Iterator<BookDto> itrBook = bookList.iterator();
			if(itrBook.hasNext()){
				
				while(itrBook.hasNext()){
					BookDto book = itrBook.next();
					if(book.getIsbn().equals(bookIsbn)){
						List<BookCopyDto> bookCopies = book.getBookCopies();
						Iterator<BookCopyDto> itrBookCopy = bookCopies.iterator();
						
						if(itrBookCopy.hasNext()){
							while(itrBookCopy.hasNext()){
								BookCopyDto bookCopy = itrBookCopy.next();
								if(bookCopy.getCopyNumber().equals(copyNumber)){
									bookCopy.setAvailable(false);
									break;
								}
							}
						}else{
							System.out.println("NO book copy for the book in library");
						}
						break;
						
					}
				}
			}else{
				System.out.println("NO books in library");
			}
			
			addBook(bookList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void addBook(List<BookDto> book){
		reader.write(book);
		//System.out.println(book.get(0));
	}

	@SuppressWarnings("unchecked")
	public List<BookDto> getBookList() throws Exception{
		return (List<BookDto>)reader.read();
	}

	public BookDto searchByTitle(String title){
		List<BookDto> allbook= null;
		BookDto bookdto=null;
		try {
			allbook = (List<BookDto>)reader.read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (BookDto bookDto : allbook) {
			if(bookDto.getTitle()==title)
				bookdto=bookDto;
		}
		return bookdto;
	}
}
