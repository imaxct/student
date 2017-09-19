package imaxct.service.impl

import imaxct.dao.*

import javax.annotation.Resource

/**
 * Created by imaxct on 17-4-15.
 */
open class BaseService {

    @Resource
    protected lateinit var courseDao: ICourseDao

    @Resource
    protected lateinit var userDao: IUserDao

    @Resource
    protected lateinit var selectionDao: ISelectionDao

    @Resource
    protected lateinit var adminDao: IAdminDao
}
