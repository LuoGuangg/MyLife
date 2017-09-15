/*
 * 分页
 */
function page(n, s, i) {
	$("#pageNo").val(n);
	$("#pageSize").val(s);
	$("#index").val(i);
	$("#pageForm").submit();
	return false;
}
/*
 * 用户拉黑解封 
 */
function blacklist(id){
	var data = {
		id: id,
	}
	
	$.ajax({
		type: "POST",
		url: "admin/black.html",
		data: data,
		success: function(result){
			console.log("sss")
			location.reload()
		}
	})
	
}