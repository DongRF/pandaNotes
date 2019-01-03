package com.dongrf.pandaNotes.code.Action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ 类名：JumpInterface
 * @ 作者：Mr_DongRF
 * @ 日期：2019/1/3 11:24
 * @ 功能：跳转界面
 * @ Version：1.0
 */
@Controller
@RequestMapping("jumpInterface")
public class JumpInterface {
    @RequestMapping(value="jumpPage",method = RequestMethod.GET)
    public ModelAndView JumpRegisterPage(String pageName){
        ModelAndView mav = new ModelAndView();
        mav.setViewName(pageName);
        return mav;
    }
}
