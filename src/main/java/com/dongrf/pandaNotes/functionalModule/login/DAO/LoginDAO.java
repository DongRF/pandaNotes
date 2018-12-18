package com.dongrf.pandaNotes.functionalModule.login.DAO;

import com.dongrf.pandaNotes.functionalModule.login.JavaBean.UserBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


public interface LoginDAO {
    UserBean getPassword(@Param("userName")String userName);
}
