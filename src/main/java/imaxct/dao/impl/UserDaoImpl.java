package imaxct.dao.impl;

import imaxct.dao.IUserDao;
import imaxct.domain.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by imaxct on 17-4-6.
 */

@Repository("userDao")
public class UserDaoImpl extends HibernateDaoSupport implements IUserDao {

    @Resource(name = "sessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    @Transactional
    public boolean createUser(String username, String password) {
        final User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        try {
            return getHibernateTemplate().execute(new HibernateCallback<Boolean>() {
                public Boolean doInHibernate(Session session) throws HibernateException {
                    session.persist(user);
                    return true;
                }
            });
        }catch (Exception e){
            return false;
        }
    }

    @Transactional(readOnly = true)
    public User getUserById(int id) {
        return getHibernateTemplate().get(User.class, id);
    }

    @Transactional(readOnly = true)
    public User getUserByName(final String username) {
        try {
            return getHibernateTemplate().execute(new HibernateCallback<User>() {
                public User doInHibernate(Session session) throws HibernateException {
                    Query query = session.createQuery("from User where username=?", User.class);
                    query.setParameter(0, username);
                    return (User) query.uniqueResult();
                }
            });
        }catch (Exception e){
            return null;
        }

    }
}
