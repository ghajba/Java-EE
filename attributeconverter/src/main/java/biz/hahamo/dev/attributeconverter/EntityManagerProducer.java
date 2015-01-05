package biz.hahamo.dev.attributeconverter;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author GHajba
 *
 *
 */
public class EntityManagerProducer {

    @Produces
    @Dependent
    @PersistenceContext
    private EntityManager entityManager;

}
