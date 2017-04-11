package imaxct.dao;

import imaxct.domain.Department;

import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
public interface IDepartmentDao {
    boolean addDepartment(Department department);

    boolean deleteDepartment(Department department);

    boolean updateDepartment(Department department);

    List getAllDepartment();
}
