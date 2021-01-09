package staff.relocation.certificates.system.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "supervisors")
@PrimaryKeyJoinColumn(name = "user")
public class Supervisor extends User {
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "supervisor")
    @JsonIgnore
    private Employee employee;

	public Supervisor(String username, String email, String password, String fullName, Authority authority) {
		super(username, email, password, fullName, authority);
		// TODO Auto-generated constructor stub
	}

	public Supervisor(Employee employee) {
		super();
		this.employee = employee;
	}

	public Supervisor() {
		super();
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Supervisor [employee=" + employee + "]";
	}
	
}
