package imaxct.service.impl;

import imaxct.dao.ICourseDao;
import imaxct.domain.Course;
import imaxct.service.ICourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CourseServiceImpl extends BaseService implements ICourseService {

    @Resource
    private ICourseDao courseDao;

    public boolean addCourse(Course course) {
        return courseDao.addCourse(course);
    }

    public boolean deleteCourse(Course course) {
        return courseDao.deleteCourse(course);
    }

    public List getAllCourses() {
        return courseDao.getAllCourses();
    }

    public List getCourseByName(String name) {
        return courseDao.getCourseByName(name);
    }
}
