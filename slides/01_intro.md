!SLIDE full-page
# JPA
## Object Relational Mapping specification for Java

!SLIDE content full-page incremental
## Background

* Java Persistence API introduced in JSR-220 (EJB)
* Hibernate/JDO/etc each have their own APIs, which was made better with JPA
* Works both in a container or just in a plain JDK (1.5)


!SLIDE content full-page incremental
## What is ORM?

* Qepta uses one, almost (O_M)
* Save a object _graph_ to the database


!SLIDE content full-page incremental
## Why? 
* Because you don't want the limitations of the database model to seep into your object model

!SLIDE content full-page incremental
## Features
* POJO-based persistence model
* Supports traditional O-O modelling concepts
    * Inheritance, polymorphism, encapsulation, etc.
* Standard abstract relational query language
    * Java Persistence Query Language (JPQL)
* Standard O/R mapping metadata
    * Using Java SE 5 Annotations and/or XML
* Portability across providers
    * Toplink, Hibernate, Kodo, OpenJPA, EclipseLink


!SLIDE content full-page incremental

## setup

Important! do *not* use the column names in the JPQL, use the name of the fields in the java class
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