package ma.enset.jpaenset_demo2.Repositories;


import ma.enset.jpaenset_demo2.entities.Role;
import ma.enset.jpaenset_demo2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}
