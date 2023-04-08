package ma.enset.jpaenset_demo2.web;

import ma.enset.jpaenset_demo2.entities.User;
import ma.enset.jpaenset_demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserConytolleur {
    @Autowired
    private UserService userService;
    @GetMapping("/users/{username}")
    public User user(@PathVariable String username ){
        User user=userService.finUserByUserName(username);
        return user;
    }
}
