<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>欢迎进入CRM管理系统</title>
<script type="text/javascript">  
     var ctx="${pageContext.request.contextPath}";  
</script>

<%-- <script type="text/javascript" src="${ctx}/resources/js/common.js"></script> --%>
<script type="text/javascript" src="${ctx}/resources/js/common.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/thirdlib/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/resources/thirdlib/jquery-easyui/themes/icon.css">
<script type="text/javascript" src="${ctx}/resources/thirdlib/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/thirdlib/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/thirdlib/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<div style="margin: 150px 500px;">
<div class="easyui-panel" title="Login to system" style="width:400px;padding:30px 70px 20px 70px;">
	<div style="margin-bottom:10px">
		<input class="easyui-textbox" id="name" style="width:100%;height:40px;padding:12px" data-options="prompt:'Username',iconCls:'icon-man',iconWidth:38">
	</div>
	<div style="margin-bottom:20px">
		<input class="easyui-textbox" id="password" type="password" style="width:100%;height:40px;padding:12px" data-options="prompt:'Password',iconCls:'icon-lock',iconWidth:38">
	</div>
	<div style="margin-bottom:20px">
		<input type="checkbox" checked="checked">
		<span>Remember me</span>
	</div>
	<div>
		<a href="javascript:login()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:100%;">
			<span style="font-size:14px;">Login</span>
		</a>
	</div>
</div>
</div>
<script type="text/javascript">
function login(){
	var name = $("#name").val();
	var password = $("#password").val();
	$.ajax({
		 type : 'post',
        url : "${ctx}/login/login2.action", //url
        data :{"name":name,
        	"password":password
        	}, //data
        success : function(data) { //callback
       	if(data.status == Util.SUCCESS) {
       		$.messager.show({
				title:'系统提示',
				msg:data.msg,
				timeout:3000,
				showType:'fade'
			});
	       		window.location.href="${ctx}/index/index.action";
           } else {
        	   $.messager.alert('系统提示',data.msg);
           }
       }
});
}
</script>
</body>
</html>