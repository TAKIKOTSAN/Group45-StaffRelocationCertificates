package staff.relocation.certificates.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "travelRemovals")
public class TravelRemoval {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean approved;
	@Enumerated(EnumType.STRING)
	private RemovalDuration removal_duration;
	private boolean from_work_place;
	private String removalHour;
	@OneToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "employee_id", referencedColumnName = "user")
	@JsonIgnore
	private Employee employee;

	public TravelRemoval(boolean approved, RemovalDuration removal_duration, boolean from_work_place,
			String removalHour, Employee employee) {
		super();
		this.approved = approved;
		this.removal_duration = removal_duration;
		this.from_work_place = from_work_place;
		this.removalHour = removalHour;
		this.employee = employee;
	}

	public TravelRemoval() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public RemovalDuration getRemoval_duration() {
		return removal_duration;
	}

	public void setRemoval_duration(RemovalDuration removal_duration) {
		this.removal_duration = removal_duration;
	}

	public boolean isFrom_work_place() {
		return from_work_place;
	}

	public void setFrom_work_place(boolean from_work_place) {
		this.from_work_place = from_work_place;
	}

	public String getRemovalHour() {
		return removalHour;
	}

	public void setRemovalHour(String removalHour) {
		this.removalHour = removalHour;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "TravelRemoval [id=" + id + ", approved=" + approved + ", removal_duration=" + removal_duration
				+ ", from_work_place=" + from_work_place + ", removal_hour=" + removalHour + ", employee=" + employee
				+ "]";
	}

}
