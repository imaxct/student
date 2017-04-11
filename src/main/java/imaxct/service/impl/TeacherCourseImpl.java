package imaxct.service.impl;

import imaxct.dao.ITeacherCourseDao;
import imaxct.domain.Course;
import imaxct.domain.Teacher;
import imaxct.domain.TeacherCourse;
import imaxct.service.ITeacherCourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
@Service
public class TeacherCourseImpl implements ITeacherCourseService {

    @Resource
    private ITeacherCourseDao teacherCourseDao;

    public boolean addTeacherCourse(TeacherCourse teacherCourse) {
        return teacherCourseDao.addTeacherCourse(teacherCourse);
    }

    public boolean deleteTeacherCourse(TeacherCourse teacherCourse) {
        return teacherCourseDao.deleteTeacherCourse(teacherCourse);
    }

    public List getTeacherByCourse(Course course) {
        return teacherCourseDao.getTeacherByCourse(course);
    }

    public List getCourseByTeacher(Teacher teacher) {
        return teacherCourseDao.getCourseByTeacher(teacher);
    }
}
