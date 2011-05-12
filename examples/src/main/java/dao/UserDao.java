package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
    @PersistenceContext(unitName = "example")
    private EntityManager entityManager;

    public User findById(String id) {
        return entityManager.find(User.class, id);
    }

    public List<User> findWithRoles() {
        return entityManager.
                createNamedQuery("findWithRoles").
                getResultList();
    }

    public void persist(User user) {
        entityManager.persist(user);
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public void remove(User user) {
        entityManager.remove(user);
    }
}
