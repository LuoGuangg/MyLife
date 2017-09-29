
function onmove(index) {
		var title_id = "title_" + index;
		var down_tr = "tr_" + index;
		var t_id = document.getElementById(title_id);
		var d_tr = document.getElementById(down_tr);
		t_id.style = " font-size:15px; color:#FF7700;";
		d_tr.style = " height:5px;background-color:#EDEDED;";
	}

function onout(index) {
		var title_id = "title_" + index;
		var down_tr = "tr_" + index;
		var t_id = document.getElementById(title_id);
		var d_tr = document.getElementById(down_tr);
		t_id.style = " font-size:15px; color:#000000; ";
		d_tr.style = " height:5px;background-color:#ffffff;";
	}

function dianji(url) {
	window.open("TiaoZhuan.jsp?url=" + url);
}

$(function() {
	/*搜索*/
	$(".search_pic").click(function() {
		$(".headernav").fadeOut(500);
		$(".search_main").fadeIn(1000);
	});
	$(".search_main .close_btn").click(function() {
		$(".search_main").fadeOut(500);
		$(".headernav").fadeIn(1000);
	});
	/*登录*/
	$(".list a").click(function() {
		$(".member").slideToggle(500);
	});
	
});
function ZhiBoTiao(i) {
	window.location.href = "ZhiBo.html?index=" + i;
}
/*
 * 直播间分页
 */
function page(n, s, i) {
	$("#pageNo").val(n);
	$("#pageSize").val(s);
	$("#index").val(i);
	$("#pageForm").submit();
	return false;
}

/*
 * 留言板分页
 */
function messageAllPage(n, s, i) {
	$("#messageAllpageNo").val(n);
	$("#messageAllpageSize").val(s);
	$("#messageAllindex").val(i);
	$("#messageAllpageForm").submit();
	return false;
}

//注册用户名验证
function userNameMouseOver(){
	userName = $("#userName").val()
	flag = false
	var un = /^[\u4e00-\u9fa5_0-9a-zA-Z{4,10}]*$/g
	if(!un.test(userName)){
		flag = false
    	$("#userName_div").html("请输入4-10个字符的中英文或数字")
    }else {
		flag = true
    	$("#userName_div").html("")
    }
	
	if (flag){
		//异步验证用户名是否已存在
	    data = {
	    	userName: userName,
	    }
	    $.ajax({
	    	type: 'POST',
	    	url: 'user/verifyUserName.html',
	    	data: data,
	    	success: function(result){
	    		if (result=='true') {
	    			$("#userName_div").html("该用户吗已存在！")
	    		}else {
	    			$("#userName_div").html("")
	    		}
	    	}
	    })
	}
    
}

//注册密码验证
function passWordMouseOver(){
	passWord = $("#passWord").val()
	var regex = new RegExp('(?=.*[a-zA-Z0-9]).{4,20}')
	console.log(regex.test(passWord))
	if (!regex.test(passWord)) {
		$("#passWord_div").html("密码必须是数字+字母,在4-20字符之间")
	}else {
		$("#passWord_div").html("")
	}
}

//修改密码 密码验证
function changepassWordMouseOver(){
	changepassWord = $("#changepassWord").val()
	var regex = new RegExp('(?=.*[a-zA-Z0-9]).{4,20}')
	console.log(regex.test(changepassWord))
	if (!regex.test(changepassWord)) {
		$("#changepassWord_div").html("密码必须是数字+字母,在4-20字符之间")
	}else {
		$("#changepassWord_div").html("")
	}
}


//注册密码验证
function passWord2MouseOver(){
	passWord = $("#passWord").val()
	passWord2 = $("#passWord2").val()
	
	if (passWord != passWord2) {
		$("#passWord2_div").html("两次输入的密码不一致")
		$("#changepassWord2_div").html("两次输入的密码不一致")
	}else {
		$("#passWord2_div").html("")
		$("#changepassWord2_div").html("")
	}
}


//修改密码 密码验证
function changepassWord2MouseOver(){
	changepassWord = $("#changepassWord").val()
	changepassWord2 = $("#changepassWord2").val()
	
	if (changepassWord != changepassWord2) {
		$("#changepassWord2_div").html("两次输入的密码不一致")
	}else {
		$("#changepassWord2_div").html("")
	}
}


//注册邮箱验证
function emailMouseOver(){
	email = $("#email").val()

	var ePattern = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/
	
	if (!ePattern.test(email)) {
		$("#email_div").html("邮箱格式不正确")
	}else {
		$("#email_div").html("")
	}
}

//注册
function checkRegister(){
	flag = false
	userName_div = $("#userName_div").html()
	passWord_div = $("#passWord_div").html()
	passWord2_div = $("#passWord2_div").html()
	email_div = $("#email_div").html()

	userName = $("#userName").val()
	passWord = $("#passWord").val()
	email = $("#email").val()

	if (userName_div == "" && passWord_div == "" && passWord2_div == "" && email_div == "" && userName != "" && passWord != "" && email != "") {
		flag = true
	}
	return flag
}


//修改密码
function checkPassword(){
	flag = false
	changepassWord_div = $("#changepassWord_div").html()
	changepassWord2_div = $("#changepassWord2_div").html()
	
	changepassWord = $("#changepassWord").val()
	
	if (changepassWord_div == "" && changepassWord2_div == "" && changepassWord != "") {
		flag = true
	}
	return flag
}

//登陆用户名非空验证
function userNameLoginMouseOver(){
	userName = $("#userNameLogin").val()
	if(userName==""){
		$("#login_div").html("")
    	$("#userNameLogin_div").html("用户名不允许为空！")
    }else {
    	$("#userNameLogin_div").html("")
    }
}

//登陆密码非空验证
function passWordLoginMouseOver(){
	passWordLogin = $("#passWordLogin").val()
	if (passWordLogin == "") {
		$("#passWordLogin_div").html("密码不允许为空")
	}else {
		$("#passWordLogin_div").html("")
	}
}


//登陆
function checkLogin(){
	flag = false
	userNameLogin_div = $("#userNameLogin_div").html()
	passWordLogin_div = $("#passWordLogin_div").html()

	userNameLogin = $("#userNameLogin").val()
	passWordLogin = $("#passWordLogin").val()

	if (userNameLogin_div == "" && passWordLogin_div == "" && userNameLogin != "" && passWordLogin != "") {
		
		data = {
			userName: userNameLogin,
			userPwd: passWordLogin,
		}
		
		$.ajax({
			async: false,
			type: "POST",
			url: "user/loginUser.html",
			data: data,
			success: function(result){
				if (result == 'true') {
					flag = true
	    		}else {
	    			$("#login_div").html("账号或者密码错误")
	    		}
			}
			
		})
		
	}

	return flag
}

function blackLiuYan(){
	alert("该账号禁止发言")
	return false
}

	