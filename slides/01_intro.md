!SLIDE full-page
# JPA
## of which Hibernate is an implementation

!SLIDE content full-page incremental

* What is ORM?
* Qepta has one, almost (O_M)
* save a object _graph_ to the database
* Why? because you want to design your object model without thinking too much about the db model

## setup

* persistence.xml
* annotations (Entity, OneToOne (*Member in NOS MD), ManyToOne, OneToMany, ManyToMany (no need for an object representing the binding table)...)
* spring setup
* set database dialect, url, etc

## EntityManager

* find
* createQuery
* persist

## relation management (Cascade)

### you own me

* PERSIST
* MERGE
* REMOVE
* REFRESH
* ALL

### Do not load the world

* LAZY
- use select with joins to get to more objects
- iterating over an collection creates one select for each entry unless @BatchSize is set
- outside transaction, you will get an exception if relation is not loaded
* EAGER

## Advantages

* Hibernate knows about a lot of patterns for "running fast"
* It knows about what makes a specific database tick fast