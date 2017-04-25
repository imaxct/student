package imaxct.controller;

import com.google.gson.Gson;
import imaxct.bean.Msg;
import imaxct.domain.User;
import imaxct.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by imaxct on 17-4-6.
 */
@Controller
@RequestMapping(value = "/User")
@SessionAttributes({"user"})
public class UserController {

    @Resource
    private IUserService userService;

    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        return new Gson().toJson(userService.list());
    }

    @RequestMapping(value = "/main")
    public String main(){
        return "main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String username, String password, HttpSession httpSession){
        Msg<User> msg = userService.login(username, password);
        System.out.println(msg);
        ModelAndView modelAndView;
        if (msg.getCode() != 0){
            modelAndView = new ModelAndView("msg");
            modelAndView.addObject("msg", "登陆失败");
        }else {
            modelAndView = new ModelAndView("redirect:main");
            modelAndView.addObject("user", msg.getObj());
            httpSession.setAttribute("user", msg.getObj());
        }
        return modelAndView;
    }

}
