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
        StudentCoursePK pk = new StudentCoursePK(student, course);
        StudentCourse sc ;
        sc = this.studentCourseDao.getBySchedule(course.getDayOrder(), course.getCourseOrder());
        if (sc != null){
            return new Msg("与 " + sc.getPk().getCid().getName() + " 冲突");
        }
        sc = this.studentCourseDao.getByPK(pk);
        if (sc != null){
            return new Msg("已经选过这门课了");
        }
        Course rc = this.courseDao.getById(course.getId());
        if (rc.getTotal() < rc.getCapacity()){
            rc.setTotal(rc.getTotal() + 1);
            sc = new StudentCourse();
            sc.setPk(pk);
            if (this.studentCourseDao.addStudentCourse(sc)){
                return new Msg(0, "选课成功");
            }else {
                return new Msg("选课失败, 系统忙.");
            }
        }else {
            return new Msg("选课人数已满");
        }
    }

    public Msg deleteCourse(Student student, Course course) {
        return null;
    }

    public Msg<List<StudentCourse>> getScore(Student student) {
        return null;
    }
}
