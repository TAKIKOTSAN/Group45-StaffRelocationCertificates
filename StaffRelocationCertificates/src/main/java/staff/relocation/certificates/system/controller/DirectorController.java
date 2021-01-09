package staff.relocation.certificates.system.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import staff.relocation.certificates.system.dto.EmployeeDto;
import staff.relocation.certificates.system.dto.response.EmployeeResponseDto;
import staff.relocation.certificates.system.dto.response.TravelRemovalResponseDto;
import staff.relocation.certificates.system.exception.CustomException;
import staff.relocation.certificates.system.model.Employee;
import staff.relocation.certificates.system.model.Supervisor;
import staff.relocation.certificates.system.model.User;
import staff.relocation.certificates.system.service.EmployeeService;
import staff.relocation.certificates.system.service.SupervisorService;
import staff.relocation.certificates.system.service.TravelRemovalService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/director")
public class DirectorController {
	@Autowired
	private TravelRemovalService trService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private SupervisorService supervisorService;

	@GetMapping("/travelRemovals/{date}")
	@ResponseBody
	public Collection<TravelRemovalResponseDto> TravelRemovalsByDate(@PathVariable("date") String removalHour) {
		System.out.println(removalHour);
		if (trService.findByRemovalHour(removalHour).isEmpty()) {
			throw new CustomException("There arent any travel removal for this date !", HttpStatus.UNPROCESSABLE_ENTITY);

		}
		return trService.findByRemovalHour(removalHour);
	}

	@GetMapping("/supervisors")
	@ResponseBody
	public Collection<Supervisor> Supervisors() {

		return supervisorService.findAll();
	}

	@GetMapping("/employees")
	@ResponseBody
	public Collection<EmployeeResponseDto> Employees() {
		return employeeService.findAll();
	}

	@PutMapping("/employees/{id}/AddSupervisor")
	@ResponseBody
	public EmployeeResponseDto EditEmployee(@PathVariable("id") int id, @RequestBody EmployeeDto employeeDto) {
		return employeeService.update(id, employeeDto);
	}
}
