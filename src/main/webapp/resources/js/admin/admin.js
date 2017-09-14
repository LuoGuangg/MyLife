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