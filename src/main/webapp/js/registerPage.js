Vue.http.options.emulateJSON = true;  //设置本页面的所有post请求都以普通表单的形式提交

const store = new Vuex.Store({
    state: {
        current : 0,  //页码
        comName : 'bindEmail',   //组件名字

        email:'',       //邮箱地址（页面1）
        agree: true,    //是否同意协议（页面1）
        code:'',        //验证码（页面1）
    },
    mutations: {
        saveBindEmail(state,Page1Data){
            state.current = Page1Data.current;
            state.comName = Page1Data.comName;
            state.email = Page1Data.email;
            state.agree = Page1Data.agree;
            state.code = Page1Data.code;
        }
    }
});

const vm = new Vue({
    el:'#mainDiv',
    data:{
    },
    computed:{  //将store.state中的current,comName属性刷新到页面
        current(){
            return store.state.current;
        },
        comName(){
            return store.state.comName;
        }
    },
    methods:{

    },
    components:{

        bindEmail:{
            template:'#bindEmail',
            data(){
                return {
                    waiting: false,  //转圈等待
                    count: 60,       //n秒后重试
                    disable: true,     //按钮是否不可用
                    description:'邮箱不可为空',   //按钮上的文字
                    email:'',     //邮箱地址
                    agree: true,  //是否同意协议
                    code:'',  //验证码
                    lengthForEmail: 40,
                    lengthForCode: 6

                }
            },
            //props:['childcurrent','childcomname'],
            methods:{
                sendVerificationCode(){     //发送验证码
                    this.waiting = true;
                    this.countTime();
                    //生成验证码并发送（未解决）

                },
                countTime(){    //倒计时
                    let clock = window.setInterval(() => {
                        this.count--;
                        if (this.count <= 0) {     //当倒计时小于等于0时清除定时器
                            window.clearInterval(clock);
                            this.waiting = false;
                            this.count = 60;
                        }
                    },1000);
                },
                validateEmail(){    //校验邮箱格式
                    this.disable = true;
                    if (this.email === '') {
                        this.description = '邮箱不可为空';
                    } else {
                        var reg=/^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
                        if(!reg.test(this.email)){
                            this.description = '邮箱格式不正确';
                        }else{
                            this.description = '发送验证码';
                            this.disable = false;
                        }
                    }
                },
                nextPage() {       //点击下一步按钮
                    store.commit('saveBindEmail',{   //提交到store中保存起来
                        current : 1,
                        comName : 'usernameAndPassword',
                        email: this.email,
                        agree: this.agree,
                        code: this.code
                    });

                    //与下面的nextPage没解决。这个nextPage调用下面的nextPage。
                    //即组件之间的方法调用没解决

                    //this.$emit('nextpage',this.childcurrent);   //子组件向父组件传值
                }
            }
        },

        usernameAndPassword:{
            template:'#usernameAndPassword',
            data(){
                return{
                    username:'',
                    lengthForUserAndPassword: 40,   //用户名和密码的最大长度
                    password: '',                   //密码
                    rePassword:'',                  //重复密码
                }
            },
            computed:{
            },
            methods:{
                nextPage(){
                    this.username = store.state.email;
                    console.log(store.state.email);
                }
            }
        },
        optionalInformation:{
            template:'#optionalInformation',

        },
        finish:{
            template:'#finish',
        }
    }
});