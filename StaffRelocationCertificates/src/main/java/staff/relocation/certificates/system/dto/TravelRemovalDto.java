package staff.relocation.certificates.system.dto;


public class TravelRemovalDto {
	private String removal_duration;
	private boolean from_work_place;
	private String removalHour;
	public TravelRemovalDto(String removal_duration, boolean from_work_place, String removalHour) {
		super();
		this.removal_duration = removal_duration;
		this.from_work_place = from_work_place;
		this.removalHour = removalHour;
	}
	public TravelRemovalDto() {
		super();
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
	public void setRemovalHour(String removalHour) {
		this.removalHour = removalHour;
	}
	@Override
	public String toString() {
		return "TravelRemovalDto [removal_duration=" + removal_duration + ", from_work_place=" + from_work_place
				+ ", removal_hour=" + removalHour + "]";
	}
	
}
