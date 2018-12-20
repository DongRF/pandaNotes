package com.dongrf.pandaNotes.code.Service.ServiceImpl;

import com.dongrf.pandaNotes.code.Entity.User;
import com.dongrf.pandaNotes.code.DAO.LoginDAO;
import com.dongrf.pandaNotes.code.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDAO loginDAO;
    @Override
    public User getPassword(String userName){
        return loginDAO.getPassword(userName);
    }
}