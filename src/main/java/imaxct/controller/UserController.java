package imaxct.controller;

import imaxct.domain.User;
import imaxct.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by imaxct on 17-4-6.
 */
@Controller
@RequestMapping(value = "/User")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("index");
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String username, String password){
        User user = userService.login(username, password);
        ModelAndView modelAndView = new ModelAndView("user");
        if (user == null){
            modelAndView.addObject("msg", "failed");
        }else {
            modelAndView.addObject("msg", "登录成功");
            modelAndView.addObject("user", user);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(String username, String password){
        boolean flag = userService.register(username, password);
        ModelAndView modelAndView = new ModelAndView("user");
        if (flag){
            modelAndView.addObject("msg", "注册成功");
        }else {
            modelAndView.addObject("msg", "注册失败");
        }
        return modelAndView;
    }
}
