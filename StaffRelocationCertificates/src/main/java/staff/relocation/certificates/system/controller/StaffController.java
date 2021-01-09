package staff.relocation.certificates.system.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import staff.relocation.certificates.system.dto.response.TravelRemovalResponseDto;
import staff.relocation.certificates.system.model.TravelRemoval;
import staff.relocation.certificates.system.service.TravelRemovalService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/staff")
public class StaffController {
	@Autowired
    private TravelRemovalService trService;
	@GetMapping("/travelRemovals/approved")
	@ResponseBody
	public  Collection<TravelRemovalResponseDto> MyTravelRemoval() {
		return trService.findApprovedTravelRemovals();
	}
}
