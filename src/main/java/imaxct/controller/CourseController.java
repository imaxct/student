package imaxct.controller;

import imaxct.domain.Course;
import imaxct.service.ICourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
@Controller
@RequestMapping("/C")
public class CourseController {

    @Resource
    private ICourseService courseService;

    @RequestMapping(value = "/test")
    public String test(){
        Course course = new Course();
        course.setName("name-1");
        boolean flag = courseService.addCourse(course);
        return "" + flag;
    }

    @RequestMapping(value = "/list")
    public ModelAndView listAll(@RequestParam(required = false, defaultValue = "-1") String id){
        ModelAndView modelAndView = new ModelAndView("courseList");
        int nid = -1;
        if (id != null && !"-1".equals(id)){
            nid = Integer.valueOf(id);
        }
        List<Course> list = courseService.getAllCourses(nid);
        modelAndView.addObject("list", list);
        return modelAndView;
    }

}
