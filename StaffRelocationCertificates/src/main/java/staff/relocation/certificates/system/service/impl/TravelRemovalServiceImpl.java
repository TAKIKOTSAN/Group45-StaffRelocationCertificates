package staff.relocation.certificates.system.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import staff.relocation.certificates.system.dto.ApprovedDto;
import staff.relocation.certificates.system.dto.TravelRemovalDto;
import staff.relocation.certificates.system.dto.response.TravelRemovalResponseDto;
import staff.relocation.certificates.system.model.Employee;
import staff.relocation.certificates.system.model.RemovalDuration;
import staff.relocation.certificates.system.model.TravelRemoval;
import staff.relocation.certificates.system.repository.TravelRemovalRepository;
import staff.relocation.certificates.system.service.EmployeeService;
import staff.relocation.certificates.system.service.TravelRemovalService;

@Service
@Transactional
public class TravelRemovalServiceImpl implements TravelRemovalService {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private TravelRemovalRepository trRepository;

	@Override
	public TravelRemoval save(int id, TravelRemovalDto travelRemovalDto) {
		Employee employee = employeeService.findById(id);
		if (employee.getTravelRemoval() != null) {
			trRepository.deleteById(employee.getTravelRemoval().getId());
		}
		TravelRemoval travelRemoval = new TravelRemoval();
		travelRemoval.setEmployee(employee);
		travelRemoval.setFrom_work_place(travelRemovalDto.isFrom_work_place());
		travelRemoval.setRemovalHour(travelRemovalDto.getRemovalHour());
		travelRemoval.setRemoval_duration(RemovalDuration.getByRemovalDuration(travelRemovalDto.getRemoval_duration()));
		return trRepository.save(travelRemoval);
	}

	@Override
	public Boolean delete(int id) {
		if (trRepository.existsById(id)) {
			trRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public TravelRemoval update(int id, ApprovedDto approvedDto) {
		TravelRemoval travelRemoval = trRepository.findByEmployeeId(id);
		travelRemoval.setApproved(approvedDto.isApproved());
		return trRepository.save(travelRemoval);
	}

	@Override
	public TravelRemoval findById(int id) {
		return trRepository.findById(id).get();

	}

	@Override
	public Collection<TravelRemoval> findAll() {
		Iterable<TravelRemoval> itr = trRepository.findAll();
		return (Collection<TravelRemoval>) itr;
	}

	@Override
	public Collection<TravelRemovalResponseDto> findApprovedTravelRemovals() {
		boolean approved = true;
        Collection<TravelRemovalResponseDto> trs = new ArrayList<>();
        for(TravelRemoval tr :trRepository.findByApproved(approved)) {
    		TravelRemovalResponseDto trDto =new TravelRemovalResponseDto();
    		Employee employee=tr.getEmployee();
    		trDto.setFrom_work_place(tr.isFrom_work_place());
    		trDto.setRemoval_duration(tr.getRemoval_duration().toString());
    		trDto.setRemovalHour(tr.getRemovalHour());
    		trDto.setAddress(employee.getAddress());
    		trDto.setFullname(employee.getFullname());
    		trDto.setPhone(employee.getPhone());
    		trDto.setWorkplace(employee.getWorkplace());
    		trs.add(trDto);
        }
        return trs;
	}

	@Override
	public TravelRemoval findByEmployeeId(int id) {
		return trRepository.findByEmployeeId(id);
	}

	@Override
	public Collection<TravelRemovalResponseDto> findByRemovalHour(String removalHour) {
		Collection<TravelRemovalResponseDto> trs = new ArrayList<>();
        for(TravelRemoval tr :trRepository.findByRemovalHour(removalHour)) {
    		TravelRemovalResponseDto trDto =new TravelRemovalResponseDto();
    		Employee employee=tr.getEmployee();
    		trDto.setFrom_work_place(tr.isFrom_work_place());
    		trDto.setRemoval_duration(tr.getRemoval_duration().toString());
    		trDto.setRemovalHour(tr.getRemovalHour());
    		trDto.setAddress(employee.getAddress());
    		trDto.setFullname(employee.getFullname());
    		trDto.setPhone(employee.getPhone());
    		trDto.setWorkplace(employee.getWorkplace());
    		trs.add(trDto);
        }
        return trs;	}

}
