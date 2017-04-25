package imaxct.service.impl;

import imaxct.bean.Msg;
import imaxct.domain.Course;
import imaxct.domain.Student;
import imaxct.domain.StudentCourse;
import imaxct.domain.StudentCoursePK;
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

    public Msg<List<StudentCourse>> getSchedule(Student student) {
        return new Msg<List<StudentCourse>>(0, "ok", this.studentCourseDao.getCurTermCourse(student));
    }

    public Msg addCourse(Student student, Course course) {
        return null;
    }

    public Msg deleteCourse(Student student, Course course) {
        StudentCoursePK pk = new StudentCoursePK(student, course);
        StudentCourse sc = this.studentCourseDao.getByPK(pk);
        if (sc.getScore() != 0){
            return new Msg("无法删除!");
        }else {
            if (this.studentCourseDao.deleteStudentCourse(sc)){
                return new Msg(0, "删除成功");
            }else {
                return new Msg("删除失败, 请稍后再试.");
            }
        }
    }

    public Msg<List<StudentCourse>> getScore(Student student) {
        List<StudentCourse> list = this.studentCourseDao.getCourseByStudent(student);
        return new Msg<List<StudentCourse>>(0, "ok", list);
    }
}
