
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

function page(n, s, i) {
	$("#pageNo").val(n);
	$("#pageSize").val(s);
	$("#index").val(i);
	$("#pageForm").submit();
	return false;
}
//用户名验证
function userNameMouseOver(){
	userName = $("#userName").val()

	var un = /^[\u4e00-\u9fa5_0-9a-zA-Z{4,10}]*$/g
	if(!un.test(userName)){
    	$("#userName_div").html("请输入4-10个字符的中英文或数字")
    }else {
    	$("#userName_div").html("")
    }

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

//密码验证
function passWordMouseOver(){
	passWord = $("#passWord").val()
	var regex = new RegExp('(?=.*[a-zA-Z]).{4,20}')
	console.log(regex.test(passWord))
	if (!regex.test(passWord)) {
		$("#passWord_div").html("密码必须在4-20字符之间")
	}else {
		$("#passWord_div").html("")
	}
}

//密码验证
function passWord2MouseOver(){
	passWord = $("#passWord").val()
	passWord2 = $("#passWord2").val()
	
	if (passWord != passWord2) {
		$("#passWord2_div").html("两次输入的密码不一致")
	}else {
		$("#passWord2_div").html("")
	}
}

//邮箱验证
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
	