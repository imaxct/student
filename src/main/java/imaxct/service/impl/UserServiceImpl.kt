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
    override fun selectCourse(course: Course, user: User): Msg<*> {
        TODO("nnn")
    }

    override fun deSelectCourse(course: Course, user: User): Msg<*> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun login(stuNo: String, password: String): Msg<User> {
        val user = this.userDao!!.getUserByStuNo(stuNo)
        if (user == null) {
            return Msg("用户不存在")
        } else if (user.idNo == password) {
            return Msg(0, user)
        }
        else {
            val msg = Util.verify(stuNo, password)
            if (msg.code == 0) {
                val nUser = msg.obj
                if (this.userDao!!.createUser(nUser!!)) {
                    return Msg(1, nUser)
                } else {
                    return Msg("非首次登录, 请使用身份证号.")
                }
            } else {
                return Msg("登录失败.")
            }
        }
    }

    override fun list(): Msg<List<User>> {
        return Msg(0, "ok", this.userDao!!.getAllUsers())
    }
}
