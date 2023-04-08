package ma.enset.jpaenset_demo2.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.enset.jpaenset_demo2.Repositories.RoleRepository;
import ma.enset.jpaenset_demo2.Repositories.UserRepository;
import ma.enset.jpaenset_demo2.entities.Role;
import ma.enset.jpaenset_demo2.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
//doit etre enistioaliser dans le debut
@Transactional
@AllArgsConstructor
//les transactions vont etre delegue a spring
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;
    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User finUserByUserName(String userName) {
        return userRepository.findByUserNAME(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleUser(String username, String roleName) {
     User user=finUserByUserName(username);
     Role role=findRoleByRoleName(roleName);
     if(user.getRoles()!=null){
       user.getRoles().add(role);
       role.getUsers().add(user);
}}

        @Override
        public User authentificate(String userName, String passsword) {
            User user=userRepository.findByUserNAME(userName);
             if (user==null)throw  new RuntimeException("BAD credentials ");
         if (user.getPassword().equals(passsword)){
                 return user;
         }
             throw  new RuntimeException("BAD  credentials");
    }
}
