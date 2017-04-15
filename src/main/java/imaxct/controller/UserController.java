package imaxct.controller;

import imaxct.domain.User;
import imaxct.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by imaxct on 17-4-6.
 */
@Controller
@RequestMapping(value = "/User")
@SessionAttributes({"user"})
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/main")
    public String main(){

        return "main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String username, String password, HttpSession httpSession){
        User user = userService.login(username, password);
        ModelAndView modelAndView;
        if (user == null){
            modelAndView = new ModelAndView("msg");
            modelAndView.addObject("msg", "登陆失败");
        }else {
            modelAndView = new ModelAndView("redirect:/main");
            modelAndView.addObject("user", user);
            httpSession.setAttribute("user", user);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(String username, String password){
        boolean flag = userService.register(username, password);
        ModelAndView modelAndView = new ModelAndView("msg");
        if (flag){
            modelAndView.addObject("msg", "注册成功");
        }else {
            modelAndView.addObject("msg", "注册失败");
        }
        return modelAndView;
    }
}
