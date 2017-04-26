package imaxct.interceptor

import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession

class AuthInterceptor : HandlerInterceptor {
    @Throws(Exception::class)
    override fun preHandle(httpServletRequest: HttpServletRequest,
                           httpServletResponse: HttpServletResponse, o: Any): Boolean {
        val session = httpServletRequest.session
        if (session.getAttribute("user") == null && httpServletRequest.getAttribute("user") == null) {
            httpServletResponse.sendRedirect("/student/")
            return false
        } else {
            return true
        }
    }

    @Throws(Exception::class)
    override fun postHandle(httpServletRequest: HttpServletRequest,
                            httpServletResponse: HttpServletResponse, o: Any, modelAndView: ModelAndView) {

    }

    @Throws(Exception::class)
    override fun afterCompletion(httpServletRequest: HttpServletRequest,
                                 httpServletResponse: HttpServletResponse, o: Any, e: Exception) {

    }
}
