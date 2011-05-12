package no.nos.jpa.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@org.hibernate.annotations.GenericGenerator(
        name = "hibernate-uuid", strategy = "uuid"
)
public class Person {
    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    private String id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "owner")
    private Set<Car> cars = new HashSet<Car>();

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public String getId() {
        return id;
    }


    public void addCar(Car car) {
        cars.add(car);
    }


}
