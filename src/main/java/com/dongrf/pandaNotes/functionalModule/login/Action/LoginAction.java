package com.dongrf.pandaNotes.functionalModule.login.Action;

import com.dongrf.pandaNotes.functionalModule.login.JavaBean.UserBean;
import com.dongrf.pandaNotes.functionalModule.login.Service.LoginService;
import com.dongrf.pandaNotes.functionalModule.login.Service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

        System.out.println("用户名 = "+ a);
        UserBean userBean = loginService.getPassword(a);
        System.out.println("密码 = " +userBean.getPassword());
        mav.addObject("data",userBean.getPassword());
        return mav;
    }
}
