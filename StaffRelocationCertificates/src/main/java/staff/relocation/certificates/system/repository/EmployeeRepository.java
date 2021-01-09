package staff.relocation.certificates.system.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import staff.relocation.certificates.system.model.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	Employee findByUsername(String username);

	Employee findByEmail(String email);
}