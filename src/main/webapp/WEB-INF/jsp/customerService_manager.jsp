<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script>

$(function(){
	$("#createPeople").val('${currentUser.name}');
	$("#createTime").val(Util.getCurrentDateTime());
})
function submitForm(){
	$.messager.progress();	// 显示进度条
	$('#form').form('submit', {    
	    url:'${ctx}/customerService/addCustomerService.action',    
	    onSubmit: function(){    
	    },    
	    success:function(data){//正常返回ServerResponse
	    	$.messager.progress('close');	// 如果表单是无效的则隐藏进度条
	    	var data = eval('(' + data + ')');
	    	if(data.status == Util.SUCCESS) {
	    		$.messager.show({
					title:'系统提示',
					msg:data.msg,
					timeout:3000,
					showType:'fade'
				});
	    		$('#form').form('reset');
	    		$("#createPeople").val('${currentUser.name}');
	    		$("#createTime").val(Util.getCurrentDateTime());
	    	}
	    	else {
				$.messager.alert('系统提示',data.msg);
			}
	    }    
	});  
}
function clearForm(){
	$('#form').form('reset');
	$("#createPeople").val('${currentUser.name}');
	$("#createTime").val(Util.getCurrentDateTime());
}
</script>

</head>
<body>
	<!-- 添加和修改的dialog 开始 -->
	<div style="margin-top: 50px; margin-left: 50px;">
	<div id="dialog" class="easyui-panel" iconCls="icon-fwcj" title="客户服务创建" style="width:650;height:280,padding: 10px 20px">
		<form action="" id="form" method="post">
			<input type="hidden" id="id" name="id"/>
			<table cellspacing="8px">
		   		<tr>
		   			<td>服务类型：</td>
					<td>
						<select style="width: 160px;" class="easyui-combobox" id="serviceType" panelHeight='auto' name="serviceType" editable="false">
							<option value=""></option>
							<option value="1">咨询</option>
							<option value="2">建议</option>
							<option value="3">投诉</option>
						</select>
						<font color="red">*</font>
					</td>
		   			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		   			<td>客户：</td>
		   			<td><input type="text" id="customer" name="customer" /></td>
		   		</tr>
		   		<tr>
		   			<td>概要：</td>
		   			<td colspan="4"><input type="text" id="overview" name="overview" style="width: 420px"/></td>
		   		</tr>
		   		<tr>
		   			<td>服务请求：</td>
		   			<td colspan="4">
		   				<textarea rows="5" cols="50" id="serviceRequest" name="serviceRequest"></textarea>
		   			</td>
		   		</tr>
		   		<tr>
		   			<td>创建人：</td>
		   			<td><input type="text" editable="false" id="createPeople" name="createPeople" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
		   			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		   			<td>创建时间：</td>
		   			<td><input type="text" readonly="true" id="createTime" name="createTime"/>&nbsp;<font color="red">*</font></td>
		   		</tr>
		   	</table>
		</form>
		<div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" iconCls="icon-ok" class="easyui-linkbutton" onclick="submitForm()">保存</a>
	    	<a href="javascript:void(0)" iconCls="icon-redo" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	    </div>
	</div>
	</div>
	<!-- 添加和修改的dialog 结束 -->
	

</body>
</html>