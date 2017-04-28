package imaxct.interceptor

import imaxct.domain.User
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.mvc.WebContentInterceptor
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by imaxct on 17-4-26.
 * student
 */
class InfoInterceptor : HandlerInterceptor {


    override fun preHandle(request: HttpServletRequest?, response: HttpServletResponse?,
                           handler: Any?): Boolean {

        val user: User = request!!.session.getAttribute("user") as User
        val flag: Boolean = user.campus.isNullOrBlank() || user.grade.isNullOrBlank()
                || user.idNo.isNullOrBlank() || user.name.isNullOrBlank()
                || user.sex.isNullOrBlank() || user.stuNo.isNullOrBlank()

        if (flag) {
            request.setAttribute("USER", user)
            response!!.sendRedirect("/student/User/fillInfo")
            return false
        }else {
            return true
        }
    }

    override fun afterCompletion(request: HttpServletRequest?, response: HttpServletResponse?,
                                 handler: Any?, ex: Exception?) {
    }

    override fun postHandle(request: HttpServletRequest?, response: HttpServletResponse?,
                            handler: Any?, modelAndView: ModelAndView?) {
    }
}