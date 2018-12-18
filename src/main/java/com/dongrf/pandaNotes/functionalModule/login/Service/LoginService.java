package com.dongrf.pandaNotes.functionalModule.login.Service;

import com.dongrf.pandaNotes.functionalModule.login.JavaBean.UserBean;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    UserBean getPassword(String userName);
}
