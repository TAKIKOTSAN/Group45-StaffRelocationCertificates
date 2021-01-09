package staff.relocation.certificates.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import staff.relocation.certificates.system.dto.ApprovedDto;
import staff.relocation.certificates.system.dto.response.EmployeeResponseDto;
import staff.relocation.certificates.system.exception.CustomException;
import staff.relocation.certificates.system.model.Authority;
import staff.relocation.certificates.system.model.Employee;
import staff.relocation.certificates.system.model.TravelRemoval;
import staff.relocation.certificates.system.model.User;
import staff.relocation.certificates.system.service.EmployeeService;
import staff.relocation.certificates.system.service.SupervisorService;
import staff.relocation.certificates.system.service.TravelRemovalService;
import staff.relocation.certificates.system.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/supervisor")
public class SupervisorController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private TravelRemovalService trService;
	@Autowired
	private SupervisorService supervisorService;
	@Autowired
    private UserService userService;
	@GetMapping("/{id}/employee")
	@ResponseBody
	public EmployeeResponseDto MyEmployee(@PathVariable("id") int id) {
		return supervisorService.findMyEmployee(id);
	}

	@GetMapping("/{id}/employee/{id2}/travelRemoval")
	@ResponseBody
	public TravelRemoval EmployyesTravelRemoval(@PathVariable("id2") int id) {
		System.out.println("aaa");
		if (trService.findByEmployeeId(id) == null) {
			throw new CustomException("Your employee hasnt travel removal", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return trService.findByEmployeeId(id);
	}

	@PutMapping("/{id}/employee/{id2}/travelRemoval/approve")
	@ResponseBody
	public TravelRemoval ApproveTravelRemoval(@PathVariable("id2") int id, @RequestBody ApprovedDto approvedDto) {
		return trService.update(id, approvedDto);
	}
}
