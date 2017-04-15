package imaxct.dao.impl;

import imaxct.dao.IStudentCourseDao;
import imaxct.domain.Course;
import imaxct.domain.Student;
import imaxct.domain.StudentCourse;
import imaxct.domain.StudentCoursePK;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
@Repository
public class StudentCourseDaoImpl extends BaseDao<StudentCourse> implements IStudentCourseDao{

    public boolean addStudentCourse(StudentCourse studentCourse) {
        return this.create(studentCourse);
    }

    public boolean deleteStudentCourse(StudentCourse studentCourse) {
        return this.delete(studentCourse);
    }

    public boolean updateStudentCourse(StudentCourse studentCourse) {
        return this.update(studentCourse);
    }

    public List<StudentCourse> getCourseByStudent(final Student student) {
        return this.execute("from StudentCourse where pk.sid=?", student);
    }

    public List<StudentCourse> getStudentByCourse(final Course course) {
        return this.execute("from StudentCourse where pk.cid=?", course);
    }

    public List<StudentCourse> getAllStudentCourse() {
        return this.execute("from StudentCourse");
    }

    public List<StudentCourse> getCurTermCourse(Student student) {
        return this.execute("from StudentCourse where pk.sid=? and score=0", student);
    }

    public StudentCourse getByPK(Student student, Course course) {
        final StudentCoursePK pk = new StudentCoursePK(student, course);
        return this.uniqueResult("from StudentCourse where pk=?", pk);
    }

    public StudentCourse getByPK(StudentCoursePK pk) {
        return this.find(StudentCourse.class, pk);
    }

    public StudentCourse getBySchedule(Student student, int dayOrder, int courseOrder) {
        return this.uniqueResult("from StudentCourse where pk.sid=? and pk.cid.dayOrder=? and pk.cid.courseOrder=?",
                student, dayOrder, courseOrder);
    }
}
