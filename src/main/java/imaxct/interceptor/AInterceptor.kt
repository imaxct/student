package imaxct.interceptor

import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by imaxct on 17-4-30.
 * student
 */
class AInterceptor : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?): Boolean {
        return if (request!!.session.getAttribute("admin") == null) {
            response!!.sendRedirect("/student/admin.jsp")
            false
        } else true
    }

    override fun postHandle(request: HttpServletRequest?, response: HttpServletResponse?,
                            handler: Any?, modelAndView: ModelAndView?) {
    }

    override fun afterCompletion(request: HttpServletRequest?, response: HttpServletResponse?,
                                 handler: Any?, ex: Exception?) {
    }
}