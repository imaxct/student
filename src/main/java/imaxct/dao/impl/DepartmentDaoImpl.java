package imaxct.dao.impl;

import imaxct.dao.IDepartmentDao;
import imaxct.domain.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
@Repository
public class DepartmentDaoImpl extends BaseDao<Department> implements IDepartmentDao {
    public boolean addDepartment(Department department) {
        return this.create(department);
    }

    public boolean deleteDepartment(Department department) {
        return this.delete(department);
    }

    public boolean updateDepartment(Department department) {
        return this.update(department);
    }

    public List getAllDepartment() {
        return this.execute("from Department");
    }

}
