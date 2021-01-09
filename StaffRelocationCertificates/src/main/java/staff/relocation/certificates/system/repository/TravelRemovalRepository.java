package staff.relocation.certificates.system.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import staff.relocation.certificates.system.model.TravelRemoval;

public interface TravelRemovalRepository extends CrudRepository<TravelRemoval, Integer> {
	Collection<TravelRemoval> findByApproved(boolean approved);
	TravelRemoval findByEmployeeId(int id);
	Collection<TravelRemoval> findByRemovalHour(String removalHour);
}
