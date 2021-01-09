package staff.relocation.certificates.system.controller;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import staff.relocation.certificates.system.dto.EmployeeDto;
import staff.relocation.certificates.system.dto.RoleDto;
import staff.relocation.certificates.system.dto.UserDto;
import staff.relocation.certificates.system.model.Authority;
import staff.relocation.certificates.system.model.Employee;
import staff.relocation.certificates.system.model.User;

import staff.relocation.certificates.system.service.AuthorityService;
import staff.relocation.certificates.system.service.EmployeeService;
import staff.relocation.certificates.system.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
    private AuthorityService authService;
	@Autowired
    private UserService userService;
	
	@GetMapping("/roles")
	@ResponseBody
	public Collection<Authority> Roles() {
		return authService.findAll();
	}
	@PostMapping("/roles/create")
	@ResponseBody
	public  ResponseEntity<Authority> NewRole(@RequestBody RoleDto roleDto) {
		return new ResponseEntity<Authority>(authService.save(roleDto), HttpStatus.CREATED);
	}
	@GetMapping("/roles/{id}")
	@ResponseBody
	public  Authority GetRole(@PathVariable("id") int id) {
		return authService.findById(id);
	}
	@DeleteMapping("/roles/{id}")
	@ResponseBody
	public  ResponseEntity<?>  DeleteRole(@PathVariable("id") int id) {
		boolean isRemoved = authService.delete(id);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
	}
	@PutMapping("/roles/{id}/edit")
	@ResponseBody
	public  Authority EditRole(@PathVariable("id") int id,@RequestBody RoleDto roleDto) {
		return authService.update(id, roleDto);
	}
	@GetMapping("/users")
	@ResponseBody
	public Collection<User> Users() {
		
		return userService.findAll();
	}
	@PostMapping("/users/create")
	@ResponseBody
	public  ResponseEntity<User> NewUser(@RequestBody UserDto userDto) {
		return new ResponseEntity<User>(userService.save(userDto), HttpStatus.CREATED);
	}
	@GetMapping("/users/{id}")
	@ResponseBody
	public  User GetUser(@PathVariable("id") int id) {
		return userService.findById(id);
	}
	@DeleteMapping("/users/{id}")
	@ResponseBody
	public  ResponseEntity<?>  DeleteUser(@PathVariable("id") int id) {
		boolean isRemoved = userService.delete(id);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
	}
	@PutMapping("/users/{id}/edit")
	@ResponseBody
	public  User EditUser(@PathVariable("id") int id,@RequestBody UserDto userDto) {
		return userService.update(id, userDto);
	}
	
}

