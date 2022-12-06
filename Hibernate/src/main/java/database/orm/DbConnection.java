package database.orm;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DbConnection<T> implements IConnector<T>{

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    private EntityManager em;
    private EntityTransaction et;

    @Override
    public void create(T entity) {

        em = emf.createEntityManager();
        et = em.getTransaction();

        try {
            et.begin();

            em.persist(entity);

            et.commit();
        } finally {
            if (et.isActive())
                et.rollback();

            em.close();
        }
    }

    @Override
    public T read(T classObject, int entityKey) {

        em = emf.createEntityManager();
        et = em.getTransaction();

        T returnObject = classObject;

        try {
            et.begin();

            returnObject = (T) em.find(returnObject.getClass(), entityKey);

            et.commit();
        } finally {
            if (et.isActive())
                et.rollback();

            em.close();
        }

        return returnObject;
    }

    @Override
    public List<T> readAll(T classObject) {

        em = emf.createEntityManager();
        et = em.getTransaction();

        List<T> returnList;

        try {
            et.begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<T> cq = (CriteriaQuery<T>) cb.createQuery(classObject.getClass());
            Root<T> rootEntry = (Root<T>) cq.from(classObject.getClass());
            CriteriaQuery<T> all = cq.select(rootEntry);

            returnList = em.createQuery(all).getResultList();
        } finally {
            if (et.isActive())
                et.rollback();

            em.close();
        }

        return returnList;
    }

    @Override
    public void update(T entity) {

        em = emf.createEntityManager();
        et = em.getTransaction();

        try {
            et.begin();

            em.refresh(entity);

            et.commit();
        } finally {
            if (et.isActive())
                et.rollback();

            em.close();
        }
    }

    @Override
    public void delete(T entity) {

        em = emf.createEntityManager();
        et = em.getTransaction();

        try {
            et.begin();

            em.remove(entity);

            et.commit();
        } finally {
            if (et.isActive())
                et.rollback();

            em.close();
        }
    }
}
