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
            var vm = new Vue({
                el:'#LoginPanel',
                data:{
                    userName: '',
                    password:'',

                    promptUsername: '用户名/邮箱/手机号',
                    promptPassword: '密码',
                },
                methods:{
                    doLogin(){
                        this.$http.get('/loginAction/doLoginTest.do').then(response => {
                            this.userName = response.userName;
                            this.password = response.password;
                        },response => {

                        });

                        // this.$http.post('/loginAction/doLogin.do',data,{emulateJSON:true}).then(response => {
                        //     console.log("成功"+response);
                        // },response => {
                        //     console.log("失败"+response);
                        // });
                    }
                }
            });
        }
    </script>



    <div id="LoginPanel">
        <input type="text" v-model:value="userName" :placeholder="promptUsername"/>
        <br/>
        <input type="password" v-model:value="password" :placeholder="promptPassword"/>
        <br/>
        <input type="button" value="登 录" @click="doLogin">
    </div>




    </body>
</html>
