
//创建
function checkPerson(){
	console.log("来了2")
	flag = false
	
	name = $("#name").val()
	var reg = /^[\u4E00-\u9FA5]+$/; 

	console.log(reg.test(name))
	if(reg.test(name)){
		
		var data = {
				name: name
		}
		
		$.ajax({
			async: false,
			type: "POST",
			url: "yzName.html",
			data: data,
			success: function(result){
				if (result == 'true') {
					flag = true;
	    		}else {
	    			alert("姓名已存在，请重新输入")
	    			flag = false;
	    		}
			}
			
		})
		
	}else{
		alert("姓名必须为中午，请重新输入")
	}
	return flag
}

	