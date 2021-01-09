package staff.relocation.certificates.system.service;

import java.util.Collection;

import staff.relocation.certificates.system.dto.EmployeeDto;
import staff.relocation.certificates.system.dto.response.EmployeeResponseDto;
import staff.relocation.certificates.system.model.Employee;
import staff.relocation.certificates.system.model.TravelRemoval;

public interface EmployeeService {
	Employee save(int d,Employee employee);

	Boolean delete(int id);

	EmployeeResponseDto update(int id, EmployeeDto employeeDto);

	Employee findById(int id);

	Employee findByUserName(String Username);

	Employee findByEmail(String email);

	Collection<EmployeeResponseDto> findAll();


}
