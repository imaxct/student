package imaxct.dao.impl;

import imaxct.dao.ITeacherDao;
import imaxct.domain.Department;
import imaxct.domain.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
@Repository
public class TeacherDaoImpl extends BaseDao<Teacher> implements ITeacherDao {

    public boolean addTeacher(Teacher teacher) {
        return this.create(teacher);
    }

    public boolean deleteTeacher(Teacher teacher) {
        return this.delete(teacher);
    }

    public boolean updateTeacher(Teacher teacher) {
        return this.update(teacher);
    }

    public List<Teacher> getTeacherByDepartment(final Department department) {
        return this.execute("from Teacher where dname=?", department);
    }

    public Teacher getTeacherById(int id) {
        return this.find(Teacher.class, id);
    }

    public Teacher getTeacherByTid(final String tid) {
        return this.uniqueResult("from Teacher where tid=?", tid);
    }

    public Teacher getTeacherByName(final String name) {
        return this.uniqueResult("from Teacher where name=?", name);
    }
}
