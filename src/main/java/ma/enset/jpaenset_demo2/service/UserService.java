package ma.enset.jpaenset_demo2.service;

import ma.enset.jpaenset_demo2.entities.Role;
import ma.enset.jpaenset_demo2.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole (Role role);
    User finUserByUserName(String userName);
    Role findRoleByRoleName(String role);
    void addRoleUser(String username,String roleName);
    User authentificate(String userName,String passsword);

}
