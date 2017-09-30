package imaxct.controller

import imaxct.bean.Msg
import imaxct.dao.ISettingDao
import imaxct.domain.User
import imaxct.service.IUserService
import imaxct.util.AppConst
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import javax.annotation.Resource
import javax.servlet.http.HttpSession

@Controller
@RequestMapping(value = "/User")
class UserController {

    @Autowired
    private lateinit var userService: IUserService

    @Autowired
    private lateinit var settingDao: ISettingDao


    @GetMapping(value = "/main")
    fun main(): String = "main"

    @GetMapping(value = "/fillInfo")
    fun infoFront(session: HttpSession): ModelAndView {
        val mav = ModelAndView("fillInfo")
        val user: User = session.getAttribute("user") as User
        val u: User = userService.getUserById(user.id)
        mav.addObject("USER", u)
        return mav
    }

    @GetMapping(value = "/logout")
    fun logout(session: HttpSession): String {
        session.invalidate()
        return "redirect:/"
    }

    @ResponseBody
    @PostMapping(value = "/fillInfo")
    fun fillInfo(u: User, session: HttpSession): Msg<*> {
        val user: User = session.getAttribute("user") as User
        if (u.campus != null) user.campus = u.campus
        if (u.phone != null) user.phone = u.phone
        if (u.qq != null) user.qq = u.qq
        if (u.email != null) user.email = u.email
        val msg = userService.updateInfo(user)
        session.setAttribute("user", user)
        return msg
    }

    @PostMapping(value = "/login")
    fun login(username: String, password: String, httpSession: HttpSession): ModelAndView {
        val msg = userService.login(username, password)
        val modelAndView: ModelAndView
        if (msg.code != 0 && msg.code != 1) {
            modelAndView = ModelAndView("msg")
            modelAndView.addObject("msg", msg.msg)
        } else {
            modelAndView = ModelAndView("redirect:main")
            modelAndView.addObject("user", msg.obj)
            httpSession.setAttribute("user", msg.obj)
        }
        return modelAndView
    }

    @GetMapping(value = "/G")
    fun getDeclare(): ModelAndView {
        val mav = ModelAndView("declare")
        val d = settingDao.getSettingByName(AppConst.SETTING_DECLARE)
        mav.addObject("msg", d?.value ?: "暂无公告")
        return mav
    }
}
