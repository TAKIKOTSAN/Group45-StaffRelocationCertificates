package staff.relocation.certificates.system.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import staff.relocation.certificates.system.model.Authority;
import staff.relocation.certificates.system.model.RoleName;

public interface AuthorityRepository extends CrudRepository<Authority, Integer> {
    Authority findByName(RoleName name);
}
