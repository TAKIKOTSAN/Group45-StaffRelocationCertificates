package staff.relocation.certificates.system.service.impl;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import staff.relocation.certificates.system.dto.UserDto;
import staff.relocation.certificates.system.exception.CustomException;
import staff.relocation.certificates.system.model.Employee;
import staff.relocation.certificates.system.model.RoleName;
import staff.relocation.certificates.system.model.Supervisor;
import staff.relocation.certificates.system.model.User;
import staff.relocation.certificates.system.repository.AuthorityRepository;
import staff.relocation.certificates.system.repository.UserRepository;
import staff.relocation.certificates.system.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthorityRepository authRepository;
	@Autowired
	PasswordEncoder passwordEncode;

	@Override
	public User save(UserDto user) {
		if (userRepository.findByEmail(user.getEmail()) != null) {
			throw new CustomException("Email is already in use", HttpStatus.UNPROCESSABLE_ENTITY);

		} else if (userRepository.findByUsername(user.getUsername()) != null) {
			throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
		} else {
			user.setPassword(passwordEncode.encode(user.getPassword()));
			if (user.getRole().equals("ROLE_SUPERVISOR")) {
				Supervisor supervisor = new Supervisor( user.getUsername(),user.getEmail(),user.getPassword(),
						user.getFullname(),authRepository.findByName(RoleName.getByRoleName(user.getRole())));
				return userRepository.save(supervisor);
			} else if (user.getRole().equals("ROLE_EMPLOYEE")) {
				Employee employee = new Employee(user.getUsername(),user.getEmail(),user.getPassword(),
						user.getFullname(),authRepository.findByName(RoleName.getByRoleName(user.getRole())));
				return userRepository.save(employee);
			}  else {
				User newUser = new User(user.getUsername(),user.getEmail(),user.getPassword(),
						user.getFullname(),authRepository.findByName(RoleName.getByRoleName(user.getRole())));
				return userRepository.save(newUser);
			}
		}
	}

	@Override
	public Boolean delete(int id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public User update(int id, UserDto user) {
		User ex_user = userRepository.findById(id).get();
		if ((!ex_user.getUsername().equals(user.getUsername()))
				&& (userRepository.findByUsername(user.getUsername()) != null)) {
			throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
		} else if ((!ex_user.getEmail().equals(user.getEmail()))
				&& (userRepository.findByEmail(user.getEmail()) != null)) {
			throw new CustomException("Email is already in use", HttpStatus.UNPROCESSABLE_ENTITY);

		} else {
			ex_user.setEmail(user.getEmail());
			ex_user.setFullname(user.getFullname());
			ex_user.setUsername(user.getUsername());
			if (!ex_user.getPassword().equals(user.getPassword())) {
				ex_user.setPassword(passwordEncode.encode(user.getPassword()));
			}
			return userRepository.save(ex_user);
		}

	}

	@Override
	public User findById(int id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User findByUserName(String Username) {
		return userRepository.findByUsername(Username);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public Collection<User> findAll() {
		Iterable<User> itr = userRepository.findAll();
		return (Collection<User>) itr;
	}


}
