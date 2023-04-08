package ma.enset.jpaenset_demo2.Repositories;


import ma.enset.jpaenset_demo2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUserNAME(String username);
}
