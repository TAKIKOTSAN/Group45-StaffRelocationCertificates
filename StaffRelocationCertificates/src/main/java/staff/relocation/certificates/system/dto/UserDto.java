package staff.relocation.certificates.system.dto;


public class UserDto {
	private String username;
	private String email;
	private String password;
	private String fullname;
	private String role;
	public UserDto(String username, String email, String password, String fullname, String role) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.role = role;
	}
	public UserDto() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserDto [username=" + username + ", email=" + email + ", password=" + password + ", fullname="
				+ fullname + ", role=" + role + "]";
	}
	
	
}
