package biz.hahamo.dev.enterprise.example;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ShapeRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Shape> findAll() {
		return em.createQuery("SELECT s FROM Shape s", Shape.class).getResultList();
	}

}
