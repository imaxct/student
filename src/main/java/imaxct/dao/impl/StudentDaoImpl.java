package imaxct.dao.impl;

import imaxct.dao.IStudentDao;
import imaxct.domain.Department;
import imaxct.domain.Student;
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
public class StudentDaoImpl extends HibernateDaoSupport implements IStudentDao{

    public boolean addStudent(Student student) {
        getHibernateTemplate().persist(student);
        return true;
    }

    public boolean deleteStudent(Student student) {
        getHibernateTemplate().delete(student);
        return true;
    }

    @Transactional(readOnly = true)
    public List getStudentByDepartment(final Department department) {
        return getHibernateTemplate().execute(new HibernateCallback<List>() {
            public List doInHibernate(Session session) throws HibernateException {
                return session.createQuery("from Student where dname=?").setParameter(0, department).list();
            }
        });
    }

    @Transactional(readOnly = true)
    public List getStudentByClass(final String clazz) {
        return getHibernateTemplate().execute(new HibernateCallback<List>() {
            public List doInHibernate(Session session) throws HibernateException {
                return session.createQuery("from Student where clazz=?").setParameter(0, clazz).list();
            }
        });
    }
}
