package imaxct.dao.impl;

import imaxct.dao.IDepartmentDao;
import imaxct.domain.Department;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
@Repository
@Transactional
public class DepartmentDaoImpl extends HibernateDaoSupport implements IDepartmentDao {
    public boolean addDepartment(Department department) {
        getHibernateTemplate().persist(department);
        return true;
    }

    public boolean deleteDepartment(Department department) {
        getHibernateTemplate().delete(department);
        return true;
    }

    public boolean updateDepartment(Department department) {
        getHibernateTemplate().update(department);
        return true;
    }

    @Transactional(readOnly = true)
    public List getAllDepartment() {
        return getHibernateTemplate().find("from Department");
    }

}
