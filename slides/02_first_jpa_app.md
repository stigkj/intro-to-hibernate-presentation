!SLIDE content full-page incremental
## **
# First JPA application
## Entity (with cascading enabled)

	@@@java
	@Entity(name = "USERS")
	@NamedQuery(name = "findWithRoles",
	            query = "select u from User u " +
	                    "where u.roles is not empty")
	public class User {
	    @Id
	    private String id;

	    private String firstName;
	    private String lastName;

	    @ManyToMany(cascade = PERSIST,
	                mappedBy = "users")
	    private Set<Role> roles;
	}


!SLIDE content full-page
# First JPA application
## persistence.xml

	@@@xml
	<?xml version="1.0" encoding="UTF-8"?>
	<persistence ...>
	  <persistence-unit name="example" 
	             transaction-type="RESOURCE_LOCAL"/>
	</persistence>


!SLIDE content full-page
## **
# First JPA application
## Another entity

	@@@java
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


!SLIDE content full-page incremental
## **
# First JPA application
## EntityManager CRUD operations

	@@@java
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


!SLIDE content full-page
## **
# First JPA application
## Spring setup

	@@@xml
	<?xml version="1.0" encoding="UTF-8"?>
	<beans ...>
	  <context:component-scan base-package="dao"/>
	  <context:annotation-config/>

	  <bean id="entityManagerFactory"
	      class="o.s.o.j.LocalEntityManagerFactoryBean">
	    <property name="persistenceUnitName" 
	              value="example"/>
	    <property name="jpaProperties">
	      <props>
	        <prop key="hibernate.dialect">
	          org.hibernate.dialect.Oracle10Dialect
	        </prop>
	      </props>
	    </property>
	  </bean>
	  <bean id="transactionManager"
	        class="o.s.orm.jpa.JpaTransactionManager">
	    <property name="entityManagerFactory" 
	              ref="entityManagerFactory"/>
	  </bean>
	</beans>