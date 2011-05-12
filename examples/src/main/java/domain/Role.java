package domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "findAdminRole",
            query = "select r from Role r " +
                    "where r.name = 'admin'")
public class Role {
    @Id
    private String id;

    @Column(name = "ROLENAME")
    private String name;

    @ManyToMany
    private Set<User> users;
}