package imaxct.service.impl;

import imaxct.dao.*;

import javax.annotation.Resource;

/**
 * Created by imaxct on 17-4-15.
 */
public class BaseService {

    @Resource
    protected ICourseDao courseDao;

    @Resource
    protected IDepartmentDao departmentDao;

    @Resource
    protected IStudentCourseDao studentCourseDao;

    @Resource
    protected IStudentDao studentDao;

    @Resource
    protected ITeacherDao teacherDao;

    @Resource
    protected IUserDao userDao;
}
