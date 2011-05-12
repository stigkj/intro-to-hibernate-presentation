!SLIDE content full-page incremental
# Performance
## How is the graph loaded?

* What happens if
	* User is loaded
	* its roles are iterated over
* Lazy/eager loading can be setup with different granularity
* Hint: use @BatchSize on the @OneToMany relation
* Another: JPQL makes it possible to load more of the graph in one go
* Make sure the graph is complete before using it outside a transaction


!SLIDE content full-page incremental
# Performance
## Advantages

* JPA providers have built up an extensive experience/patterns on how to make stuff run fast
* They know what to do to take advantage of the different databases
