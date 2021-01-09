package staff.relocation.certificates.system.model;

public enum RoleName {
	ROLE_ADMIN,
	ROLE_STAFF,
	ROLE_SUPERVISOR,
	ROLE_EMPLOYEE,
	ROLE_DIRECTOR;
	public static RoleName getByRoleName(String rolename) {
        for (RoleName name : RoleName.values()) {
            if (name.name().equals(rolename)) {
                return name;
            }
        }
        return null;
    }
}
