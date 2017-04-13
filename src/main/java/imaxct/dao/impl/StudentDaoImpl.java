package imaxct.dao.impl;

import imaxct.dao.IStudentDao;
import imaxct.domain.Department;
import imaxct.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
@Repository
public class StudentDaoImpl extends BaseDao<Student> implements IStudentDao{

    public boolean addStudent(Student student) {
        return this.create(student);
    }

    public boolean deleteStudent(Student student) {
        return this.delete(student);
    }

    public List getStudentByDepartment(final Department department) {
        return this.execute("from Student where dname=?", department);
    }

    public List getStudentByClass(final String clazz) {
        return this.execute("from Student where clazz=?", clazz);
    }
}
