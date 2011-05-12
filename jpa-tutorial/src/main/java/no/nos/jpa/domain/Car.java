package no.nos.jpa.domain;

import javax.persistence.*;

@Entity
@org.hibernate.annotations.GenericGenerator(
        name = "hibernate-uuid", strategy = "uuid"
)

public class Car {

    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    private String id;
    private String name;

    @ManyToOne
    private Person owner;


    public Car(Person owner) {
        this.owner = owner;
    }

    public Car() {
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Car(String name, Person owner) {
        this.name = name;
        this.owner = owner;
    }
}

