package imaxct.controller;

import imaxct.service.ITeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by maxct on 2017/4/9.
 */
@Controller
@RequestMapping("/T")
public class TeacherController {

    @Resource
    private ITeacherService teacherService;
}
