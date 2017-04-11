package imaxct.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;

/**
 * Created by maxct on 2017/4/11.
 */
public class BaseDao<T> extends HibernateDaoSupport {
    private static Logger logger = LogManager.getLogger(BaseDao.class);
    public boolean create(T t){
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.persist(t);
            transaction.commit();
            return true;
        }catch (Exception e){
            logger.error("create", e);
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }

    public boolean delete(T t){
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(t);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            logger.error("delete", e);
            return false;
        }finally {
            session.close();
        }
    }

    public boolean update(T t){
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(t);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            logger.error("update", e);
            return false;
        }finally {
            session.close();
        }
    }

    public T find(Class<T> clazz, Serializable id){
        return getHibernateTemplate().get(clazz, id);
    }

    public List<T> list(String hql, Object... objects){
        return (List<T>) getHibernateTemplate().find(hql, objects);
    }

    public List<T> execute(String hql, Object... objects){
        Session session = currentSession();
        try{
            Query query = session.createQuery(hql);
            if (objects != null && objects.length > 0){
                for (int i=0; i<objects.length; ++i){
                    query.setParameter(i, objects[i]);
                }
            }
            return query.list();
        }finally {
            session.close();
        }
    }

    public T uniqueResult(String hql, Object... objects){
        Session session = currentSession();
        try{
            Query query = session.createQuery(hql);
            if (objects != null && objects.length > 0){
                for (int i=0; i<objects.length; ++i){
                    query.setParameter(i, objects[i]);
                }
            }
            return (T) query.uniqueResult();
        }finally {
            session.close();
        }
    }

    public List<T> listPage(int firstPage, int maxResult, String hql, Object... objects){
        Session session = currentSession();
        try{
            Query query = session.createQuery(hql);
            query.setFirstResult(firstPage).setMaxResults(maxResult);
            if (objects != null && objects.length > 0){
                for (int i=0; i<objects.length; ++i){
                    query.setParameter(i, objects[i]);
                }
            }
            return query.list();
        }finally {
            session.close();
        }
    }
}
