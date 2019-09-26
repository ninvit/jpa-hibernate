package dao;

import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;


public class DAOImpl<T> implements DAO<T> {
    @PersistenceContext
    private EntityManager em;
    private final Class<T> classe;

    public DAOImpl(Class<T> classe, EntityManager em) {
        this.classe = classe;
        this.em = em;
    }

    @Override
    public T save(T entity) {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
        return entity;
    }

    @Override
    public T update(T entity) {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
        return entity;
    }

    @Override
    public List<T> listAll() {
        StringBuilder sql = new StringBuilder();
        sql.append("Select e from ").append(this.classe.getSimpleName()).append(" e");
        TypedQuery<T> query = em.createQuery(sql.toString(), this.classe);
        return query.getResultList();
    }



    @Override
    public void remove(T entity) {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        em.remove(em.contains(entity) ? entity : em.merge(entity));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public T findById(Serializable id) {
        return em.find(this.classe, id);
    }
}
