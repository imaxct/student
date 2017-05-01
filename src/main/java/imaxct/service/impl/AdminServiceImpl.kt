package imaxct.service.impl

import imaxct.domain.Admin
import imaxct.domain.User
import imaxct.service.IAdminService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by imaxct on 17-4-30.
 * student
 */
@Service
@Transactional
open class AdminServiceImpl: BaseService(), IAdminService {
    override fun addUsers(list: MutableList<User>): Boolean = this.userDao!!.addUsers(list)

    override fun login(u: String, p: String): Admin? = this.adminDao!!.getAdminByUP(u, p)
}