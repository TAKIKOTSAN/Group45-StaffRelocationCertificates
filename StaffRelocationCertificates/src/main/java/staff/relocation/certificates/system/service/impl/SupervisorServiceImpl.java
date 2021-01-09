package staff.relocation.certificates.system.service.impl;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import staff.relocation.certificates.system.dto.EmployeeDto;
import staff.relocation.certificates.system.dto.response.EmployeeResponseDto;
import staff.relocation.certificates.system.model.Employee;
import staff.relocation.certificates.system.model.Supervisor;
import staff.relocation.certificates.system.repository.SupervisorRepository;
import staff.relocation.certificates.system.service.SupervisorService;


@Service
@Transactional
public class SupervisorServiceImpl implements SupervisorService {
	@Autowired
    private SupervisorRepository supervisorRepository;
    @Override
    public Supervisor save(Supervisor supervisor) {
        return supervisorRepository.save(supervisor);
    }

    @Override
    public Boolean delete(int id) {
        if (supervisorRepository.existsById(id)) {
            supervisorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Supervisor update(Supervisor supervisor) {
        return supervisorRepository.save(supervisor);
    }

    @Override
    public Supervisor findById(int id) {
        return supervisorRepository.findById(id).get();
    }
    @Override
    public Supervisor findByUserName(String Username) {
        return supervisorRepository.findByUsername(Username);
    }
    @Override
    public Supervisor findByEmail(String email) {
        return supervisorRepository.findByEmail(email);
    }

    @Override
    public Collection<Supervisor> findAll() {
        Iterable<Supervisor> itr = supervisorRepository.findAll();
        return (Collection<Supervisor>) itr;
    }

	@Override
	public EmployeeResponseDto findMyEmployee(int id) {
		Supervisor supervisor=supervisorRepository.findById(id).get();
		Employee employee =supervisor.getEmployee();
		EmployeeResponseDto employeeDto=new EmployeeResponseDto();
		employeeDto.setId(employee.getId());
		employeeDto.setAddress(employee.getAddress());
		employeeDto.setUsername(employee.getUsername());
		employeeDto.setFullname(employee.getFullname());
		employeeDto.setPhone(employee.getPhone());
		employeeDto.setWorkplace(employee.getWorkplace());
		return employeeDto;
	}
}
