package imaxct.dao.impl

import imaxct.dao.IAdminDao
import imaxct.domain.Admin
import org.springframework.stereotype.Repository

/**
 * Created by imaxct on 17-4-26.
 * student
 */
@Repository
class AdminDaoImpl : BaseDao<Admin>(), IAdminDao {
    override fun getAdminByUP(u: String, p: String): Admin?
            = this.uniqueResult("from Admin where username=? and password=?", u, p)

    override fun createAdmin(admin: Admin): Boolean = this.create(admin)

    override fun updateAdmin(admin: Admin): Boolean = this.update(admin)

    override fun deleteAdmin(admin: Admin): Boolean = this.delete(admin)

    override fun getAdminByUsername(u: String): Admin? = this.uniqueResult("from Admin where username = ?", u)
}