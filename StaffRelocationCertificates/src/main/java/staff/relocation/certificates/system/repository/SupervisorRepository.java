package staff.relocation.certificates.system.repository;

import org.springframework.data.repository.CrudRepository;

import staff.relocation.certificates.system.model.Supervisor;


public interface SupervisorRepository extends CrudRepository<Supervisor, Integer> {

	Supervisor findByUsername(String username);

	Supervisor findByEmail(String email);
}