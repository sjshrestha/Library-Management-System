package business;
import java.util.function.Predicate;

import dataaccess.storage.LibraryMemberDto;

public class LambdaLibrary {
	public static Predicate<LibraryMemberDto> getMemberPredicate(LibraryMemberDto member){
		Predicate<LibraryMemberDto> bySuppliedValues = (x)
				-> (member.getFirstName().isEmpty() ? true: x.getFirstName().equalsIgnoreCase(member.getFirstName()))
				&& (member.getLastName().isEmpty() ? true: x.getLastName().equalsIgnoreCase(member.getLastName()))
				&& (member.getPhoneNo().isEmpty() ? true: x.getPhoneNo().equalsIgnoreCase(member.getPhoneNo()))
				&& (member.getAddress().getState().isEmpty() ? true:x.getAddress().getState().equalsIgnoreCase(member.getAddress().getState()))
				&& (member.getAddress().getCity().isEmpty() ? true:x.getAddress().getCity().equalsIgnoreCase(member.getAddress().getCity()))
				&& (member.getAddress().getZipCode().isEmpty() ? true:x.getAddress().getZipCode().equalsIgnoreCase(member.getAddress().getZipCode()));

		return bySuppliedValues;
	}
}
