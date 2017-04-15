package imaxct.service;

import imaxct.domain.Course;
import imaxct.domain.Student;

import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
public interface IStudentService {
    List<Course> getSchedule(Student student);

    boolean addCourse(Course course);

    boolean deleteCourse(Course course);

    List<Course> getScore(Student student);
}
