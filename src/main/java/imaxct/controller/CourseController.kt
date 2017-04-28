package imaxct.controller

import imaxct.bean.Msg
import imaxct.service.ICourseService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import javax.annotation.Resource

@Controller
@RequestMapping("/C")
class CourseController {

    @Resource
    private val courseService: ICourseService? = null

    @RequestMapping(value = "/list")
    fun listAll(@RequestParam(required = false, defaultValue = "-1") id: String): ModelAndView {
        val modelAndView = ModelAndView("courseList")
        val nid = Integer.valueOf(id)
        val msg: Msg<*> = courseService!!.getAllCourses(nid)
        modelAndView.addObject("list", msg.obj)
        return modelAndView
    }

}
