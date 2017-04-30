package imaxct.service.impl

import imaxct.domain.Admin
import imaxct.service.IAdminService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by imaxct on 17-4-30.
 * student
 */
@Service
@Transactional
class AdminServiceImpl: BaseService(), IAdminService {
    override fun login(u: String, p: String): Admin? = this.adminDao!!.getAdminByUP(u, p)
}