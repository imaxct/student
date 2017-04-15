package imaxct.service.impl;

import imaxct.domain.Course;
import imaxct.domain.Student;
import imaxct.service.IStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
@Service
@Transactional
public class StudentServiceImpl extends BaseService implements IStudentService {

    public List<Course> getSchedule(Student student) {
        return null;
    }

    public boolean addCourse(Course course) {
        return false;
    }

    public boolean deleteCourse(Course course) {
        return false;
    }

    public List<Course> getScore(Student student) {
        return null;
    }
}
