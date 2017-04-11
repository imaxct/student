package imaxct.dao;

import imaxct.domain.Department;
import imaxct.domain.Teacher;

import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
public interface ITeacherDao {
    boolean addTeacher(Teacher teacher);

    boolean deleteTeacher(Teacher teacher);

    boolean updateTeacher(Teacher teacher);

    List getTeacherByDepartment(Department department);

    Teacher getTeacherById(String tid);

    Teacher getTeacherByName(String name);
}
