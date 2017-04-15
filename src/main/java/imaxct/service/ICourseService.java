package imaxct.service;

import imaxct.domain.Course;

import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
public interface ICourseService {
    boolean addCourse(Course course);

    boolean deleteCourse(Course course);

    /**
     * id : -1 all
     * */
    List<Course> getAllCourses(int id);

    List<Course> getCourseByName(String name);
}
