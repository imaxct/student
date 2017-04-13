package imaxct.controller;

import imaxct.domain.Course;
import imaxct.service.ICourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by maxct on 2017/4/9.
 */
@RestController
@RequestMapping("/C")
public class CourseController {

    @Resource
    private ICourseService courseService;

    @RequestMapping(value = "/test")
    public String test(){
        Course course = new Course();
        course.setCid("1234");
        course.setName("name-1");
        course.setCredit(5.5d);
        boolean flag = courseService.addCourse(course);
        return "" + flag;
    }
}
