package com.dongrf.pandaNotes.code.DAO;

import com.dongrf.pandaNotes.code.Entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ 接口名：LoginDAO
 * @ 作者：Mr_DongRF
 * @ 日期：2018/12/24 21:20
 * @ 功能：登录DAO
 * @ Version：1.0
 */
public interface LoginDAO {
    List<User> doLogin(@Param("userName") String userName);
}
