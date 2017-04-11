package imaxct.service.impl;

import imaxct.dao.IStudentDao;
import imaxct.domain.Department;
import imaxct.domain.Student;
import imaxct.service.IStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
@Service
public class StudentServiceImpl implements IStudentService {

    @Resource
    private IStudentDao studentDao;

    public boolean addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    public boolean deleteStudent(Student student) {
        return studentDao.deleteStudent(student);
    }

    public List getStudentByDepartment(Department department) {
        return studentDao.getStudentByDepartment(department);
    }

    public List getStudentByClass(String clazz) {
        return studentDao.getStudentByClass(clazz);
    }
}
