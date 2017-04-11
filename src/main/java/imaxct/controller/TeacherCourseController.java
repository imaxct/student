package imaxct.controller;

import imaxct.service.ITeacherCourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by maxct on 2017/4/9.
 */
@Controller
@RequestMapping("/TC")
public class TeacherCourseController {

    @Resource
    private ITeacherCourseService teacherCourseService;
}
