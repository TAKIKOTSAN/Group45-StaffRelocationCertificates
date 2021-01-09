package staff.relocation.certificates.system.dto;

public class ApprovedDto {
	private boolean approved;

	public ApprovedDto(boolean approved) {
		super();
		this.approved = approved;
	}

	public ApprovedDto() {
		super();
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
}
