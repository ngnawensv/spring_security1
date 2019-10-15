/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.belrose.belrose_security.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Ngnawen
 * @param <T>
 * @param <Id>
 */
public interface GenericDao<T extends Object, Id extends Serializable> {

    public T findById(Id id) throws Exception;

    public List<T> findAll() throws Exception;

    public T create(T t) throws Exception;

    public T update(T t) throws Exception;

    public void delete(T t) throws Exception;

    public EntityManager getEntityManager();

    public void setEntityManager(EntityManager entityManager);
}
