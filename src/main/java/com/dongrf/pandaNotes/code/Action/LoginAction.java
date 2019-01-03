package com.dongrf.pandaNotes.code.Action;

import com.dongrf.pandaNotes.code.Service.ILoginService;
import com.dongrf.pandaNotes.code.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

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
    ILoginService loginService;

    @ResponseBody
    @RequestMapping(value="doLogin",method = RequestMethod.POST)
    public Map doLogin(User user) {
        /**
         * @ 方法名：doLogin
         * @ params: [user]
         * @ return: org.springframework.web.servlet.ModelAndView
         * @ 作者：Mr_DongRF
         * @ 日期：2018/12/24
         * @ 功能：登录
         */
        Boolean result = loginService.doLogin(user);

        Map<String,String> map = new HashMap<>();

        if (result) {
            map.put("flag","1");//登录成功的标志
            map.put("description",null);
            map.put("url","www.baidu.com");
        } else {
            map.put("flag","-1");
            map.put("description","用户名或密码有误，请重新输入。");
            map.put("url",null);
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value="doLoginTest",method = RequestMethod.POST)
    public User doLoginTest(User user){
        System.out.println("UserName = " + user.getUserName());
        System.out.println("Password = " + user.getPassword());
        user.setUserName("lisi");
        user.setPassword("123");
        return user;
    }
}
