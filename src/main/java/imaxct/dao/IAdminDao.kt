package imaxct.dao

import imaxct.domain.Admin

/**
 * Created by imaxct on 17-4-26.
 * student
 */
interface IAdminDao {
    fun getAdminByUsername(u: String): Admin?

    fun createAdmin(admin: Admin): Boolean

    fun updateAdmin(admin: Admin): Boolean

    fun deleteAdmin(admin: Admin): Boolean
}