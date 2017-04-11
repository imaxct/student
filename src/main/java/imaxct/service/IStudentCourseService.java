package imaxct.service;

import imaxct.domain.Course;
import imaxct.domain.Student;
import imaxct.domain.StudentCourse;

import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
public interface IStudentCourseService {
    boolean addStudentCourse(StudentCourse studentCourse);

    boolean deleteStudentCourse(StudentCourse studentCourse);

    List getCourseByStudent(Student student);

    List getStudentByCourse(Course course);
}
