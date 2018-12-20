package com.dongrf.pandaNotes.code.Action;

import com.dongrf.pandaNotes.code.Service.LoginService;
import com.dongrf.pandaNotes.code.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("loginAction")
public class LoginAction {
    @Autowired
    LoginService loginService;

    @RequestMapping(value="doLogin",method = RequestMethod.GET)
    public ModelAndView doLogin(@RequestParam String a){
        ModelAndView mav = new ModelAndView();

        System.out.println("用户名1 = "+ a);
        User userBean = loginService.getPassword(a);


        System.out.println("密码2 = " +userBean.getPassword());
        System.out.println("用户名2 = "+ userBean.getUserName());

        mav.addObject("data",userBean.getPassword());
        mav.setViewName("mainPage");
        return mav;
    }
}
