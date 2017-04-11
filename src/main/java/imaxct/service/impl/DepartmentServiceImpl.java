package imaxct.service.impl;

import imaxct.dao.IDepartmentDao;
import imaxct.domain.Department;
import imaxct.service.IDepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Resource
    private IDepartmentDao departmentDao;

    public boolean addDepartment(Department department) {
        return departmentDao.addDepartment(department);
    }

    public boolean deleteDepartment(Department department) {
        return departmentDao.deleteDepartment(department);
    }

    public boolean updateDepartment(Department department) {
        return departmentDao.updateDepartment(department);
    }

    public List getAllDepartment() {
        return departmentDao.getAllDepartment();
    }
}
