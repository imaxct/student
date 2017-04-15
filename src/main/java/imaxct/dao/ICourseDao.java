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

    List<Course> getCourseByName(String name);

    List<Course> getAllCourses();

    Course getById(int id);

    List<Course> getFromId(int id);
}
