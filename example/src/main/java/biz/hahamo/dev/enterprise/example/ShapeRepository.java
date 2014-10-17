package biz.hahamo.dev.enterprise.example;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import biz.hahamo.dev.enterprise.example.joined.ShapeJoined;
import biz.hahamo.dev.enterprise.example.singletable.ShapeSingletable;
import biz.hahamo.dev.enterprise.example.tableperclass.ShapePerclass;

@Stateless
public class ShapeRepository {

    @PersistenceContext
    private EntityManager em;

    public List<ShapeJoined> findAllJoined() {
        return em.createQuery("SELECT s FROM ShapeJoined s", ShapeJoined.class).getResultList();
    }

    public List<ShapeSingletable> findAllSingletable() {
        return em.createQuery("SELECT s FROM ShapeSingletable s", ShapeSingletable.class).getResultList();
    }

    public List<ShapePerclass> findAllPerclass() {
        return em.createQuery("SELECT s FROM ShapePerclass s", ShapePerclass.class).getResultList();
    }

    public void save(Serializable entity) {
        em.persist(entity);
    }

}
