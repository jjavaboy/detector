
function AlarmLogin(){}

AlarmLogin.prototype = {
		login : function(){
			if($.trim($("#j_username").val()) == ""){
				alert("name cann't be empty.");
				return ;
			}
			if($.trim($("#j_password").val()) == ""){
				alert("password cann't be empty.");
				return ;
			}
			$("#loginForm").submit();
			/*var data = {user_code:$("#j_username").val(),user_pass:$("#j_password").val()};
			$.ajax({
				url:"/alarm/rest/index/checkUser",
				type:"POST",
				data:data,
				dataType:"json",
				success:function(resp){
					if(resp.retCode == "1"){
						$("#loginForm").submit();
					}else{
						alert(resp.retMsg);
					}
				}
			});*/
		},
		logout : function(){
			top.location.href="/alarm/rest/index/logout?v="+new Date().getTime();
			/*var ajax = $.ajax({
				url:"/alarm/rest/index/logout?v="+new Date().getTime(),
				type:"GET",
				dataType:"json",
				success:function(data){
					alert(data);
					
					///window.location.reload();
				}
			});*/
			
		}
};