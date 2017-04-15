package imaxct.dao.impl;

import imaxct.domain.Course;
import imaxct.domain.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
@Repository
public class TeacherCourseDaoImpl extends BaseDao<TeacherCourse> implements ITeacherCourseDao {

    public boolean addTeacherCourse(TeacherCourse teacherCourse) {
        return this.create(teacherCourse);
    }

    public boolean deleteTeacherCourse(TeacherCourse teacherCourse) {
        return this.delete(teacherCourse);
    }

    public List getTeacherByCourse(final Course course) {
        return this.execute("from TeacherCourse where pk.cid=?", course);
    }

    public List getCourseByTeacher(final Teacher teacher) {
        return this.execute("from TeacherCourse where pk.tid=?", teacher);
    }
}
