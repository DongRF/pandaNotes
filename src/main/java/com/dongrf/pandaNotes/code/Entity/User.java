package com.dongrf.pandaNotes.code.Entity;

import com.sun.xml.internal.ws.message.StringHeader;

import java.util.Date;

/**
 * @ 类名：User
 * @ 作者：Mr_DongRF
 * @ 日期：2018/12/24 21:20
 * @ 功能：User实体类
 * @ Version：1.0
 */
public class User {
    private Long userId;
    private String userName;
    private String password;
    private String nickName;
    private String headPicture;
    private String trueName;
    private String gender;//性别
    private Date birthday;
    private String address;//地区
    private String industry;//行业
    private String introduction;//简介
    private Date registerTime;//注册时间
    private String registerIp;//注册IP
    private Date updatePasswordTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadPicture() {
        return headPicture;
    }

    public void setHeadPicture(String headPicture) {
        this.headPicture = headPicture;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public Date getUpdatePasswordTime() {
        return updatePasswordTime;
    }

    public void setUpdatePasswordTime(Date updatePasswordTime) {
        this.updatePasswordTime = updatePasswordTime;
    }
}
