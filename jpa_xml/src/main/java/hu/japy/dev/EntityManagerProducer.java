package hu.japy.dev;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Produces an entity manager for the underlying Database Access Layer
 * 
 * @author GHajba
 */
public class EntityManagerProducer {

    @Produces
    @Dependent
    @PersistenceContext
    private EntityManager entityManager;

}
