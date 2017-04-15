package imaxct.service.impl;

import imaxct.bean.Msg;
import imaxct.dao.ITeacherDao;
import imaxct.domain.Course;
import imaxct.domain.Department;
import imaxct.domain.StudentCourse;
import imaxct.domain.Teacher;
import imaxct.service.ITeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
@Service
@Transactional
public class TeacherServiceImpl extends BaseService implements ITeacherService {

    public Msg addCourse(Course course) {
        if (this.courseDao.addCourse(course)){
            return new Msg(0, "添加成功");
        }else {
            return new Msg("添加失败");
        }
    }

    public Msg rateStudentCourse(StudentCourse studentCourse, double score) {
        studentCourse.setScore(score);
        if (this.studentCourseDao.updateStudentCourse(studentCourse)){
            return new Msg(0, "更新成功");
        }else {
            return new Msg("更新失败");
        }
    }
}
