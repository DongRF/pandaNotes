Vue.http.options.emulateJSON = true;  //设置本页面的所有post请求都以普通表单的形式提交

const store = new Vuex.Store({
    state: {
        current : 0,  //页码
        comName : 'bindEmail',   //组件名字

        email:'',       //邮箱地址（页面1）
        agree: true,    //是否同意协议（页面1）
        code:'',        //验证码（页面1）

        username:'',    //用户名（页面2）
        password: ''    //密码（页面2）
    },
    mutations: {
        saveBindEmailPageInfo(state,page1Data){
            state.current = page1Data.current;
            state.comName = page1Data.comName;
            state.email = page1Data.email;
            state.agree = page1Data.agree;
            state.code = page1Data.code;
        },
        saveUsernameAndPasswordPageInfo(state,page2Data){
            state.current = page2Data.current;
            state.comName = page2Data.comName;
            state.username = page2Data.username;
            state.password = page2Data.password;
        }
    },
    actions: {

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
                    store.commit('saveBindEmailPageInfo',{   //提交到store中保存起来
                        current : 1,
                        comName : 'usernameAndPassword',
                        email: this.email,
                        agree: this.agree,
                        code: this.code
                    });
                    //store.dispatch('next')  //调用store的actions里面的方法
                    //this.$emit('nextpage',this.childcurrent);   //子组件向父组件传值
                }
            }
        },

        usernameAndPassword:{
            template:'#usernameAndPassword',
            data(){
                return{
                    username:'',
                    password: '',                   //密码
                    rePassword:'',                  //重复密码
                }
            },
            computed:{
            },
            methods:{
                putUsername(){  //将上一个页面填入的邮箱填入到用户名
                    this.username = store.state.email;
                },
                nextPage(){
                    store.commit('saveUsernameAndPasswordPageInfo',{   //提交到store中保存起来
                        current : 2,
                        comName : 'optionalInformation',
                        username: this.username,
                        password: this.password
                    });
                }
            },
            created(){
                this.putUsername();
            }
        },
        optionalInformation:{
            template:'#optionalInformation',
            data(){
                return{
                    nickName:'',
                    firstName:'',
                    secondName:'',
                    gender:'1',
                    birthday:'2000-01-01',
                    defaultCity: [1, 1],
                    city: city,

                }
            }
        },
        finish:{
            template:'#finish',
        }
    }
});