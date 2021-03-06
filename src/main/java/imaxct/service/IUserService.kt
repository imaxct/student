package imaxct.service

import imaxct.bean.Msg
import imaxct.domain.Course
import imaxct.domain.Selection
import imaxct.domain.User

/**
 * Created by imaxct on 17-4-6.
 */
interface IUserService {

    fun login(stuNo: String, password: String): Msg<User>

    fun list(): Msg<List<User>>

    fun selectCourse(course: Course, user: User): Msg<*>

    fun deSelectCourse(course: Course, user: User): Msg<*>

    fun updateInfo(user: User): Msg<*>

    fun getUserById(id: Int): User

    fun getCourseByUser(user: User): List<Selection>
}
