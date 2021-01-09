package staff.relocation.certificates.system.service;

import java.util.Collection;

import staff.relocation.certificates.system.dto.UserDto;
import staff.relocation.certificates.system.model.User;


public interface UserService {
	User save(UserDto user);

    Boolean delete(int id);

    User update(int id,UserDto user);

    User findById(int id);

     User findByUserName(String Username);

     User findByEmail(String email);

    Collection<User> findAll();
}
