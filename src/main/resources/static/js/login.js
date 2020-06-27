var vm = new Vue({
    el: '#app',
    data: {
        username: '',
        password: '',
        character: 'T'
    },
    methods:{
        login:function () {
            console.log(this.username);
            this.$http.post("/login",{username:this.username,password: this.password,character: this.character},{emulateJSON:true})
                .then(function (value) {
                    console.log(value);
                    console.log(value.body.success===1);
                    if (value.body.success===1){
                        sessionStorage.setItem("token",value.body.token);
                        if (this.character==="S")
                            self.location='/student/'+value.body.user.id;
                        else
                            self.location='/teacher/'+value.body.user.id;
                    }
                    else{
                        if(this.character==='T'){
                            alert(value.body.msg);
                        }
                    }
                })

        }
    }
});
