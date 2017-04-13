package imaxct.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by maxct on 2017/4/11.
 */
public class BaseDao<T> {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    private static Logger logger = LogManager.getLogger(BaseDao.class);

    public boolean create(T t) {
        Session session = currentSession();
        try {
            session.persist(t);
            return true;
        } catch (Exception e) {
            logger.error("create", e);
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean delete(T t) {
        Session session = currentSession();
        try {
            session.delete(t);
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("delete", e);
            return false;
        }
    }

    public boolean update(T t) {
        Session session = currentSession();
        try {
            session.update(t);
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("update", e);
            return false;
        }
    }

    public T find(Class<T> clazz, Serializable id) {
        return currentSession().get(clazz, id);
    }

    public List<T> execute(String hql, Object... objects) {
        Session session = currentSession();
        Query query = session.createQuery(hql);
        if (objects != null && objects.length > 0) {
            for (int i = 0; i < objects.length; ++i) {
                query.setParameter(i, objects[i]);
            }
        }
        return query.list();
    }

    public T uniqueResult(String hql, Object... objects) {
        Session session = currentSession();
        Query query = session.createQuery(hql);
        if (objects != null && objects.length > 0) {
            for (int i = 0; i < objects.length; ++i) {
                query.setParameter(i, objects[i]);
            }
        }
        return (T) query.uniqueResult();
    }

    public List<T> listPage(int firstPage, int maxResult, String hql, Object... objects) {
        Session session = currentSession();
        Query query = session.createQuery(hql);
        query.setFirstResult(firstPage).setMaxResults(maxResult);
        if (objects != null && objects.length > 0) {
            for (int i = 0; i < objects.length; ++i) {
                query.setParameter(i, objects[i]);
            }
        }
        return query.list();
    }
}
