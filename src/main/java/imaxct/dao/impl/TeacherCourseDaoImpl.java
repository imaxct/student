package imaxct.dao.impl;

import imaxct.dao.ITeacherCourseDao;
import imaxct.domain.Course;
import imaxct.domain.Teacher;
import imaxct.domain.TeacherCourse;
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
public class TeacherCourseDaoImpl extends HibernateDaoSupport implements ITeacherCourseDao {

    public boolean addTeacherCourse(TeacherCourse teacherCourse) {
        getHibernateTemplate().persist(teacherCourse);
        return true;
    }

    public boolean deleteTeacherCourse(TeacherCourse teacherCourse) {
        getHibernateTemplate().delete(teacherCourse);
        return true;
    }

    @Transactional(readOnly = true)
    public List getTeacherByCourse(final Course course) {
        return getHibernateTemplate().execute(new HibernateCallback<List>() {
            public List doInHibernate(Session session) throws HibernateException {
                return session.createQuery("from TeacherCourse tc where tc.pk.cid=?").setParameter(0, course).list();
            }
        });
    }

    @Transactional(readOnly = true)
    public List getCourseByTeacher(final Teacher teacher) {
        return getHibernateTemplate().execute(new HibernateCallback<List>() {
            public List doInHibernate(Session session) throws HibernateException {
                return session.createQuery("from TeacherCourse tc where tc.pk.tid=?").setParameter(0, teacher).list();
            }
        });
    }
}
