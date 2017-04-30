package imaxct.interceptor

import imaxct.dao.ISettingDao
import imaxct.util.AppConst
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by imaxct on 17-4-30.
 * student
 */
class SettingInterceptor :HandlerInterceptor {
    @Resource
    val settingDao: ISettingDao? = null

    override fun preHandle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?): Boolean {
        val s = settingDao!!.getSettingByName(AppConst.OPEN)
        if (s == null || s.value== "0"){
            response!!.writer.println("<h1>site closed</h1>")
            return false
        }else return true
    }

    override fun postHandle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?, modelAndView: ModelAndView?) {
    }

    override fun afterCompletion(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?, ex: Exception?) {
    }
}