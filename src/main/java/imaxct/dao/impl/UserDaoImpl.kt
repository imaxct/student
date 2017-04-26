package imaxct.dao.impl

import imaxct.dao.IUserDao
import imaxct.domain.User
import org.springframework.stereotype.Repository



@Repository
class UserDaoImpl : BaseDao<User>(), IUserDao {

    override fun createUser(user: User): Boolean = this.create(user)

    override fun getUserById(id: Int): User = this.find(User::class.java, id)

    override fun getUserByStuNo(stuNo: String): User = this.uniqueResult("from User where stuNo = ?", stuNo)

    override fun getAllUsers(): List<User> = this.listPage(0, 500, "from User")
}
