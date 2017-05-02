package imaxct.service

import imaxct.bean.Msg
import imaxct.domain.Admin
import imaxct.domain.Course
import imaxct.domain.Selection
import imaxct.domain.User

/**
 * Created by imaxct on 17-4-30.
 * student
 */
interface IAdminService {
    fun login(u: String, p: String): Admin?

    fun addUsers(list: MutableList<User>): Boolean

    fun clearAllRecord(): Msg<*>

    fun getCourses(): List<Course>

    fun getUserByCourse(course: Course): List<Selection>
}