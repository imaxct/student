package imaxct.controller;

import com.google.gson.Gson;
import imaxct.bean.Msg;
import imaxct.domain.Course;
import imaxct.service.ICourseService;
import imaxct.service.ITeacherService;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by maxct on 2017/4/9.
 */
@Controller
@RequestMapping("/T")
public class TeacherController {

    @Resource
    private ITeacherService teacherService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCourse(Course course){
        Msg msg = teacherService.addCourse(course);
        return new Gson().toJson(msg);
    }
}
