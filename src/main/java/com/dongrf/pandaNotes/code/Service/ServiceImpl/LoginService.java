package com.dongrf.pandaNotes.code.Service.ServiceImpl;

import com.dongrf.pandaNotes.code.DAO.LoginDAO;
import com.dongrf.pandaNotes.code.Entity.User;
import com.dongrf.pandaNotes.code.Service.ILoginService;
import com.dongrf.pandaNotes.code.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ 类名：LoginServiceImpl
 * @ 作者：Mr_DongRF
 * @ 日期：2018/12/24 21:20
 * @ 功能：登录Service
 * @ Version：1.0
 */
@Service
public class LoginService implements ILoginService {
    @Autowired
    private LoginDAO loginDAO;
    @Override
    public Boolean doLogin(User user){
        /**
         * @ 方法名：doLogin
         * @ params: [userName,password]
         * @ return: com.dongrf.pandaNotes.code.Entity.User
         * @ 作者：Mr_DongRF
         * @ 日期：2018/12/24
         * @ 功能：登录验证
         */
        boolean result = false;
        String truePassword = "";

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            result = false;
        }
        List<User> list = loginDAO.doLogin(user.getUserName());

        if(list.size()>0){
            //获取数据库储存的密码
            truePassword = list.get(0).getPassword();

            //验证密码
            if (truePassword!=null & truePassword!=""){
                result = MD5.verify(user.getPassword(),user.getUserName()+"pandaNotes",truePassword);
            }
        }
        return result;
    }
}