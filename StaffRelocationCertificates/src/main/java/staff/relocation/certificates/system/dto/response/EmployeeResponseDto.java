package staff.relocation.certificates.system.dto.response;

public class EmployeeResponseDto {
	int id;
	private String username;
	private String fullname;
	private String phone;
	private String address;
	private String workplace;
	private String supervisor;

	public EmployeeResponseDto(int id,String username, String supervisor, String password, String fullname, String phone,
			String address, String workplace) {
		super();
		this.id=id;
		this.username = username;
		this.fullname = fullname;
		this.phone = phone;
		this.address = address;
		this.workplace = workplace;
		this.supervisor=supervisor;
	}
	
	public EmployeeResponseDto() {
		super();
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
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
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWorkplace() {
		return workplace;
	}
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}
	
	
}
