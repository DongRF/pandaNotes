package com.dongrf.pandaNotes.code.Service.ServiceImpl;

import com.dongrf.pandaNotes.code.Entity.User;
import com.dongrf.pandaNotes.code.DAO.LoginDAO;
import com.dongrf.pandaNotes.code.Service.LoginService;
import com.dongrf.pandaNotes.code.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ 类名：LoginServiceImpl
 * @ 作者：Mr_DongRF
 * @ 日期：2018/12/24 21:20
 * @ 功能：登录Service
 * @ Version：1.0
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDAO loginDAO;
    @Override
    public Boolean doLogin(String userName,String password){
        /**
         * @ 方法名：doLogin
         * @ params: [userName,password]
         * @ return: com.dongrf.pandaNotes.code.Entity.User
         * @ 作者：Mr_DongRF
         * @ 日期：2018/12/24
         * @ 功能：登录验证
         */
        //获取数据库储存的密码
        String truePassword = loginDAO.doLogin(userName).getPassword();
        //验证密码
        boolean result = MD5.verify(password,userName+"pandaNotes",truePassword);

        return result;
    }
}