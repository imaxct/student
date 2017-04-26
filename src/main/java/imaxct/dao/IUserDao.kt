package imaxct.dao

import imaxct.domain.User

/**
 * Created by imaxct on 17-4-6.
 */
interface IUserDao {
    fun createUser(user: User): Boolean
    fun getUserById(id: Int): User
    fun getUserByStuNo(stuNo: String): User
    fun getAllUsers(): List<User>
}
