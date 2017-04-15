package imaxct.dao;

import imaxct.domain.Course;
import imaxct.domain.Student;
import imaxct.domain.StudentCourse;
import imaxct.domain.StudentCoursePK;

import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
public interface IStudentCourseDao {
    boolean addStudentCourse(StudentCourse studentCourse);

    boolean deleteStudentCourse(StudentCourse studentCourse);

    boolean updateStudentCourse(StudentCourse studentCourse);

    List<StudentCourse> getCourseByStudent(Student student);

    List<StudentCourse> getStudentByCourse(Course course);

    List<StudentCourse> getAllStudentCourse();

    List<StudentCourse> getCurTermCourse(Student student);

    StudentCourse getByPK(Student student, Course course);

    StudentCourse getByPK(StudentCoursePK pk);

    StudentCourse getBySchedule(int dayOrder, int courseOrder);
}
