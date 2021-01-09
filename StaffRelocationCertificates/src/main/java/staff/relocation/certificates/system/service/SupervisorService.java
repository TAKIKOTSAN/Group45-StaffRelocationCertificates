package staff.relocation.certificates.system.service;

import java.util.Collection;

import staff.relocation.certificates.system.dto.EmployeeDto;
import staff.relocation.certificates.system.dto.response.EmployeeResponseDto;
import staff.relocation.certificates.system.model.Employee;
import staff.relocation.certificates.system.model.Supervisor;


public interface SupervisorService {
	Supervisor save(Supervisor supervisor);

	Boolean delete(int id);

	Supervisor update(Supervisor supervisor);

	Supervisor findById(int id);

	Supervisor findByUserName(String Username);

	Supervisor findByEmail(String email);

	Collection<Supervisor> findAll();
	EmployeeResponseDto findMyEmployee(int id);
}
