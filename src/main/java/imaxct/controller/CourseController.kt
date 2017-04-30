package imaxct.controller

import imaxct.bean.Msg
import imaxct.domain.Course
import imaxct.domain.User
import imaxct.service.ICourseService
import imaxct.service.IUserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView
import javax.annotation.Resource
import javax.servlet.http.HttpSession

@Controller
@RequestMapping("/C")
class CourseController {

    @Resource
    private val courseService: ICourseService? = null

    @Resource
    private val userService: IUserService? = null

    @RequestMapping(value = "/list")
    fun listAll(@RequestParam(required = false, defaultValue = "-1") id: String): ModelAndView {
        val modelAndView = ModelAndView("courseList")
        val nid = Integer.valueOf(id)
        val msg: Msg<*> = courseService!!.getAllCourses(nid)
        modelAndView.addObject("list", msg.obj)
        return modelAndView
    }

    @RequestMapping(value = "/chosen")
    fun listChosen(session: HttpSession): ModelAndView{
        val mav = ModelAndView("myCourses")
        val u: User = session.getAttribute("user") as User
        val list = userService!!.getCourseByUser(u)
        mav.addObject("list", list)
        return mav
    }

    @ResponseBody
    @RequestMapping(value = "/choose", method = arrayOf(RequestMethod.POST))
    fun chooseCourse(id: Int, session: HttpSession): Msg<*>{
        val course: Course = courseService!!.getCourseById(id) ?: return Msg(-1, "课程不存在", null)
        val user: User = session.getAttribute("user") as User
        return userService!!.selectCourse(course, user)
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = arrayOf(RequestMethod.POST))
    fun unChooseCourse(id: Int, session: HttpSession): Msg<*>{
        val course: Course = courseService!!.getCourseById(id) ?: return Msg(-1, "课程不存在", null)
        val user: User = session.getAttribute("user") as User
        return userService!!.deSelectCourse(course, user)
    }
}
