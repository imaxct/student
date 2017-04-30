package imaxct.controller

import imaxct.service.IAdminService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.SessionAttributes
import org.springframework.web.servlet.ModelAndView
import javax.annotation.Resource
import javax.servlet.http.HttpSession

/**
 * Created by imaxct on 17-4-30.
 * student
 */
@Controller
@RequestMapping("/A")
@SessionAttributes("admin")
class AdminController {

    @Resource
    var adminService: IAdminService? = null

    @RequestMapping(value = "/main")
    fun main(){

    }

    @RequestMapping(value = "/login", method = arrayOf(RequestMethod.POST))
    fun login(u: String, p: String, session: HttpSession): ModelAndView{
        val mav = ModelAndView("admin/msg")
        val admin = adminService!!.login(u, p)
        if (admin != null){
            mav.viewName = "redirect:main"
            session.setAttribute("admin", admin)
            mav.addObject("admin", admin)
            return mav
        }
        mav.addObject("msg", "登录失败")
        return mav
    }
}