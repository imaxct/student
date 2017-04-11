package imaxct.service.impl;

import imaxct.dao.ITeacherDao;
import imaxct.domain.Department;
import imaxct.domain.Teacher;
import imaxct.service.ITeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
@Service
public class TeacherServiceImpl implements ITeacherService {

    @Resource
    private ITeacherDao teacherDao;
    public boolean addTeacher(Teacher teacher) {
        return teacherDao.addTeacher(teacher);
    }

    public boolean deleteTeacher(Teacher teacher) {
        return teacherDao.deleteTeacher(teacher);
    }

    public boolean updateTeacher(Teacher teacher) {
        return teacherDao.updateTeacher(teacher);
    }

    public List getTeacherByDepartment(Department department) {
        return teacherDao.getTeacherByDepartment(department);
    }

    public Teacher getTeacherById(String tid) {
        return teacherDao.getTeacherById(tid);
    }

    public Teacher getTeacherByName(String name) {
        return teacherDao.getTeacherByName(name);
    }
}
