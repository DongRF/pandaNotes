package com.dongrf.pandaNotes.code.DAO;

import com.dongrf.pandaNotes.code.Entity.User;
import org.apache.ibatis.annotations.Param;


public interface LoginDAO {
    User getPassword(@Param("userName")String userName);
}
