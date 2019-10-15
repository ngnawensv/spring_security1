/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.belrose.belrose_security.daoImpl;

import cm.belrose.belrose_security.dao.GenericDao;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Ngnawen
 * @param <T>
 * @param <Id>
 */
public abstract class GenericDaoImpl<T extends Object, Id extends Serializable> implements GenericDao<T,Id>{
    
    @PersistenceContext
    private EntityManager entityManager;

    private final Class<T> entityClass;

    private CriteriaBuilder cb;
    private CriteriaQuery<T> cq;

    public GenericDaoImpl() {
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
    }

    @Override

    public T findById(Id id) throws Exception {
        return entityManager.find(entityClass, id);
    }

    @Override
    public List<T> findAll() throws Exception {
        cb = getEntityManager().getCriteriaBuilder();
        cq = cb.createQuery(entityClass);
        cq.from(entityClass);
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public T create(T t) throws Exception {
        entityManager.persist(t);
        return t;
    }

    @Override
    public T update(T t) throws Exception {
        return entityManager.merge(t);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void delete(T t) throws Exception {
        entityManager.remove(t);
    }

}

