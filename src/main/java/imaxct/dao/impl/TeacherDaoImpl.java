package imaxct.dao.impl;

import imaxct.dao.ITeacherDao;
import imaxct.domain.Department;
import imaxct.domain.Teacher;
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
public class TeacherDaoImpl extends HibernateDaoSupport implements ITeacherDao {

    public boolean addTeacher(Teacher teacher) {
        getHibernateTemplate().persist(teacher);
        return true;
    }

    public boolean deleteTeacher(Teacher teacher) {
        getHibernateTemplate().delete(teacher);
        return true;
    }

    public boolean updateTeacher(Teacher teacher) {
        getHibernateTemplate().update(teacher);
        return true;
    }

    @Transactional(readOnly = true)
    public List getTeacherByDepartment(final Department department) {
        return getHibernateTemplate().execute(new HibernateCallback<List>() {
            public List doInHibernate(Session session) throws HibernateException {
                return session.createQuery("from Teacher where dname=?").setParameter(0, department).list();
            }
        });
    }

    @Transactional(readOnly = true)
    public Teacher getTeacherById(final String tid) {
        return getHibernateTemplate().execute(new HibernateCallback<Teacher>() {
            public Teacher doInHibernate(Session session) throws HibernateException {
                return session.find(Teacher.class, tid);
            }
        });
    }

    @Transactional(readOnly = true)
    public Teacher getTeacherByName(final String name) {
        return getHibernateTemplate().execute(new HibernateCallback<Teacher>() {
            public Teacher doInHibernate(Session session) throws HibernateException {
                return (Teacher) session.createQuery("from Teacher where name=?").setParameter(0, name).uniqueResult();
            }
        });
    }
}
