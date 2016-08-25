package dataaccess.storage;

public class LoginUserDto {
	String username;
	String password;
	RoleDto role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}

	public LoginUserDto(String username, String password, RoleDto role){
		this.username = username;
		this.password = password;
		this.role = role;
	}
}
