package staff.relocation.certificates.system.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "employees")
@PrimaryKeyJoinColumn(name = "user")
public class Employee extends User  {
	@Size(max = 10, min = 10, message = "Mobile number should be of 10 digits")
    @Pattern(regexp = "[0-9]+", message = "Mobile number is invalid!!")	
	private String phone;
	@Column(nullable = true)
	private String address;
	@Column(nullable = true)
	private String workplace;
	@OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "supervisor_id", referencedColumnName = "user")
	@JsonIgnore
	private Supervisor supervisor;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "employee")
	@JsonIgnore
    private TravelRemoval travelRemoval;
	public Employee(
			String phone,
			String address, String workplace, Supervisor supervisor, TravelRemoval travelRemoval) {
		super();
		this.phone = phone;
		this.address = address;
		this.workplace = workplace;
		this.supervisor = supervisor;
		this.travelRemoval = travelRemoval;
	}
	

	


	public Employee(String username, String email, String password, String fullName, Authority authority) {
		super(username, email, password, fullName, authority);
		// TODO Auto-generated constructor stub
	}





	public Employee() {
		super();
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
	public Supervisor getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}
	public TravelRemoval getTravelRemoval() {
		return travelRemoval;
	}
	public void setTravelRemoval(TravelRemoval travelRemoval) {
		this.travelRemoval = travelRemoval;
	}
	@Override
	public String toString() {
		return "Employee [phone=" + phone + ", address=" + address + ", workplace=" + workplace + ", supervisor="
				+ supervisor + ", travelRemoval=" + travelRemoval + "]";
	}
	
}
