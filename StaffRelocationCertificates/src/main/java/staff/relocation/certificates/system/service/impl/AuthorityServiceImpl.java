package staff.relocation.certificates.system.service.impl;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import staff.relocation.certificates.system.dto.RoleDto;
import staff.relocation.certificates.system.exception.CustomException;
import staff.relocation.certificates.system.model.Authority;
import staff.relocation.certificates.system.model.RoleName;
import staff.relocation.certificates.system.model.User;
import staff.relocation.certificates.system.repository.AuthorityRepository;
import staff.relocation.certificates.system.repository.UserRepository;
import staff.relocation.certificates.system.service.AuthorityService;
import staff.relocation.certificates.system.service.UserService;

@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService {
	@Autowired
	AuthorityRepository authRepo;
	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;

	@Override
	public Authority save(RoleDto role) {
		Authority auth = new Authority();
		if (authRepo.findByName(RoleName.getByRoleName(role.getRoleName())) != null) {
			throw new CustomException("This role is already saved!", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		auth.setName(RoleName.getByRoleName(role.getRoleName()));
		return authRepo.save(auth);
	}

	@Override
	public Boolean delete(int id) {
		if (authRepo.existsById(id)) {
			for (User user : userService.findAll()) {
				if (user.getAuthority().getName().equals(authRepo.findById(id).get().getName())) {
					throw new CustomException("You cant delete this role.This role has users!", HttpStatus.UNPROCESSABLE_ENTITY);
				}
			}
			authRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Authority update(int id, RoleDto role) {
		Authority auth = authRepo.findById(id).get();
		auth.setName(RoleName.getByRoleName(role.getRoleName()));
		return authRepo.save(auth);
	}

	@Override
	public Authority findById(int id) {
		return authRepo.findById(id).get();

	}

	@Override
	public Collection<Authority> findAll() {
		Iterable<Authority> itr = authRepo.findAll();
		return (Collection<Authority>) itr;
	}

	@Override
	public Authority findByName(RoleName name) {
		return authRepo.findByName(name);
	}

}
