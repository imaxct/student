package imaxct.service.impl

import imaxct.bean.Msg
import imaxct.domain.Course
import imaxct.domain.SelectPK
import imaxct.domain.Selection
import imaxct.domain.User
import imaxct.service.IUserService
import imaxct.util.Util
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
open class UserServiceImpl : BaseService(), IUserService {
    override fun getCourseByUser(user: User): List<Selection> = this.selectionDao!!.getSelectionByUser(user)

    override fun getUserById(id: Int): User = this.userDao!!.getUserById(id)

    override fun updateInfo(user: User): Msg<*> =
            if (this.userDao!!.updateUser(user)) Msg(0, "", null) else Msg<Int>("更新失败.")

    override fun selectCourse(course: Course, user: User): Msg<*> {
        if (course.endDate != null && course.endDate!!.before(Date())){
            return Msg(-1, "课程已截止报名", null)
        }
        if (course.restrict == 1 && !user.poor){
            return Msg(-1, "非贫困生, 不能报名", null)
        }
        if (course.restrict == -1 && user.poor){
            return Msg(-1, "仅非贫困生可报", null)
        }
        if (!course.gradeLimit.isNullOrBlank() && !course.gradeLimit!!.contains(user.grade!!)){
            return Msg(-1, "你所在的年级不能报名", null)
        }
        if (course.occupied >= course.capacity){
            return Msg(-1, "报名人数已满", null)
        }
        val sid: SelectPK = SelectPK(user, course)
        if (selectionDao!!.getSelectionById(sid) != null){
            return Msg(-1, "已经选过这门课了", null)
        }
        course.occupied = course.occupied + 1
        val s: Selection = Selection(sid)
        if (courseDao!!.updateCourse(course) && selectionDao!!.createSelection(s)){
            return Msg(0, "选课成功", null)
        }else {
            return Msg(-1, "系统忙, 稍后再试", null)
        }
    }

    /**
     * 取消选课
     * */
    override fun deSelectCourse(course: Course, user: User): Msg<*> {
        val sid = SelectPK(user, course)
        val s = selectionDao!!.getSelectionById(sid) ?: return Msg(-1, "删除失败", null)
        course.occupied = course.occupied - 1
        if (courseDao!!.updateCourse(course) && selectionDao!!.deleteSelection(s)){
            return Msg(0, "退课成功", null)
        }else{
            return Msg(-1, "操作失败", null)
        }
    }

    override fun login(stuNo: String, password: String): Msg<User> {
        val user: User? = this.userDao!!.getUserByStuNo(stuNo)
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
