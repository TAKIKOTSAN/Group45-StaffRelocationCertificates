package staff.relocation.certificates.system.model;

public enum RemovalDuration {
	DAILY,
	WEEKLY,
	EXTRAORDINARY;
	public static RemovalDuration getByRemovalDuration(String duration) {
        for (RemovalDuration type : RemovalDuration.values()) {
            if (type.name().equals(duration)) {
                return type;
            }
        }
        return null;
    }
	
}
