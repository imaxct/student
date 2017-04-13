package imaxct.service.impl;

import imaxct.dao.IStudentCourseDao;
import imaxct.domain.Course;
import imaxct.domain.Student;
import imaxct.domain.StudentCourse;
import imaxct.service.IStudentCourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
@Service
@Transactional
public class StudentCourseServiceImpl implements IStudentCourseService {

    @Resource
    private IStudentCourseDao studentCourseDao;

    public boolean addStudentCourse(StudentCourse studentCourse) {
        return studentCourseDao.addStudentCourse(studentCourse);
    }

    public boolean deleteStudentCourse(StudentCourse studentCourse) {
        return studentCourseDao.deleteStudentCourse(studentCourse);
    }

    public List getCourseByStudent(Student student) {
        return studentCourseDao.getCourseByStudent(student);
    }

    public List getStudentByCourse(Course course) {
        return studentCourseDao.getStudentByCourse(course);
    }
}
