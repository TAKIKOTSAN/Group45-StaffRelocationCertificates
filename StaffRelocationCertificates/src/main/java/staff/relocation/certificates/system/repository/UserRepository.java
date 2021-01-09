package staff.relocation.certificates.system.repository;

import org.springframework.data.repository.CrudRepository;

import staff.relocation.certificates.system.model.User;



public interface UserRepository extends CrudRepository<User, Integer> {

	User findByUsername(String username);
	User findByEmail(String email);


}

