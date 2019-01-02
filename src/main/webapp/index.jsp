<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>

    <script src="resources/vue/vue.js"></script> <!-- 引入Vue.js -->
    <script src="resources/vue/vue-resource.js"></script>

    <script>
        window.onload=function(){
            const vm = new Vue({
                el:'#LoginDiv',
                data:{
                    userName: '',
                    password:'',

                    promptUsername: '用户名/邮箱/手机号',
                    promptPassword: '密码',
                },
                methods:{
                    doLogin(){
                        this.$http.post('loginAction/doLogin.do',{userName: this.userName,password: this.password},{emulateJSON: true}).then(response => {
                            let flag = response.body.flag;
                            if(flag === "1"){
                                alert("登录成功");
                                alert(response.body.url);
                            }else{
                                alert("登录失败");
                            }
                            console.log("url = " + response.data.url);
                            console.log("url = " + response.body.url);
                        },response => {
                            alert("请求失败");
                        });
                    }
                }
            });
        }
    </script>



    <div id="LoginDiv">
        <input type="text" v-model:value="userName" :placeholder="promptUsername"/>
        <br/>
        <input type="password" v-model:value="password" :placeholder="promptPassword"/>
        <br/>
        <input type="button" value="登 录" @click="doLogin">
    </div>




    </body>
</html>
