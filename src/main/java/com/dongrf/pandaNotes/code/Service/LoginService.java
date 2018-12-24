package com.dongrf.pandaNotes.code.Service;

import com.dongrf.pandaNotes.code.Entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface LoginService {
    Boolean doLogin(String userName,String password);
}
