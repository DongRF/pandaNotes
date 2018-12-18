package com.dongrf.pandaNotes.functionalModule.login.Service;

import com.dongrf.pandaNotes.functionalModule.login.DAO.LoginDAO;
import com.dongrf.pandaNotes.functionalModule.login.JavaBean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDAO loginDAO;
    @Override
    public UserBean getPassword(String userName){
        return loginDAO.getPassword(userName);
    }
}
