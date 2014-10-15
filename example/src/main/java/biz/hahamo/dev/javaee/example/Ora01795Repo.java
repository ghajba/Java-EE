package biz.hahamo.dev.javaee.example;

import java.util.ArrayList;
import java.util.List;

import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Simple repository to demonstrate the ORA-01795 exception and its avoiding with interceptors.
 * 
 * @author GHajba
 * 
 */
public class Ora01795Repo {

    /**
     * 
     */
    private static final int _1001 = 1001;
    @PersistenceContext
    private EntityManager entityManager;

    public void createOra01795() {

        Query query = entityManager.createQuery("FROM TestEntity WHERE id in (:ids)", String.class);
        query.setParameter("ids", generateBigList());
        query.getResultList();
    }

    @Interceptors(BigListInterceptor.class)
    public void handleOra01795(final List<Long> parameters) {

        Query query = entityManager.createQuery("FROM TestEntity WHERE id in (:ids)", String.class);
        query.setParameter("ids", parameters);
        query.getResultList();
    }

    private List<Long> generateBigList() {

        List<Long> idList = new ArrayList<>(_1001);
        for (long i = 0; i < _1001; i++) {
            idList.add(i);
        }
        return idList;
    }

}
