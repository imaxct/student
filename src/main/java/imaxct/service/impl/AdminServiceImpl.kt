package imaxct.service.impl

import imaxct.bean.Msg
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
    override fun clearAllRecord(): Msg<*> {
        val s = this.selectionDao!!.clearAllSelection()
        val u = this.userDao!!.clearAllUser()
        return Msg(0, "删除了 $s 条选课数据, $u 条用户数据.", null)
    }

    override fun addUsers(list: MutableList<User>): Boolean = this.userDao!!.addUsers(list)

    override fun login(u: String, p: String): Admin? = this.adminDao!!.getAdminByUP(u, p)
}