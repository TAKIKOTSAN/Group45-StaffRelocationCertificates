package staff.relocation.certificates.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import staff.relocation.certificates.system.dto.RoleDto;
import staff.relocation.certificates.system.dto.UserDto;
import staff.relocation.certificates.system.model.Authority;
import staff.relocation.certificates.system.model.RoleName;
import staff.relocation.certificates.system.model.Supervisor;
import staff.relocation.certificates.system.model.User;
import staff.relocation.certificates.system.repository.AuthorityRepository;
import staff.relocation.certificates.system.repository.UserRepository;
import staff.relocation.certificates.system.service.AuthorityService;
import staff.relocation.certificates.system.service.UserService;

@Service
public class InitData {
	@Autowired
	private AuthorityService authorityService;
	@Autowired
	private UserService userService;

	public void Init() {
		if (authorityService.findAll().isEmpty()) {
			authorityService.save(new RoleDto("ROLE_ADMIN"));
			userService.save(
					new UserDto("admin", "admin199@gmail.com", "admin", "admin", "ROLE_ADMIN"));		
		}
	}
}
