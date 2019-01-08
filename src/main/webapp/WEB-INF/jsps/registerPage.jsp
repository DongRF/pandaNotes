<%--
  Created by IntelliJ IDEA.
  User: Mr_DongRF
  Date: 2019/1/3
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎加入熊猫笔记</title>

    <link rel="stylesheet" href="../../resources/animate/animate.css"> <!-- 引入Animate.css样式 -->

    <script src="../../resources/vue/vue.js"></script> <!-- 引入vue.js -->
    <script src="../../resources/vue/vue-resource.js"></script><!-- 引入vue-resource.js -->
    <script src="../../resources/vue/vuex.js"></script><!-- 引入vuex.js -->

    <!-- 从本地引入iview会导致一些组件无法显示，不知道为什么，所以只能在网站引入 -->
    <%--<link rel="stylesheet" href="//unpkg.com/iview/dist/styles/iview.css"> <!-- 引入iview.css样式 -->--%>
    <%--<script src="//unpkg.com/iview/dist/iview.min.js"></script><!-- 引入iview.min.js -->--%>

    <link rel="stylesheet" href="../../resources/iview/iview.css">
    <script src="../../resources/iview/iview.min.js"></script>



</head>
<body>
<div id="mainDiv">
    <div id="panelDiv">
        <Layout>
            <Header style="width:100%; height: 20%;background-color: #ffffff;">
                <div style="position: relative; top: 70%;">
                    <Steps v-bind:current="current" style="width: 100%;height: 30%; padding-left: 10%;">
                        <Step title="绑定邮箱" content="填写常用的邮箱地址"></Step>
                        <Step title="用户名/密码" content="设置用户名和密码"></Step>
                        <Step title="可选信息" content="后续可在“个人中心”修改"></Step>
                        <Step title="完成注册" content="欢迎加入熊猫家庭"></Step>
                    </Steps>
                </div>
            </Header>
            <Content style="width:100%; height: 40%;background-color: #ffffff">

                <transition>
                    <component :is="comName"></component>
                </transition>

            </Content>
            <Footer style="width:100%; height: 40%;background-color: #ffad33">

            </Footer>
        </Layout>

    </div>
</div>




<%--绑定邮箱的组件--%>
<template id="bindEmail">
    <div style="margin-left: 5%;margin-top: 3%">
        <table border="0" width="50%">
            <tr style="height: 50px;">
                <td align="right" width="30%">
                    <span>邮箱地址&nbsp;&nbsp;</span>
                </td>
                <td width="70%">
                    <i-input v-model="email" icon="ios-mail-outline" size="large" style="width: 100%" @on-change="validateEmail" :maxlength="lengthForEmail" placeholder="填写常用的邮箱地址"></i-input>
                </td>
            </tr>
            <tr style="height: 50px">
                <td align="right">
                    <span>验证码&nbsp;&nbsp;</span>
                </td>
                <td>
                    <i-input v-model="code" icon="ios-key-outline" size="large" style="width: 75%" @on-change="validateEmail" :maxlength="lengthForCode" placeholder="6位验证码"></i-input>
                    <i-button type="primary" :loading="waiting" @click="sendVerificationCode" :disabled="disable" style="width: 24%">
                        <span v-if="!waiting">{{ description }}</span>
                        <span v-else>{{ count }}秒后重试</span>
                    </i-button>
                </td>
            </tr>
            <tr style="height: 60px">
                <td></td>
                <td>
                    <Checkbox v-model:value="agree">同意<a href="#">《熊猫笔记隐私和服务协议》</a></Checkbox>
                </td>
            </tr>
            <tr style="height: 40px">
                <td></td>
                <td>
                    <i-button type="primary" @click="nextPage()" size="large" style="width: 50%">下一步，用户名/密码</i-button>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <a href="#"><span style="font-size: small">注册遇到问题？</span></a>
                </td>
            </tr>
        </table>
    </div>
</template>




<%--填写用户名和密码的组件--%>
<template id="usernameAndPassword">
    <div>
        <table border="0" width="50%">
            <tr style="height: 50px;">
                <td align="right" width="30%">
                    <span>用户名&nbsp;&nbsp;</span>
                </td>
                <td width="70%">
                    <i-input v-model="username" icon="ios-contact-outline" size="large" style="width: 100%" @on-change="" :maxlength="lengthForUserAndPassword" placeholder="建议使用邮箱地址作为用户名"></i-input>
                </td>
            </tr>
            <tr style="height: 50px">
                <td align="right">
                    <span>密码&nbsp;&nbsp;</span>
                </td>
                <td>
                    <i-input type="password" v-model="password" icon="ios-key-outline" size="large" style="width: 100%" @on-change="" :maxlength="lengthForUserAndPassword" placeholder="不低于8位的字母、数字以及特殊符号的密码组合"></i-input>
                </td>
            </tr>
            <tr style="height: 50px">
                <td align="right">
                    <span>重复密码&nbsp;&nbsp;</span>
                </td>
                <td>
                    <i-input type="password" v-model="rePassword" icon="ios-key-outline" size="large" style="width: 100%" @on-change="" :maxlength="lengthForUserAndPassword" placeholder="重复输入的密码"></i-input>
                </td>
            </tr>
            <tr style="height: 40px">
                <td><p> {{ username }} </p></td>
                <td>
                    <i-button type="primary" @click="nextPage()" size="large" style="width: 50%">下一步，可选信息</i-button>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <a href="#"><span style="font-size: small">注册遇到问题？</span></a>
                </td>
            </tr>
        </table>
    </div>
</template>




<%--填写可选信息的组件--%>
<template id="optionalInformation">
    <div>
        <h3>可选信息</h3>
    </div>
</template>




<%--注册完成的组件--%>
<template id="finish">
    <div>
        <h3>完成</h3>
    </div>
</template>


<link rel="stylesheet" href="../../css/registerPage.css">  <!-- 引入当前界面的css样式 -->
<script src="../../js/registerPage.js"></script> <!-- 引入当前界面的js -->
</body>
</html>
