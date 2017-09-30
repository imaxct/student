package imaxct.controller

import imaxct.bean.Msg
import imaxct.domain.Course
import imaxct.domain.User
import imaxct.service.ICourseService
import imaxct.service.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpSession

@Controller
@RequestMapping("/C")
class CourseController {

    @Autowired
    private lateinit var courseService: ICourseService

    @Autowired
    private lateinit var userService: IUserService

    @GetMapping(value = "/list")
    fun listAll(@RequestParam(required = false, defaultValue = "-1") id: String): ModelAndView {
        val modelAndView = ModelAndView("courseList")
        val nid = Integer.valueOf(id)
        val msg: Msg<*> = courseService.getAllCourses(nid)
        modelAndView.addObject("list", msg.obj)
        return modelAndView
    }

    @GetMapping(value = "/chosen")
    fun listChosen(session: HttpSession): ModelAndView {
        val mav = ModelAndView("myCourses")
        val u: User = session.getAttribute("user") as User
        val list = userService.getCourseByUser(u)
        mav.addObject("list", list)
        return mav
    }

    @ResponseBody
    @PostMapping(value = "/choose")
    fun chooseCourse(id: Int, session: HttpSession): Msg<*> {
        val course: Course = courseService.getCourseById(id) ?: return Msg(-1, "课程不存在", null)
        val user: User = session.getAttribute("user") as User
        return userService.selectCourse(course, user)
    }

    @ResponseBody
    @PostMapping(value = "/delete")
    fun unChooseCourse(id: Int, session: HttpSession): Msg<*> {
        val course: Course = courseService.getCourseById(id) ?: return Msg(-1, "课程不存在", null)
        val user: User = session.getAttribute("user") as User
        return userService.deSelectCourse(course, user)
    }
}
