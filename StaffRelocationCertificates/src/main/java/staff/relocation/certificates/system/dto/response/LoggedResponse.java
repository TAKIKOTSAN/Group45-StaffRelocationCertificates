package staff.relocation.certificates.system.dto.response;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import staff.relocation.certificates.system.model.Authority;

public class LoggedResponse {
	private String token;
	private String type = "Bearer";
	int id;
	private String username;
	private String email;
	private String fullName;
	private String role;
	public LoggedResponse(String accesstoken, int id, String username, String email, String fullName,
			String role) {
		super();
		this.token = accesstoken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.fullName = fullName;
		this.role = role;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
