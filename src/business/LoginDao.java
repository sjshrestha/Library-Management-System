package business;

import java.util.ArrayList;
import java.util.List;

import business.LoginDao;
import dataaccess.storage.LoginUserDto;
import dataaccess.storage.RoleDto;

public class LoginDao {
	List<LoginUserDto> users;

	public LoginDao(){
		users = new ArrayList<LoginUserDto>();
		users.add(new LoginUserDto("both", "both", RoleDto.Both));
		users.add(new LoginUserDto("admin", "admin", RoleDto.Administrator));
		users.add(new LoginUserDto("librn", "librn", RoleDto.Librarian));
	}

	public LoginUserDto validateUser(String username, String password){
		for (LoginUserDto user : users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)){
				return user;
			}
		}
		return null;
	}
}
