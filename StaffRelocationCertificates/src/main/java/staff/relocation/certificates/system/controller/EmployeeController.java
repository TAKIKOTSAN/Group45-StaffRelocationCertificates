package staff.relocation.certificates.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import staff.relocation.certificates.system.dto.RoleDto;
import staff.relocation.certificates.system.dto.TravelRemovalDto;
import staff.relocation.certificates.system.exception.CustomException;
import staff.relocation.certificates.system.model.Authority;
import staff.relocation.certificates.system.model.TravelRemoval;
import staff.relocation.certificates.system.service.EmployeeService;
import staff.relocation.certificates.system.service.TravelRemovalService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
    private EmployeeService employeeService;
	@Autowired
    private TravelRemovalService trService;
	
	@PostMapping("/{id}/travelRemoval/create")
	@ResponseBody
	public  ResponseEntity<TravelRemoval> NewTravelRemoval(@PathVariable("id") int id,@RequestBody TravelRemovalDto trDto) {
		System.out.println(trDto);
		return new ResponseEntity<TravelRemoval>(trService.save(id,trDto), HttpStatus.CREATED);
	}
	@GetMapping("/{id}/travelRemoval")
	@ResponseBody
	public  TravelRemoval MyTravelRemoval(@PathVariable("id") int id) {
		if(trService.findByEmployeeId(id)==null) {
			throw new CustomException("You havent travel removal", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return trService.findByEmployeeId(id);
	}
}
