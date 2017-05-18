// 存放登录模块js代码
// javascript 模块化
var login ={
		// 封装秒杀相关ajax的url
		URL : {
			basePath : function() {
				return $('#basePath').val();
			},
			loginSubmit : function() {
				return login.URL.basePath() + 'submit';
			},
			toIndex : function (){
				return login.URL.basePath() + 'toIndex';
			}
			
		},
		init:function(){
			$('#loginSumBtn').click(function() {
				var username =$("#username").val();
				var password =$("#password").val();
				if(username ==null || username==''){
					alert("用户名不能为空！");
					return;
				}
				if(password ==null || password==''){
					alert("密码不能为空！");
					return;
				}
				$.post(login.URL.loginSubmit(),{"username":username,"password":password},function(data){
					if(data.succ){
						location.href=login.URL.toIndex();
					}else{
						alert(data.msg);
					}
				});
			});
		}
}