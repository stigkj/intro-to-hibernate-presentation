!SLIDE full-page
# JPA
## Object Relational Mapping for Java


!SLIDE content full-page incremental
# Background

* Java Persistence API introduced in JSR-220 (EJB)
* JPA simplifies the Java ORM landscape
	* Hibernate/JDO/etc each have their own APIs
* Works both in a container or just in a plain JDK (>=1.5)


!SLIDE content full-page incremental
# What is ORM?

* Save an object *graph* to the database
* Load an object *graph* from the database
* Qepta has one, well, almost (O_M)


!SLIDE content full-page incremental
# Why? 
* Because you don't want the limitations of the database model to influence your object model
* Use Case modeling of your DAOs
    * Do *not* use a DAO for each entity
    * TUC has only 1 DAO (loads jobs)
* Voetstoots


!SLIDE content full-page incremental
# Features
* POJO-based persistence model
* Supports traditional O-O modeling concepts
    * Inheritance, polymorphism, encapsulation, etc.
* Standard abstract relational query language
    * Java Persistence Query Language (JPQL)
* Standard O/R mapping metadata
    * Using Java SE 5 Annotations and/or XML
* Portability across providers
    * Toplink, Hibernate, Kodo, OpenJPA, EclipseLink

