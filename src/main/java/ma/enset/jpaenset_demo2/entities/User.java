package ma.enset.jpaenset_demo2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="USERS")
@Data @AllArgsConstructor@NoArgsConstructor
public class User {
    @Id
    private String UserId;
    @Column(name="USER_NAME",unique = true,length = 20)
    private  String userNAME;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String   password;
    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Role> roles=new ArrayList<>();
}
