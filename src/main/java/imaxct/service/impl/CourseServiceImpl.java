package imaxct.service.impl;

import imaxct.domain.Course;
import imaxct.service.ICourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
@Service
@Transactional
public class CourseServiceImpl extends BaseService implements ICourseService {

    public boolean addCourse(Course course) {
        return courseDao.addCourse(course);
    }

    public boolean deleteCourse(Course course) {
        return courseDao.deleteCourse(course);
    }

    public List<Course> getAllCourses(int id) {
        if (id == -1)
            return this.courseDao.getAllCourses();
        return courseDao.getCourseFromId(id);
    }

}
