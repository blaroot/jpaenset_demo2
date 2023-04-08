package ma.enset.jpaenset_demo2;

import ma.enset.jpaenset_demo2.Repositories.RoleRepository;
import ma.enset.jpaenset_demo2.entities.Role;
import ma.enset.jpaenset_demo2.entities.User;
import ma.enset.jpaenset_demo2.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class JpaensetDemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(JpaensetDemo2Application.class, args);
    }
    @Bean
    CommandLineRunner start(UserService userService){
        return args -> {
            User u=new User();
            u.setUserNAME("user1");
            u.setPassword("123456");
            userService.addNewUser(u);
            User u2=new User();
            u2.setUserNAME("admin");
            u2.setPassword("123456");
            userService.addNewUser(u2);
            Stream.of("STUDENT","USER","ADMIN").forEach(r->{
                Role role1=new Role();
                role1.setRoleName(r);
                userService.addNewRole(role1);
            });
            userService.addRoleUser("user1","STUDENT");
            userService.addRoleUser("user1","USER");
            userService.addRoleUser("admin","USER");
            userService.addRoleUser("admin","ADMIN");
            try {
                User user=userService.authentificate("user1","123456");
                System.out.println(user.getUserId());
                System.out.println(user.getUserNAME());
                System.out.println("ROLES==>");
                user.getRoles().forEach(r -> {
                    System.out.println("role"+ r);
                });
            }catch (Exception e){
                e.printStackTrace();
            }
        };
   }}

