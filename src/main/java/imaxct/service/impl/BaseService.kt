package imaxct.service.impl

import imaxct.dao.*

import javax.annotation.Resource

/**
 * Created by imaxct on 17-4-15.
 */
open class BaseService {

    @Resource
    protected var courseDao: ICourseDao? = null

    @Resource
    protected var userDao: IUserDao? = null

    @Resource
    protected var selectionDao: ISelectionDao? = null

    @Resource
    protected var adminDao: IAdminDao? = null
}
