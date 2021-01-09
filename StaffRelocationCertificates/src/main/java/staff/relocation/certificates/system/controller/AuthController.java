package staff.relocation.certificates.system.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import staff.relocation.certificates.system.dto.LoginDto;
import staff.relocation.certificates.system.dto.response.LoggedResponse;
import staff.relocation.certificates.system.exception.CustomException;
import staff.relocation.certificates.system.model.User;
import staff.relocation.certificates.system.repository.AuthorityRepository;
import staff.relocation.certificates.system.repository.UserRepository;
import staff.relocation.certificates.system.repository.UserRepository;
import staff.relocation.certificates.system.security.JwtUtils;
import staff.relocation.certificates.system.service.EmployeeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserRepository userRepository;
	@Autowired
    private EmployeeService employeeService;
	@Autowired
	AuthorityRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDto loginRequest) {
	
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		User user = (User) authentication.getPrincipal();
		String role = user.getAuthorities().stream().map(item -> item.getAuthority())
				.findFirst().get().toString();
		System.out.println(role);
		return ResponseEntity.ok(
				new LoggedResponse(jwt, user.getId(), user.getUsername(), user.getEmail(),user.getFullname(), role));
	}
	@PostMapping("/employee/signin")
	public ResponseEntity<?> authenticateEmployee(@Valid @RequestBody LoginDto loginRequest) {
		if(employeeService.findByUserName(loginRequest.getUsername())==null) {
			throw new CustomException("Username or password are invalid !", HttpStatus.UNAUTHORIZED);

		}
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
	
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
	
		User user = (User) authentication.getPrincipal();
		String role = user.getAuthorities().stream().map(item -> item.getAuthority())
				.findFirst().get().toString();
		System.out.println(role);
		return ResponseEntity.ok(
				new LoggedResponse(jwt, user.getId(), user.getUsername(), user.getEmail(),user.getFullname(), role));
	}
}
