package imaxct.service;

import imaxct.domain.Department;
import imaxct.domain.Student;

import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
public interface IStudentService {

    boolean addStudent(Student student);

    boolean deleteStudent(Student student);

    List getStudentByDepartment(Department department);

    List getStudentByClass(String clazz);
}
