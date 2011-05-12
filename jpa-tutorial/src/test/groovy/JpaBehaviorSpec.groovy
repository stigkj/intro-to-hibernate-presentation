import spock.lang.Specification
import javax.persistence.EntityManagerFactory
import spock.lang.Shared
import javax.persistence.Persistence
import javax.persistence.EntityManager
import no.nos.jpa.domain.Person
import no.nos.jpa.domain.Car
import org.hibernate.LazyInitializationException

class JpaBehaviorSpec extends Specification{
    @Shared EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpademo")

    def "A simple entity should be saved  and inserted when persist is called"(){
        setup:
        Person person = new Person("Greger")
        EntityManager em = emf.createEntityManager()
        em.getTransaction().begin()

        when:
        em.persist(person)
        em.getTransaction().commit()

        then:
        Person persistedPerson = em.find(Person.class,person.getId())   //Works even when commit is not called !
        assert persistedPerson != null
        em.close()
    }

       def "A simple entity should be in the first level cache when persist is called"(){
        setup:
        Person person = new Person("Greger")
        EntityManager em = emf.createEntityManager()
        em.getTransaction().begin()

        when:
        em.persist(person)

        then:
        Person persistedPerson = em.find(Person.class,person.getId())   //Works even when commit is not called !
        assert persistedPerson != null
        em.close()
    }


    def "An object with relations should throw LazyLoadingException when accessed outside a tx"(){
        setup:
        Person person = new Person("Greger")
        person.addCar(new Car("Volvo", person))
        EntityManager em = emf.createEntityManager()


        when:
        em.getTransaction().begin()
        em.persist(person)
        em.getTransaction().commit()
        em.close()

        EntityManager em2 = emf.createEntityManager()
        em2.getTransaction().begin()
        Person persistedPerson = em2.find(Person.class,person.getId())   //Works even when commit is not called !
        em2.getTransaction().commit()
        em2.close()
        Set<Car> cars = persistedPerson.getCars()
        cars.size()  == 1      //Collection classes is replaced by hibernate, they are lazy ( no select statement occurs before we use the collection !)

        then:
        LazyInitializationException e = thrown()
    }

     def "Persist should only be used for new objects, dirty detection should update the rest. "(){
        setup:
        Person person = new Person("Greger")
        person.addCar(new Car("Volvo", person))
        EntityManager em = emf.createEntityManager()


        when:
        em.getTransaction().begin()
        em.persist(person)
        em.getTransaction().commit()
        em.close()

        EntityManager em2 = emf.createEntityManager()
        em2.getTransaction().begin()
        Person persistedPerson = em2.find(Person.class,person.getId())   //Works even when commit is not called !
        persistedPerson.setName("Gorm")
        em2.getTransaction().commit()
        em2.close()

        then:

        EntityManager em3 = emf.createEntityManager()
        em3.getTransaction().begin()
        Person persistedPerson2 = em3.find(Person.class,person.getId())   //Works even when commit is not called !
        assert "Gorm" == persistedPerson2.getName()
        em3.getTransaction().commit()
        em3.close()
     }
}
