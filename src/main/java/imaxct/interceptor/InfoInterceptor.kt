package imaxct.interceptor

import imaxct.domain.User
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.mvc.WebContentInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by imaxct on 17-4-26.
 * student
 */
class InfoInterceptor : WebContentInterceptor() {

    override fun postHandle(request: HttpServletRequest?,
                            response: HttpServletResponse?, handler: Any?, modelAndView: ModelAndView?) {
        val user: User = request!!.session.getAttribute("user") as User
        val flag: Boolean = user.campus.isNullOrBlank() || user.grade.isNullOrBlank()
                || user.idNo.isNullOrBlank() || user.name.isNullOrBlank()
                || user.sex.isNullOrBlank() || user.stuNo.isNullOrBlank()
        if (flag) {
            if (modelAndView != null) {
                modelAndView.addObject("USER", user)
                modelAndView.viewName = "fillInfo"
            }
        }else super.postHandle(request, response, handler, modelAndView)
    }
}