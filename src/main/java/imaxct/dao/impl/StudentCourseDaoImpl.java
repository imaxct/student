package imaxct.dao.impl;

import imaxct.dao.IStudentCourseDao;
import imaxct.domain.Course;
import imaxct.domain.Student;
import imaxct.domain.StudentCourse;
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
public class StudentCourseDaoImpl extends HibernateDaoSupport implements IStudentCourseDao{

    public boolean addStudentCourse(StudentCourse studentCourse) {
        getHibernateTemplate().persist(studentCourse);
        return true;
    }

    public boolean deleteStudentCourse(StudentCourse studentCourse) {
        getHibernateTemplate().delete(studentCourse);
        return true;
    }

    @Transactional(readOnly = true)
    public List getCourseByStudent(final Student student) {
        return getHibernateTemplate().execute(new HibernateCallback<List>() {
            public List doInHibernate(Session session) throws HibernateException {
                return session.createQuery("from StudentCourse where sid=?").setParameter(0, student).list();
            }
        });
    }

    @Transactional(readOnly = true)
    public List getStudentByCourse(final Course course) {
        return getHibernateTemplate().execute(new HibernateCallback<List>() {
            public List doInHibernate(Session session) throws HibernateException {
                return session.createQuery("from StudentCourse where cid=?").setParameter(0, course).list();
            }
        });
    }

    public List getAllStudentCourse() {
        return getHibernateTemplate().execute(new HibernateCallback<List>() {
            public List doInHibernate(Session session) throws HibernateException {
                return session.createQuery("from StudentCourse").list();
            }
        });
    }
}
