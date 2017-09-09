function deleteLiuYan(id){
	data = {
		id: id,
	}
	$.ajax({
		type: "POST",
		data: data,
		url: "message/all/delete.html",
		success: function(result){
			if (result){
				alert("删除留言成功")
				location.reload()
			}else {
				alert("删除错误")
			}
		}
	})
}

function pinglunDelete(id){
	data = {
		id: id,
	}
	$.ajax({
		type: "POST",
		data: data,
		url: "message/all/deletePingLun.html",
		success: function(result){
			if (result){
				alert("删除评论成功")
				location.reload()
			}else {
				alert("删除错误")
			}
		}
	})
}


function hidehuifu(){
	for (var i = 0;i < 8;i++){
		 $("#liuyan_div_huifu"+i).css('display','none')
		}
}

function showhuifu(id){

	if($("#liuyan_div_huifu"+id).css("display") == 'block'){
		hidehuifu()
	}else {
		hidehuifu()
		$("#liuyan_div_huifu"+id).css('display','block')
	}
}

