package imaxct.dao.impl;

import imaxct.dao.IStudentCourseDao;
import imaxct.domain.Course;
import imaxct.domain.Student;
import imaxct.domain.StudentCourse;
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

    public List getCourseByStudent(final Student student) {
        return this.execute("from StudentCourse where sid=?", student);
    }

    public List getStudentByCourse(final Course course) {
        return this.execute("from StudentCourse where cid=?", course);
    }

    public List getAllStudentCourse() {
        return this.execute("from StudentCourse");
    }
}
