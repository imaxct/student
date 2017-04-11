package imaxct.dao;

import imaxct.domain.Course;

import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
public interface ICourseDao {
    boolean addCourse(Course course);

    boolean deleteCourse(Course course);

    boolean updateCourse(Course course);

    List getCourseByName(String name);

    List getAllCourses();
    
}
