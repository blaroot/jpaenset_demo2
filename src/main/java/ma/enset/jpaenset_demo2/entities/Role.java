package ma.enset.jpaenset_demo2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data@AllArgsConstructor@NoArgsConstructor
public class Role {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String desc;
    @Column(name = "COLUMN_NAME",unique = true,length = 20)
    private String roleName;
    @ManyToMany(fetch = FetchType.EAGER)
    //@JoinTable(name="USERS_ROLE")
    @ToString.Exclude
    private List<User>users=new ArrayList<>();
}
