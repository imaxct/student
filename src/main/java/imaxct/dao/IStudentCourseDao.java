package imaxct.dao;

import imaxct.domain.Course;
import imaxct.domain.Student;
import imaxct.domain.StudentCourse;

import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
public interface IStudentCourseDao {
    boolean addStudentCourse(StudentCourse studentCourse);

    boolean deleteStudentCourse(StudentCourse studentCourse);

    boolean updateStudentCourse(StudentCourse studentCourse);

    List getCourseByStudent(Student student);

    List getStudentByCourse(Course course);

    List getAllStudentCourse();
}
