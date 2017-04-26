package imaxct.controller

import imaxct.domain.User
import imaxct.service.IUserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
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
    fun completeInfo(user: User): String {
        return "fillInfo"
    }

    @RequestMapping(value = "/login", method = arrayOf(RequestMethod.POST))
    fun login(username: String, password: String, httpSession: HttpSession): ModelAndView {
        val msg = userService!!.login(username, password)
        println(msg)
        val modelAndView: ModelAndView
        if (msg.code !=0 && msg.code != 1) {
            modelAndView = ModelAndView("msg")
            modelAndView.addObject("msg", "登陆失败")
        } else {
            modelAndView = ModelAndView("redirect:main")
            modelAndView.addObject("user", msg.obj)
            httpSession.setAttribute("user", msg.obj)
        }
        return modelAndView
    }

}
