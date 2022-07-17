package tsm.auth.entity;


import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "account")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private Boolean enabled = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
