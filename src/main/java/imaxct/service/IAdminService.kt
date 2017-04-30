package imaxct.service

import imaxct.domain.Admin

/**
 * Created by imaxct on 17-4-30.
 * student
 */
interface IAdminService {
    fun login(u: String, p: String): Admin?
}