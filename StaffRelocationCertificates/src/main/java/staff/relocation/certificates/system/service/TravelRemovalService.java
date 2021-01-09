package staff.relocation.certificates.system.service;

import java.util.Collection;

import staff.relocation.certificates.system.dto.ApprovedDto;
import staff.relocation.certificates.system.dto.TravelRemovalDto;
import staff.relocation.certificates.system.dto.response.TravelRemovalResponseDto;
import staff.relocation.certificates.system.model.Authority;
import staff.relocation.certificates.system.model.TravelRemoval;

public interface TravelRemovalService {
	TravelRemoval save(int id, TravelRemovalDto travelRemovalDto);

	Boolean delete(int id);

	TravelRemoval update(int id, ApprovedDto approvedDto);

	TravelRemoval findById(int id);

	Collection<TravelRemoval> findAll();

	Collection<TravelRemovalResponseDto> findApprovedTravelRemovals();

	TravelRemoval findByEmployeeId(int id);

	Collection<TravelRemovalResponseDto> findByRemovalHour(String removalHour);

}
