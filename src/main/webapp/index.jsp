<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Insert title here</title>
    </head>
    <body>

    <script src="resource/vue.js/vue.js"></script>


    <div id="app">
        <p v-cloak>{{ mag }}</p>
        <p v-text="mag2">{{ mag }}</p>
        <p v-html="mag3"></p>
        <input type="text" v-bind:value="mag4+888">
        <input type="text" :value="mag4+777">
        <input type="button" :value="mag5" v-on:click="show">
        <input type="button" value="按钮2" @click="show1(6666)">

        <br/>
        <br/>

        <h2 v-text="mag6"></h2>

        <input type="button" value="开始跑" @click="start">
        <input type="button" value="停止" @click="stop">
        <br/><br/>
    </div>

    <a href="/loginAction/doLogin.do?a=123" target="_blank">点击打印数字</a>





    <script>
        new Vue({
            el:'#app',
            data:{
                mag: '123',
                mag2: '456',
                mag3: '<h3>789</h3>',
                mag4: '111',
                mag5: '按钮',
                mag6: '123，起来！'
            },
            methods:{
                show(){
                    alert(5555);
                },
                show1(a){
                    alert(a);
                },
                start(){
                    t1 = window.setInterval(this.run,500);
                },
                run(){
                    this.mag6=this.mag6[6]+this.mag6[0]+this.mag6[1]+this.mag6[2]+this.mag6[3]+this.mag6[4]+this.mag6[5];
                },
                stop(){
                    window.clearInterval(t1);
                }
            }
        })
    </script>

    </body>
</html>
