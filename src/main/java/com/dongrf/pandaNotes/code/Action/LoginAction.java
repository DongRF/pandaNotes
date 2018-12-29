package com.dongrf.pandaNotes.code.Action;

import com.dongrf.pandaNotes.code.Service.LoginService;
import com.dongrf.pandaNotes.code.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ 类名：LoginAction
 * @ 作者：Mr_DongRF
 * @ 日期：2018/12/24 21:20
 * @ 功能：登录Action
 * @ Version：1.0
 */
@Controller
@RequestMapping("loginAction")
public class LoginAction {
    @Autowired
    LoginService loginService;

    @ResponseBody
    @RequestMapping(value="doLogin",method = RequestMethod.POST)
    public ModelAndView doLogin(@RequestBody User user) {
        /**
         * @ 方法名：doLogin
         * @ params: [user]
         * @ return: org.springframework.web.servlet.ModelAndView
         * @ 作者：Mr_DongRF
         * @ 日期：2018/12/24
         * @ 功能：
         */
        ModelAndView mav = new ModelAndView();
        String userName = user.getUserName();
        String password = user.getPassword();

        Boolean result = loginService.doLogin(userName, password);

        System.out.println("登录成功？？ = " + result);

        mav.addObject("result", result);
        if (result) {
            mav.setViewName("mainPage");
            return mav;
        } else {
            return mav;
        }
    }

    @ResponseBody
    @RequestMapping(value="doLoginTest",method = RequestMethod.GET)
    public User doLoginTest(){
        User user = new User();
        user.setUserName("张三");
        user.setPassword("123");
        return user;
    }
}
