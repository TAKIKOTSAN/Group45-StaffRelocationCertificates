package staff.relocation.certificates.system.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import staff.relocation.certificates.system.dto.EmployeeDto;
import staff.relocation.certificates.system.dto.response.EmployeeResponseDto;
import staff.relocation.certificates.system.dto.response.TravelRemovalResponseDto;
import staff.relocation.certificates.system.model.Employee;
import staff.relocation.certificates.system.model.Supervisor;
import staff.relocation.certificates.system.repository.EmployeeRepository;
import staff.relocation.certificates.system.repository.SupervisorRepository;
import staff.relocation.certificates.system.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private SupervisorRepository supervisorRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee save(int id, Employee employee) {
		employee.setSupervisor(supervisorRepository.findById(id).get());
		return employeeRepository.save(employee);

	}

	@Override
	public Boolean delete(int id) {
		if (employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public EmployeeResponseDto update(int id, EmployeeDto employeeDto) {
		Supervisor supervisor = supervisorRepository.findByUsername(employeeDto.getSupervisor());
		Employee employee = employeeRepository.findById(id).get();
		employee.setAddress(employeeDto.getAddress());
		employee.setPhone(employeeDto.getPhone());
		employee.setWorkplace(employeeDto.getWorkplace());
		employee.setSupervisor(supervisor);
		employeeRepository.save(employee);
		EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
		employeeResponseDto.setAddress(employee.getAddress());
		employeeResponseDto.setFullname(employee.getFullname());
		employeeResponseDto.setId(employee.getId());
		employeeResponseDto.setPhone(employee.getPhone());
		employeeResponseDto.setSupervisor(employee.getSupervisor().getUsername());
		employeeResponseDto.setUsername(employee.getUsername());
		employeeResponseDto.setWorkplace(employee.getWorkplace());
		return employeeResponseDto;
	}

	@Override
	public Employee findById(int id) {
		return employeeRepository.findById(id).get();

	}

	@Override
	public Employee findByUserName(String Username) {
		return employeeRepository.findByUsername(Username);

	}

	@Override
	public Employee findByEmail(String email) {
		return employeeRepository.findByEmail(email);

	}

	@Override
	public Collection<EmployeeResponseDto> findAll() {
		Iterable<Employee> itr = employeeRepository.findAll();
		Collection<EmployeeResponseDto> employees = new ArrayList<>();
		for (Employee employee : itr) {
			// System.out.println(employee);
			EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
			employeeResponseDto.setAddress(employee.getAddress());
			employeeResponseDto.setFullname(employee.getFullname());
			employeeResponseDto.setId(employee.getId());
			employeeResponseDto.setPhone(employee.getPhone());
			if (employee.getSupervisor() == null) {
				employeeResponseDto.setSupervisor(null);
			} else {
				employeeResponseDto.setSupervisor(employee.getSupervisor().getUsername());
			}
			// System.out.println(employee.getSupervisor());
			employeeResponseDto.setUsername(employee.getUsername());
			employeeResponseDto.setWorkplace(employee.getWorkplace());
			employees.add(employeeResponseDto);
		}
		return employees;
	}

}
