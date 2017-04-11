package imaxct.dao;

import imaxct.domain.Course;
import imaxct.domain.Teacher;
import imaxct.domain.TeacherCourse;

import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
public interface ITeacherCourseDao {
    boolean addTeacherCourse(TeacherCourse teacherCourse);

    boolean deleteTeacherCourse(TeacherCourse teacherCourse);

    List getTeacherByCourse(Course course);

    List getCourseByTeacher(Teacher teacher);
}
