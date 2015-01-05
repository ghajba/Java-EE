package biz.hahamo.dev.attributeconverter;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * @author GHajba 2015 jan. 5
 *
 */
@Transactional
public class ExampleRepository {

    @Inject
    private EntityManager em;

    public List<ExampleEntity> findAll() {
        return this.em.createQuery("SELECT example FROM ExampleEntity example", ExampleEntity.class).getResultList();
    }

    public void save(ExampleEntity e) {
        this.em.persist(e);
    }

}
