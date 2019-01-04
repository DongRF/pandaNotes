Vue.http.options.emulateJSON = true;  //设置本页面的所有post请求都以普通表单的形式提交
window.onload=function(){

    const vm = new Vue({
        el:'#mainDiv',
        data:{
            userName: '',
            password:'',
            description:'',
            promptUsername: '用户名/邮箱/手机号',
            promptPassword: '密码',
            show:false,
            single:true,
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