package imaxct.dao.impl

import imaxct.dao.IUserDao
import imaxct.domain.User
import org.springframework.stereotype.Repository


/**
 * Created by imaxct on 17-4-6.
 */

@Repository
class UserDaoImpl : BaseDao<User>(), IUserDao {

    override fun createUser(user: User): Boolean {
        return this.create(user)
    }

    override fun getUserById(id: Int): User {
        return this.find(User::class.java, id)
    }

    override fun getUserByStuNo(stuNo: String): User {
        return this.uniqueResult("from User where stuNo = ?", stuNo)
    }

    override fun getAllUsers(): List<User> {
        return this.listPage(0, 500, "from User")
    }
}
