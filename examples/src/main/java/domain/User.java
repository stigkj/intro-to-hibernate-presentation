package domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import static javax.persistence.CascadeType.PERSIST;

@Entity(name = "USERS")
@NamedQuery(name = "findWithRoles",
            query = "select u from User u where u.roles is not empty")
public class User {
    @Id
    private String id;

    private String firstName;
    private String lastName;

    @ManyToMany(cascade = PERSIST, mappedBy = "users")
    private Set<Role> roles;
}