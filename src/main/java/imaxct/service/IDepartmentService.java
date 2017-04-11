package imaxct.service;

import imaxct.domain.Department;

import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
public interface IDepartmentService {

    boolean addDepartment(Department department);

    boolean deleteDepartment(Department department);

    boolean updateDepartment(Department department);

    List getAllDepartment();
}
