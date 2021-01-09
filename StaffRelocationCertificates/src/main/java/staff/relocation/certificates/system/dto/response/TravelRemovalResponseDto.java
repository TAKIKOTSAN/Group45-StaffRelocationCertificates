package staff.relocation.certificates.system.dto.response;

public class TravelRemovalResponseDto {
	private String fullname;
	private String phone;
	private String address;
	private String workplace;
	private String removal_duration;
	private boolean from_work_place;
	private String removalHour;

	public TravelRemovalResponseDto(String fullname, String phone, String address, String workplace,
			String removal_duration, boolean from_work_place, String removalHour) {
		super();
		this.fullname = fullname;
		this.phone = phone;
		this.address = address;
		this.workplace = workplace;
		this.removal_duration = removal_duration;
		this.from_work_place = from_work_place;
		this.removalHour = removalHour;
	}

	public TravelRemovalResponseDto() {
		super();
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

	public String getRemoval_duration() {
		return removal_duration;
	}

	public void setRemoval_duration(String removal_duration) {
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

	public void setRemovalHour(String removal_hour) {
		this.removalHour = removal_hour;
	}

}
