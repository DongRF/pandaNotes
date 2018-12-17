package com.dongrf.pandaNotes.function.login.Action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginAction {

    @RequestMapping(value = "/doLogin",method = RequestMethod.GET)
    public ModelAndView doLogin(@RequestParam int a){
        System.out.println("The Param = " + a);
        return null;
    }
}
