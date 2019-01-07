Vue.http.options.emulateJSON = true;  //设置本页面的所有post请求都以普通表单的形式提交

const mainCount = {
    mainCurrent : 0,
    mainComName : 'bindEmail'
}

Vue.component('bindEmail',{
    template:'#bindEmail',
    data:function () {
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
    methods:{
        sendVerificationCode(){     //发送验证码
            this.waiting = true;
            this.countTime();

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
            mainCount.mainCurrent += 1;
            mainCount.mainComName = 'usernameAndPassword';
        }
    }
});
Vue.component('usernameAndPassword',{
    template:'#usernameAndPassword',
    data: function(){
        return {

        }
    },
    methods:{

    }
});
Vue.component('optionalInformation',{
    template:'#optionalInformation'
});
Vue.component('finish',{
    template:'#finish'
});

const vm = new Vue({
    el:'#mainDiv',
    data:mainCount,
    methods:{
        // next () {   //点击下一步按钮
        //     if (this.current == 3) {
        //         this.current = 0;
        //     } else {
        //         this.current += 1;
        //         if(this.current===1){
        //             this.comName = 'usernameAndPassword';
        //         }
        //         if(this.current===2){
        //             this.comName = 'optionalInformation';
        //         }
        //         if(this.current===3){
        //             this.comName = 'finish';
        //         }
        //     }
        // },
    }
});