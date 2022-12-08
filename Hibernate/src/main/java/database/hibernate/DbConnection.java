package database.hibernate;

import database.daoInterfaces.IDbDao;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DbConnection<T> implements IDbDao<T> {

    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction et;

    public DbConnection() {
    }

    @Override
    public T Create(T entity) {

        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        et = em.getTransaction();

        try {
            et.begin();

            em.persist(entity);

            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (et.isActive()) {
                et.rollback();
                System.out.println("IT ROLLED BACK");
            }

            em.close();
            emf.close();
        }
        return entity;
    }

    @Override
    public T Read(T classObject, String id) {

        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        et = em.getTransaction();

        T returnObject = classObject;

        try {
            et.begin();

            returnObject = (T) em.find(returnObject.getClass(), id);

            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            if (et.isActive())
                et.rollback();

            em.close();
            emf.close();
        }

        return returnObject;
    }

    @Override
    public List<T> ReadAll(T classObject) {

        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        et = em.getTransaction();

        List<T> returnList = new ArrayList<>();

        try {
            et.begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<T> cq = (CriteriaQuery<T>) cb.createQuery(classObject.getClass());
            Root<T> rootEntry = (Root<T>) cq.from(classObject.getClass());
            CriteriaQuery<T> all = cq.select(rootEntry);

            returnList = em.createQuery(all).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            if (et.isActive())
                et.rollback();

            em.close();
            emf.close();
        }

        return returnList;
    }

    @Override
    public T Update(T entity) {

        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        et = em.getTransaction();

        try {
            et.begin();

            em.refresh(entity);

            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            if (et.isActive())
                et.rollback();

            em.close();
            emf.close();
        }
        return entity;
    }

    @Override
    public T Delete(T entity) {

        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        et = em.getTransaction();

        try {
            et.begin();

            em.remove(entity);

            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            if (et.isActive())
                et.rollback();

            em.close();
            emf.close();
        }
        return entity;
    }
}
