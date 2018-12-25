<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>

    <script src="resources/vue.js/vue.js"></script> <!-- 引入Vue.js -->
    <script src="resources/jQuery/jquery-3.3.1.min.js"></script> <!-- 引入jQuery -->
    <script>
        window.onload=function(){
            var vm = new Vue({
                el:'#LoginPanel',
                data:{
                    userName: '',
                    password:'',

                    prompt_username: '用户名/邮箱/手机号',
                    prompt_password: '密码',
                },
                methods:{
                    doLogin(){
                        $.ajax({
                            url: 'loginAction/doLogin.do',
                            type: 'post',
                            async: true,
                            contentType: 'application/json;charset=utf-8',
                            dataType: 'json',
                            data: JSON.stringify({  //从一个对象中解析出字符串
                                userName: '123',
                                password: '123'
                            }),
                            success:function(result){
                                console.log(result);
                            },
                            error:function(err){
                                console.log(err);
                            }
                        });
                    }
                }
            });
        }
    </script>



    <div id="LoginPanel">
        <input type="text" v-model:value="userName" :placeholder="prompt_username"/>
        <br/>
        <input type="password" v-model:value="password" :placeholder="prompt_password"/>
        <br/>
        <input type="button" value="登 录" @click="doLogin">
    </div>




    </body>
</html>
