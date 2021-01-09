package staff.relocation.certificates.system.dto;

import javax.persistence.Column;

public class EmployeeDto {
	private String supervisor;
	private String phone;
	private String address;
	private String workplace;
	
	public EmployeeDto(String supervisor, String phone, String address, String workplace) {
		super();
		this.supervisor = supervisor;
		this.phone = phone;
		this.address = address;
		this.workplace = workplace;
	}
	public EmployeeDto() {
		super();
	}
	
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
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
	@Override
	public String toString() {
		return "EmployeeDto [supervisor=" + supervisor + ", phone=" + phone + ", address=" + address + ", workplace="
				+ workplace + "]";
	}
	
	
}
