package imaxct.controller

import imaxct.bean.Msg
import imaxct.domain.User
import imaxct.service.IUserService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.SessionAttributes
import org.springframework.web.servlet.ModelAndView
import javax.annotation.Resource
import javax.servlet.http.HttpSession

@Controller
@RequestMapping(value = "/User")
@SessionAttributes("user")
class UserController {

    @Resource
    private val userService: IUserService? = null


    @RequestMapping(value = "/main")
    fun main(): String {
        return "main"
    }

    @RequestMapping(value = "/fillInfo", method = arrayOf(RequestMethod.GET))
    fun infoFront(session: HttpSession): ModelAndView {
        val mav = ModelAndView("fillInfo")
        val user: User = session.getAttribute("user") as User
        val u: User = userService!!.getUserById(user.id)
        mav.addObject("USER", u)
        return mav
    }

    @ResponseBody
    @RequestMapping(value = "/fillInfo", method = arrayOf(RequestMethod.POST))
    fun fillInfo(u: User, session: HttpSession): Msg<*> {
        val user : User = session.getAttribute("user") as User
        if (u.campus != null) user.campus = u.campus
        if (u.phone != null) user.phone = u.phone
        if (u.qq != null) user.qq = u.qq
        if (u.email != null) user.email = u.email
        val msg = userService!!.updateInfo(user)
        session.setAttribute("user", user)
        return msg
    }

    @RequestMapping(value = "/login", method = arrayOf(RequestMethod.POST))
    fun login(username: String, password: String, httpSession: HttpSession): ModelAndView {
        val msg = userService!!.login(username, password)
        println(msg)
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

}
