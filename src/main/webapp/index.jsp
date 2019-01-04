<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>熊猫笔记</title>

        <link rel="stylesheet" href="resources/animate/animate.css"> <!-- 引入Animate.css样式 -->

        <script src="resources/vue/vue.js"></script> <!-- 引入vue.js -->
        <script src="resources/vue/vue-resource.js"></script><!-- 引入vue-resource.js -->

        <!-- 从本地引入iview会导致一些组件无法显示，不知道为什么，所以只能在网站引入 -->
        <link rel="stylesheet" href="//unpkg.com/iview/dist/styles/iview.css"> <!-- 引入iview.css样式 -->
        <script src="//unpkg.com/iview/dist/iview.min.js"></script><!-- 引入iview.min.js -->

        <link rel="stylesheet" href="css/index.css">  <!-- 引入当前界面的css样式 -->



    </head>

    <body>

    <div id="mainDiv">
        <div id="loginDiv">
            <row style="height: 100%;">
                <i-col span="6" style="height: 100%; background-color: #17233d"> 12 </i-col>
                <i-col span="12" style="height: 100%; background-color: #ffffff">
                    <div id="inputDiv">
                        <span style="font-size: 40px;font-family: 幼圆;font-weight: bolder;">熊 猫 笔 记</span>
                        <br/>
                        <!-- transition和animated.css定义一个简单的动画效果 -->
                        <transition enter-active-class="animated shake" leave-active-class="animated shake" :duration="{ enter:400, leave:0 }">
                            <p v-if="show"><span style="font-size: 15px;font-weight:bold; color: red;">{{ description }}</span></p>
                        </transition>
                            <p v-if="!show"><span style="font-size: 15px;">&nbsp;</span></p>
                        <i-input type="text" clearable autofocus maxlength=40 v-model:value="userName" size="large" prefix="ios-contact" :placeholder="promptUsername" style="width: 55%;" @on-focus="hideDescription"></i-input>
                        <%--<input type="text" v-model:value="userName" :placeholder="promptUsername" @click="hideDescription"/>--%>
                        <br/><br/>
                        <%--<input type="password" v-model:value="password" :placeholder="promptPassword" @click="hideDescription"/>--%>
                        <i-input type="password" clearable maxlength=40 v-model:value="password" size="large" prefix="ios-unlock" :placeholder="promptPassword" style="width: 55%;" @on-focus="hideDescription"></i-input>
                        <br/>
                        <div style="margin: 10px 22.5% 20px 22.5%">
                            <Checkbox v-model:value="single" on-change="single=!single" style="float: left;margin-left:5px;">记住我</Checkbox>
                            <span style="float: right;margin-right:5px;"><Icon type="ios-help-circle" size=14></Icon><a href="#"> 忘记密码</a></span>
                        </div>
                        <br/>
                        <i-button type="primary" size="large" icon="md-contact" @click="doLogin" style="width: 55%">登 录</i-button>
                        <br/>
                        <div style="margin: 10px 0 0 22.5%">
                            <span style="float: left;">还没账号？<a href="jumpInterfaceAction/jumpPage.do?pageName=registerPage">立即注册</a></span>
                        </div>
                    </div>
                </i-col>
                <i-col span="6" style="height: 100%; background-color: #ffad33"> 12 </i-col>
            </row>
        </div>
    </div>

    <script src="js/index.js"></script> <!-- 引入当前界面的js -->
    </body>
</html>
