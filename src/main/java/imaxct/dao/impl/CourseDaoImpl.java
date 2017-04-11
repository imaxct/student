package imaxct.dao.impl;

import imaxct.dao.ICourseDao;
import imaxct.domain.Course;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
@Repository
@Transactional
public class CourseDaoImpl extends HibernateDaoSupport implements ICourseDao {

    public boolean addCourse(Course course) {
        getHibernateTemplate().persist(course);
        return true;
    }

    public boolean deleteCourse(Course course) {
        getHibernateTemplate().delete(course);
        return true;
    }

    public boolean updateCourse(Course course) {
        getHibernateTemplate().update(course);
        return true;
    }

    @Transactional(readOnly = true)
    public List getCourseByName(final String name) {
        return getHibernateTemplate().execute(new HibernateCallback<List>() {
            public List doInHibernate(Session session) throws HibernateException {
                return session.createQuery("from Course where name=?").setParameter(0, name).list();
            }
        });
    }

    @Transactional(readOnly = true)
    public List getAllCourses() {
        return getHibernateTemplate().find("from Course");
    }
}
