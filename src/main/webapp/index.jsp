<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>熊猫笔记</title>

        <link rel="stylesheet" href="resources/css/animate.css">

        <script src="resources/vue/vue.js"></script> <!-- 引入Vue.js -->
        <script src="resources/vue/vue-resource.js"></script>

        <script>
            Vue.http.options.emulateJSON = true;  //设置本页面的所有post请求都以普通表单的形式提交
            window.onload=function(){
                const vm = new Vue({
                    el:'#LoginDiv',
                    data:{
                        userName: '',
                        password:'',
                        description:'',
                        promptUsername: '用户名/邮箱/手机号',
                        promptPassword: '密码',
                        show:false
                    },
                    methods:{
                        doLogin(){
                            this.show = false;
                            this.$http.post('loginAction/doLogin.do',{userName: this.userName,password: this.password}).then(response => {
                                let flag = response.body.flag;
                                if(flag === "1"){
                                    alert("登录成功");
                                }else{
                                    this.description = response.body.description;
                                    this.show = true;
                                }
                            },response => {
                                alert("请求失败");
                                this.description = "网络或服务器故障，请稍后重试";
                                this.show = true;
                            });
                        },
                        hideDescription(){
                            this.show = false;
                        }
                    }
                });
            }
        </script>
    </head>
    <body>




    <div id="LoginDiv">
        <input type="text" v-model:value="userName" :placeholder="promptUsername" @click="hideDescription"/>
        <br/>
        <input type="password" v-model:value="password" :placeholder="promptPassword" @click="hideDescription"/>
        <br/>
        <input type="button" value="登 录" @click="doLogin">
        <br/>
        <transition enter-active-class="animated shake" leave-active-class="animated shake" :duration="{ enter:400, leave:10 }">
            <p v-if="show">{{ description }}</p>
        </transition>
        <span>还没账号？</span><a href="jumpInterface/jumpPage.do?pageName=registerPage">立即注册</a>
    </div>




    </body>
</html>
