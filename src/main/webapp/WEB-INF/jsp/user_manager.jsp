<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table id="datagrid" class="easyui-datagrid" title="DataGrid with Toolbar" pagination="true" fitColumns="true"
		data-options="rownumbers:true,fit:true,singleSelect:false,url:'${ctx}/user/findAll.action',method:'get',toolbar:'#toolbar'">
		<thead>
			<tr>
				<th data-options="field:'cb',align:'center',checkbox:true"></th>
				<th data-options="field:'id',width:80,align:'center'">编号</th>
				<th data-options="field:'userName',width:100,align:'center'">用户名</th>
				<th data-options="field:'password',width:80,align:'center'">密码</th>
				<th data-options="field:'trueName',width:80,align:'center'">真实姓名</th>
				<th data-options="field:'email',width:140,align:'center'">邮件</th>
				<th data-options="field:'phone',width:100,align:'center'">联系电话</th>
				<th data-options="field:'roleName',width:100,align:'center'">角色</th>
			</tr>
		</thead>
	</table>
	
	<!-- toolbar -->
	<div id="toolbar">
		<a class="easyui-linkbutton" onclick="$('#w').window('open')" iconCls="icon-add">添加</a>
		<a class="easyui-linkbutton" iconCls="icon-edit">修改</a>
		<a class="easyui-linkbutton" href="javascript:doDelete()" iconCls="icon-remove">删除</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input class="easyui-searchbox" data-options="prompt:'用户名',searcher:doSearch" style="width:120px"/>
	</div>
	
	<!-- add -->
	<div id="w" class="easyui-window" title="添加用户" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:350px;padding:10px;">
		<div style="padding:10px auto">
	    <form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>用户名:</td>
	    			<td><input class="easyui-textbox" type="text" name="userName" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>密码:</td>
	    			<td><input class="easyui-textbox"  type="password" name="password" data-options="multiline:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>真实姓名:</td>
	    			<td><input class="easyui-textbox" type="text" name="trueName" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>邮件:</td>
	    			<td><input class="easyui-textbox" type="text" name="email" data-options="required:true,validType:'email'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>联系电话:</td>
	    			<td><input class="easyui-textbox" type="text" name="phone" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>角色:</td>
	    			<td><input class="easyui-textbox" type="text" name="roleName" data-options="required:true"></input></td>
	    		</tr>
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">Submit</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
	    </div>
	    </div>
	</div>


<script>

function submitForm() {
	var options = {
			url:"${ctx}/user/addUser.action",
			type:"post",
			dateType:"json",
			data:$("#ff").serialize(),
			success:function(data){
				if(data.status == 0){
					$.messager.show({
						title:'系统提示',
						msg:data.msg,
						timeout:3000,
						showType:'fade'
					});
					$('#w').window('close');
					$("#datagrid").datagrid("reload");
				}else {
					$.messager.alert('系统提示','添加数据失败！');
				}
			}
	}
	$.ajax(options)
};

function clearForm() {
	$("#ff")[0].reset();
};

function doSearch(value){
	$("#datagrid").datagrid("load",{
		'userName' : value
	})
};

function doDelete() {
	var selectIds = $("#datagrid").datagrid("getSelections");
	var ids = [];
	for(var i in selectIds) {
		ids.push(selectIds[i].id)
	}
	ids = ids.join(",");
	if(ids.length == 0) {
		$.messager.alert('系统提示','请选择要删除的数据！');
		return;
	}
	$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
	    if (r){    
	    	$.post(
					"${ctx}/user/delete.action",
					{ids:ids}, 
					function(result) {
						$.messager.show({
							title:'系统提示',
							msg:result.msg,
							timeout:3000,
							showType:'fade'
						});
						if(result.status == 0) {
							$("#datagrid").datagrid("reload");
						}
					},
					"json"
				);
	    }    
	}); 
}

</script>
</body>
</html>