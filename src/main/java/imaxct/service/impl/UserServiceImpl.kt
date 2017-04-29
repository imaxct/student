package imaxct.service.impl

import imaxct.bean.Msg
import imaxct.domain.Course
import imaxct.domain.User
import imaxct.service.IUserService
import imaxct.util.Util
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
open class UserServiceImpl : BaseService(), IUserService {
    override fun getUserById(id: Int): User = this.userDao!!.getUserById(id)

    override fun updateInfo(user: User): Msg<*> =
            if (this.userDao!!.updateUser(user)) Msg(0, "", null) else Msg<Int>("更新失败.")

    override fun selectCourse(course: Course, user: User): Msg<*> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deSelectCourse(course: Course, user: User): Msg<*> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun login(stuNo: String, password: String): Msg<User> {
        val user = this.userDao!!.getUserByStuNo(stuNo)
        if (user == null) {
            val msg = Util.verify(stuNo, password)
            if (msg.code == 0) {
                val nUser = msg.obj
                if (this.userDao!!.createUser(nUser!!)) {
                    return Msg(0, nUser)
                } else {
                    return Msg("非首次登录, 请使用身份证号.")
                }
            } else {
                return Msg("登录失败.")
            }
        } else if (user.idNo == password) {
            return Msg(0, user)
        }
        else {
            return Msg("密码错误")
        }
    }

    override fun list(): Msg<List<User>> = Msg(0, "ok", this.userDao!!.getAllUsers())
}
