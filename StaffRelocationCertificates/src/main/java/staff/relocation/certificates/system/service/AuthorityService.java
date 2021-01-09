package staff.relocation.certificates.system.service;

import java.util.Collection;
import java.util.List;

import staff.relocation.certificates.system.dto.RoleDto;
import staff.relocation.certificates.system.model.Authority;
import staff.relocation.certificates.system.model.RoleName;

public interface AuthorityService {
	Authority save(RoleDto role);

    Boolean delete(int id);

    Authority update(int id,RoleDto role);

    Authority findById(int id);

    Collection<Authority> findAll();
    Authority findByName(RoleName name);
}
