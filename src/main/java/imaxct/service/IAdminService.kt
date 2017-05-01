package imaxct.service

import imaxct.domain.Admin
import imaxct.domain.User

/**
 * Created by imaxct on 17-4-30.
 * student
 */
interface IAdminService {
    fun login(u: String, p: String): Admin?

    fun addUsers(list: MutableList<User>): Boolean
}