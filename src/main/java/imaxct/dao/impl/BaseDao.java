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
 * Created by imaxct on 17-4-10.
 */
public class BaseDao<T> {
    protected static Logger logger = LogManager.getLogger(BaseDao.class);

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    protected Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    public boolean create(T t) {
        Session session = currentSession();
        try {
            session.persist(t);
            return true;
        } catch (Exception e) {
            logger.error("create", e);
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

    public boolean saveOrUpdate(T t) {
        Session session = currentSession();
        try {
            session.saveOrUpdate(t);
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("saveOrUpdate", e);
            return false;
        }
    }

    public T uniqueResult(String hql, Object... objects) {
        Session session = currentSession();
        Query query = session.createQuery(hql);
        if (objects != null && objects.length > 0) {
            for (int i = 0; i < objects.length; ++i)
                query.setParameter(i, objects[i]);
        }
        return (T) query.uniqueResult();
    }

    public T find(Class<T> clazz, Serializable id) {
        return currentSession().get(clazz, id);
    }

    public List<T> list(String hql, Object... objects) {
        Session session = currentSession();
        Query query = session.createQuery(hql);
        if (objects != null && objects.length > 0) {
            for (int i = 0; i < objects.length; ++i) {
                query.setParameter(i, objects[i]);
            }
        }

        return query.list();
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

    public boolean batchUpdate(Object... objects) {
        if (objects != null && objects.length > 0) {
            Session session = currentSession();
            for (Object object : objects) {
                session.update(object);
            }
            return true;
        }
        return false;
    }

    public boolean batchInsert(Object... objects) {
        if (objects != null && objects.length > 0) {
            Session session = currentSession();
            for (Object object : objects) {
                session.persist(object);
            }
            return true;
        }
        return false;
    }
}
