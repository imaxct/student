package imaxct.interceptor

import imaxct.domain.User
import org.springframework.web.servlet.mvc.WebContentInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by imaxct on 17-4-26.
 * student
 */
class InfoInterceptor : WebContentInterceptor() {

    override fun preHandle(request: HttpServletRequest?,
                           response: HttpServletResponse?, handler: Any?): Boolean {
        val user: User = request!!.getAttribute("user") as User
        val flag: Boolean = user.campus.isNullOrBlank() || user.grade.isNullOrBlank()
                || user.idNo.isNullOrBlank() || user.name.isNullOrBlank()
                || user.sex.isNullOrBlank() || user.stuNo.isNullOrBlank()
        if (flag) {
            response!!.sendRedirect("/student/")
            return false
        }
        return true
    }

}